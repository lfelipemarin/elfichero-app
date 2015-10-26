package co.org.elfichero.appelfichero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by felipe on 26/10/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String TAG = DbHelper.class.getSimpleName();

    public DbHelper(Context context) {
        super(context, NoticiasContract.DB_NAME, null, NoticiasContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = String.format("create table %s (%s int primary key, %s blob, %s text, %s text, %s text, %s text," +
                        "%s int)",
                NoticiasContract.TABLE,
                NoticiasContract.Column.ID,
                NoticiasContract.Column.IMAGEN,
                NoticiasContract.Column.USUARIO,
                NoticiasContract.Column.CATEGORIA,
                NoticiasContract.Column.DESCRIPCION,
                NoticiasContract.Column.NOTICIA,
                NoticiasContract.Column.CREATED_AT);

        Log.d(TAG, "onCreate with SQL: " + sql);
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + NoticiasContract.TABLE);
        onCreate(sqLiteDatabase);
    }
}
