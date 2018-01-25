package unamur.info.bloc3.locfood.database.dao.impl;

import android.database.Cursor;

import unamur.info.bloc3.locfood.database.dao.interfaces.IngredientDAO;
import unamur.info.bloc3.locfood.models.Ingredient;

public class IngredientDAOImpl implements IngredientDAO {

    public static final String TABLE_NAME = "Ingredient";
    private static final String ID = "id_ingredient";
    private static final String NAME = "nom_ingredient";
    private static final String SEASON = "saison";

    public static final String[] COLUMN = {ID, NAME, SEASON};

    public static Ingredient cursorToModel(Cursor cursor) {
        if (cursor.moveToNext()) {
            Ingredient ingredient = new Ingredient();
            ingredient.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            ingredient.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            ingredient.setSeason(cursor.getString(cursor.getColumnIndex(SEASON)));
            return ingredient;
        } else {
            return null;
        }
    }
}
