package unamur.info.bloc3.locfood.database.dao.impl;

import android.database.Cursor;

import unamur.info.bloc3.locfood.database.dao.interfaces.UniteDAO;
import unamur.info.bloc3.locfood.models.Unite;

public class UniteDAOImpl implements UniteDAO {

    public static final String TABLE_NAME = "Unite";
    private static final String ID = "id_unite";
    private static final String NAME = "nom_unite";

    public static final String[] COLUMN = {ID, NAME};

    public static Unite cursorToModel(Cursor cursor) {
        if (cursor.moveToNext()) {
            Unite unite = new Unite();
            unite.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            unite.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            return unite;
        } else {
            return null;
        }
    }

}

