package unamur.info.bloc3.locfood.database.dao.impl;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import unamur.info.bloc3.locfood.LocFoodApplication;
import unamur.info.bloc3.locfood.database.dao.interfaces.RecetteIngredientDAO;
import unamur.info.bloc3.locfood.models.RecetteIngredient;

public class RecetteIngredientDAOImpl implements RecetteIngredientDAO {

    public static final String TABLE_NAME = "Recette";
    private static final String ID = "id_ingredient_recette";
    private static final String NOM_UNITE = "nom_unite";
    private static final String NOM_INGREDIENT = "nom_ingredient";
    private static final String QUANTITE = "quantite";


    @Override
    public List<RecetteIngredient> getRecetteIngredientForRecette(int recetteId) {
        List<RecetteIngredient> results = new ArrayList<>();
        Cursor cursor = null;
        try {

            String sql = "SELECT distinct rec_ingr.id_ingredient_recette, rec_ingr.quantite, rec_ingr.id_ingredient_recette, ingr.nom_ingredient, unite.nom_unite " +
                    "FROM recette_ingredient rec_ingr " +
                    "inner join unite unite on unite.id_unite = rec_ingr.id_unite " +
                    "inner join ingredient ingr on ingr.id_ingredient = rec_ingr.id_ingredient " +
                    "where rec_ingr.id_recette = " + recetteId;


            cursor = LocFoodApplication.getInstance().getDatabaseHelper().getReadableDatabase().rawQuery(sql, null);
            while (cursor.moveToNext()) {
                RecetteIngredient recetteIngredient = cursorToModel(cursor);
                results.add(recetteIngredient);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return results;
    }

    public static RecetteIngredient cursorToModel(Cursor cursor) {
        RecetteIngredient unite = new RecetteIngredient();
        unite.setId(cursor.getInt(cursor.getColumnIndex(ID)));
        unite.setNomUnite(cursor.getString(cursor.getColumnIndex(NOM_UNITE)));
        unite.setIngredientName(cursor.getString(cursor.getColumnIndex(NOM_INGREDIENT)));
        unite.setQuantite(cursor.getInt(cursor.getColumnIndex(QUANTITE)));
        return unite;
    }
}
