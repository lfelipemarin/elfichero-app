package co.org.elfichero.appelfichero.fragments;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.*;
import android.widget.Toast;

import java.util.List;

import co.org.elfichero.appelfichero.NoticiasContract;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class RefreshService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "co.org.elfichero.appelfichero.fragments.action.FOO";
    private static final String ACTION_BAZ = "co.org.elfichero.appelfichero.fragments.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "co.org.elfichero.appelfichero.fragments.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "co.org.elfichero.appelfichero.fragments.extra.PARAM2";
    private static final String TAG = RefreshService.class.getSimpleName();
    boolean isEmpty;

    public RefreshService() {
        super("RefreshService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreated");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Log.d(TAG, "onStarted");
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            //final String username = prefs.getString("username", "");
            //final String password = prefs.getString("password", "");

            /*if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                isEmpty = true;
                return;
            }

            DbHelper dbHelper = new DbHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();*/
            ContentValues values = new ContentValues();

            /*YambaClient cloud = new YambaClient(username, password);
            try {
                List<YambaStatus> timeline = cloud.getTimeline(20);
                for (YambaStatus status : timeline) {
                    //Log.d(TAG, String.format("%s: %s", status.getUser(), status.getMessage()));
                    values.clear();
                    values.put(StatusContract.Column.ID, status.getId());
                    values.put(StatusContract.Column.USER, status.getUser());
                    values.put(StatusContract.Column.MESSAGE, status.getMessage());
                    values.put(StatusContract.Column.CREATED_AT, status.getCreatedAt().getTime());
                    //db.insertWithOnConflict(StatusContract.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);

                    Uri uri = getContentResolver().insert(StatusContract.CONTENT_URI, values);

                    if (uri != null){
                        Log.d(TAG, String.format("%s: %s", status.getUser(), status.getMessage()));
                    }
                }
            } catch (YambaClientException e) {
                Log.d(TAG, "Failed to fetch the timeline", e);
                e.printStackTrace();
            }*/

            int[] id = {23, 54, 5, 8, 45};
            String[] noticia = {
                    "http://www.elfichero.com/clacso2015-un-balance-necesario/",
                    "http://www.elfichero.com/eventos-de-ciudad-susceptibles-de-empalme-fiesta-de-la-diversidad/",
                    "http://www.elfichero.com/la-corte-vuelve-a-ser-el-heroe/",
                    "http://www.elfichero.com/movimientos-sociales-y-construccion-de-paz-en-latinoamerica-iv-final/",
                    "http://www.elfichero.com/hacia-donde-va-el-concejo-de-medellin/",
            };
            String[] descripcion = {
                    "Durante toda esta semana, se llevó a cabo el que sin dudas es el evento de ciencias sociales más importante del continente en este 2015.",
                    "El pasado fin de semana se llevó a cabo en Medellín la tercera edición de la Fiesta de la Diversidad.",
                    "Durante el primer semestre del año el periódico El Espectador reunió 73 fallos con los que la población LGBTI se sumaba importantes victorias.",
                    "Suele afirmarse que Colombia es una democracia –verdad que no suele ser puesta en cuestión- y no puede ser comparada con los regímenes militares del Cono Sur.",
                    "Daniela Maturana es Politóloga de la Universidad EAFIT, hija del reconocido técnico de fútbol Francisco Maturana, del cual seguro heredó su interés por el deporte en la ciudad de Medellín.",
            };
            String[] categoria = {
                    "Actualidad",
                    "Género",
                    "Género",
                    "Opinión",
                    "Actualidad",
            };
            String[] fecha = {
                    "16 noviembre, 2015",
                    "11 noviembre, 2015",
                    "5 noviembre, 2015",
                    "19 noviembre, 2015",
                    "18 noviembre, 2015",
            };
            String[] autor = {
                    " Luisa María López",
                    "Tiffany Andrea Botero Rivera",
                    "Tiffany Andrea Botero Rivera",
                    "Juan Camilo Portela García",
                    " Camilo Andrés Guerra",
            };

            for (int i = 0; i < 5; i++) {
                //Log.d(TAG, String.format("%s: %s", status.getUser(), status.getMessage()));
                values.clear();
                values.put(NoticiasContract.Column.ID, id[i]);
                values.put(NoticiasContract.Column.NOTICIA, noticia[i]);
                values.put(NoticiasContract.Column.USUARIO, autor[i]);
                values.put(NoticiasContract.Column.CREATED_AT, fecha[i]);
                values.put(NoticiasContract.Column.CATEGORIA, categoria[i]);
                values.put(NoticiasContract.Column.DESCRIPCION, descripcion[i]);

                //db.insertWithOnConflict(StatusContract.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);

                Uri uri = getContentResolver().insert(NoticiasContract.CONTENT_URI, values);
                return;
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isEmpty) {
            Toast.makeText(this, "Please update your username an password", Toast.LENGTH_LONG).show();
            isEmpty = false;
        }
        Log.d(TAG, "onDestroyed");
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
