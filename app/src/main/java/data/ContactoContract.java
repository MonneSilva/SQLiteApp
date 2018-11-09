package data;
import android.provider.BaseColumns;
public class ContactoContract {
    public static abstract class ContactoEntry implements BaseColumns
    {
        public static final String TABLE_NAME ="contacto";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String TELEFONO = "telefono";
        public static final String CELULAR = "celular";
       // public static final String AVATAR_URI = "avatarUri";
        public static final String CORREO = "correo";
    }

}
