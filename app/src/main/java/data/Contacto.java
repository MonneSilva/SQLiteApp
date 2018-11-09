package data;

import android.content.ContentValues;
import android.database.Cursor;



import java.util.UUID;

public class Contacto {
    private String id;
    private String nombre;
    private String telefono;
    private String celular;
    private String correo;
   // private String avatarUri;

    public Contacto(String nombre, String telefono,
                    String celular,String correo)
    {
        this.nombre = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.celular = correo;
        //this.avatarUri = avatarUri;
    }

    public String getId() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

   /* public String getAvatarUri() {
        return avatarUri;
    }*/

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(ContactoContract.ContactoEntry.ID, id);
        values.put(ContactoContract.ContactoEntry.NOMBRE, nombre);
        values.put(ContactoContract.ContactoEntry.TELEFONO, telefono);
        values.put(ContactoContract.ContactoEntry.CELULAR, celular);
        values.put(ContactoContract.ContactoEntry.CORREO, correo);
        return values;
    }

}
