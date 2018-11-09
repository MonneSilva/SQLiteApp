package contactos;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;



import data.ContactoContract;

public class ContactosCursorAdapter extends CursorAdapter {
    public ContactosCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item_contacto, parent, false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
// Referencias UI.
        TextView nameText = (TextView) view.findViewById(R.id.tv_name);
       // final ImageView avatarImage = (ImageView) view.findViewById(R.id.iv_avatar);

        // Get valores.
        String nombre = cursor.getString(cursor.getColumnIndex(ContactoContract.ContactoEntry.NOMBRE));
       // String avatarUri = cursor.getString(cursor.getColumnIndex(LawyerEntry.AVATAR_URI));

        // Setup.
        nameText.setText(nombre);
       /* Glide
                .with(context)
               // .load(Uri.parse("file:///android_asset/" + avatarUri))
                .asBitmap()
               // .error(R.drawable.ic_account_circle)
                .centerCrop()
                .into(new BitmapImageViewTarget(avatarImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable
                                = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCircular(true);
                        avatarImage.setImageDrawable(drawable);
                    }
                });

*/
    }
}
