package data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class ContactosAyudanteBD extends  SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Contactos.db";

    public ContactosAyudanteBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ContactoContract.ContactoEntry.TABLE_NAME + " ("
                + ContactoContract.ContactoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ContactoContract.ContactoEntry.ID + " TEXT NOT NULL,"
                + ContactoContract.ContactoEntry.NOMBRE + " TEXT NOT NULL,"
                + ContactoContract.ContactoEntry.TELEFONO + " TEXT NOT NULL,"
                + ContactoContract.ContactoEntry.CELULAR + " TEXT NOT NULL,"
                + ContactoContract.ContactoEntry.CORREO + " TEXT NOT NULL,"
               // + ContactoContract.ContactoEntry.AVATAR_URI + " TEXT,"
                + "UNIQUE (" + ContactoContract.ContactoEntry.ID + "))");
        ContentValues values = new ContentValues();
/*
        // Pares clave-valor
        values.put(ContactoContract.ContactoEntry.ID, "C-001");
        values.put(ContactoContract.ContactoEntry.NOMBRE, "Montserrat Silva");
        values.put(ContactoContract.ContactoEntry.TELEFONO, "7681883");
        values.put(ContactoContract.ContactoEntry.CELULAR, "4921362629");
        values.put(ContactoContract.ContactoEntry.CORREO, "montserratsilvac@gmail.com");
        //values.put(LawyerEntry.AVATAR_URI, "carlos_solarte.jpg");

        // Insertar...
        db.insert(ContactoContract.ContactoEntry.TABLE_NAME, null, values);




    */
        // Insertar datos ficticios para prueba inicial
        mockData(db);

    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockContacto(sqLiteDatabase, new Contacto("Hilario Abraham Rodarte España", "794 840 633",
                "301 200 1111", "españa@correo.com"));
        mockContacto(sqLiteDatabase, new Contacto("Valeria Silva", "894 840 633",
                "301 250 1111", "valeria@correo.com"));
    }

    public long mockContacto(SQLiteDatabase db, Contacto contacto) {
        return db.insert(
                ContactoContract.ContactoEntry.TABLE_NAME,
                null,
                contacto.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long saveLawyer(Contacto contacto) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                ContactoContract.ContactoEntry.TABLE_NAME,
                null,
                contacto.toContentValues());

    }
    public Cursor getAllLawyers() {
        return getReadableDatabase()
                .query(
                        ContactoContract.ContactoEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getLawyerById(String contactoId) {
        Cursor c = getReadableDatabase().query(
                ContactoContract.ContactoEntry.TABLE_NAME,
                null,
                ContactoContract.ContactoEntry.ID + " LIKE ?",
                new String[]{contactoId},
                null,
                null,
                null);
        return c;
    }

}
