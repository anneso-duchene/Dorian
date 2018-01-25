package unamur.info.bloc3.locfood.database;

import android.content.Context;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import unamur.info.bloc3.locfood.LocFoodApplication;
import unamur.info.bloc3.locfood.R;

public class LocFoodDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "locfood.db";
    private Context context;

    public LocFoodDbHelper(Context context) {
        super(context, LocFoodApplication.getInstance().getApplicationContext().getDatabasePath(DATABASE_NAME).getPath(), null, DATABASE_VERSION);
        this.context = context;
    }

    public LocFoodDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    public LocFoodDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("TAG", "onCreate");
        readAndExecuteSQLScript(sqLiteDatabase, context, R.raw.locfood_v1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    private void readAndExecuteSQLScript(SQLiteDatabase db, Context ctx, Integer sqlScriptResId) {
        Resources res = ctx.getResources();
        try {
            InputStream is = res.openRawResource(sqlScriptResId);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            executeSQLScript(db, reader);
            reader.close();
            is.close();
        } catch (IOException e) {
            throw new RuntimeException("Unable to read SQL script", e);
        }
    }

    private void executeSQLScript(SQLiteDatabase db, BufferedReader reader) throws IOException {
        String line;
        StringBuilder statement = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            statement.append(line);
            statement.append("\n");//probably could be removed
            if (line.endsWith(";")) {
                String toExec = statement.toString();
                db.execSQL(toExec);
                statement = new StringBuilder();
            }
        }
    }
}
