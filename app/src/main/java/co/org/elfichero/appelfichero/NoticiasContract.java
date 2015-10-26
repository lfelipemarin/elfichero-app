package co.org.elfichero.appelfichero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by felipe on 26/10/15.
 */
public class NoticiasContract {

    public static final String DB_NAME = "noticias.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "articulos";
    public static final String DEFAULT_SORT = Column.CREATED_AT + " DESC";

    //provider specific constants
    public static final String AUTHORITY = "co.org.elfichero.appelfichero.NoticiasProvider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE);
    public static final int STATUS_ITEM = 1;
    public static final int STATUS_DIR = 2;

    public static final String STATUS_TYPE_ITEM = "vnd.android.cursor.item/vnd.co.org.elfichero.appelfichero.provider.noticias";
    public static final String STATUS_TYPE_DIR = "vnd.android.cursor.dir/vnd.co.org.elfichero.appelfichero.provider.noticias";

    public class Column{

        public static final String ID = BaseColumns._ID;
        public static final String IMAGEN = "imagen";
        public static final String USUARIO = "usuario";
        public static final String CATEGORIA = "categoria";
        public static final String DESCRIPCION = "descripcion";
        public static final String NOTICIA = "noticia";
        public static final String CREATED_AT = "created_at";
    }
}
