package unamur.info.bloc3.locfood;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;

import unamur.info.bloc3.locfood.database.LocFoodDbHelper;

/**
 * Created by aduc on 25/01/18.
 */

public class LocFoodApplication extends Application {


    private static LocFoodApplication instance;
    private LocFoodDbHelper dbHelper;

    public LocFoodApplication() {

    }

    public synchronized static LocFoodApplication getInstance() {
        if (instance == null) {
            instance = new LocFoodApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Log.e("TAG", "onCreate");

        // to create DB
         getDatabaseHelper().getReadableDatabase();

    }

    public LocFoodDbHelper getDatabaseHelper() {
        if (dbHelper == null) {
            File DB_PATH = getApplicationContext().getDatabasePath(LocFoodDbHelper.DATABASE_NAME);
            DB_PATH.getParentFile().mkdirs();
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DB_PATH, null);
            db.close();

            dbHelper = new LocFoodDbHelper(this);
        }
        return dbHelper;
    }
}
