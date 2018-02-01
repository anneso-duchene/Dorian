package unamur.info.bloc3.locfood.database.dao.impl;

import android.database.Cursor;
import android.database.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;

import unamur.info.bloc3.locfood.LocFoodApplication;
import unamur.info.bloc3.locfood.database.dao.interfaces.RecetteDAO;
import unamur.info.bloc3.locfood.models.Recette;

public class RecetteDAOImpl implements RecetteDAO {

    public static final String TABLE_NAME = "Recette";
    private static final String ID = "id_recette";
    private static final String NAME = "nom_recette";
    private static final String NB_PERS = "nombre_personne";
    private static final String TOTAL_TIME = "temps_total";
    private static final String PREPA_TIME = "temps_prepa";
    private static final String COOK_TIME = "temps_cuisson";
    private static final String STEPS = "etapes";
    private static final String SEASON = "saison";
    private static final String TAGS = "tags";

    public static final String[] COLUMN = {ID, NAME, NB_PERS, TOTAL_TIME, PREPA_TIME, COOK_TIME, STEPS, SEASON, TAGS};

    @Override
    public List<Recette> getRecetteForSeason(String season) {
        List<Recette> results = new ArrayList<>();
        Cursor cursor = null;
        try {

            cursor = LocFoodApplication.getInstance().getDatabaseHelper().getReadableDatabase().query(TABLE_NAME, COLUMN, SEASON + "=?", new String[]{season}, null, null, " RANDOM()");

            int count = 0;
            while (cursor.moveToNext() && count < 3) {
                results.add(cursorToModel(cursor));
                count++;
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

    @Override
    public List<Recette> getRecetteForSearch(String query) {
        List<Recette> results = new ArrayList<>();
        Cursor cursor = null;
        try {

            String sql = "SELECT distinct recette.id_recette, recette.* FROM ingredient ingr " +
                    "inner join recette_ingredient rec_ingr on ingr.id_ingredient = rec_ingr.id_ingredient " +
                    "inner join recette recette on recette.id_recette = rec_ingr.id_recette " +
                    "where ingr.nom_ingredient LIKE " + DatabaseUtils.sqlEscapeString("%" + query + "%") + " " +
                    "OR recette.nom_recette LIKE " + DatabaseUtils.sqlEscapeString("%" + query + "%") + " " +
                    "OR recette.tags LIKE " + DatabaseUtils.sqlEscapeString("%" + query + "%") + " " +
                    "OR recette.saison LIKE " + DatabaseUtils.sqlEscapeString("%" + query + "%") + " ";


            cursor = LocFoodApplication.getInstance().getDatabaseHelper().getReadableDatabase().rawQuery(sql, null);
            while (cursor.moveToNext()) {
                Recette recette = cursorToModel(cursor);
                if (!results.contains(recette)) {
                    results.add(recette);
                }
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

    @Override
    public Recette getRecetteById(int recetteId) {
        Recette result = null;
        Cursor cursor = null;
        try {

            cursor = LocFoodApplication.getInstance().getDatabaseHelper().getReadableDatabase().query(TABLE_NAME, COLUMN, ID + "=?", new String[]{String.valueOf(recetteId)}, null, null, NAME + " ASC");
            if (cursor.moveToFirst()) {
                result = cursorToModel(cursor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return result;
    }

    public static Recette cursorToModel(Cursor cursor) {
        Recette unite = new Recette();
        unite.setId(cursor.getInt(cursor.getColumnIndex(ID)));
        unite.setNbPers(cursor.getInt(cursor.getColumnIndex(NB_PERS)));
        unite.setName(cursor.getString(cursor.getColumnIndex(NAME)));
        unite.setTotalTime(cursor.getString(cursor.getColumnIndex(TOTAL_TIME)));
        unite.setPrepaTime(cursor.getString(cursor.getColumnIndex(PREPA_TIME)));
        unite.setCookTime(cursor.getString(cursor.getColumnIndex(COOK_TIME)));
        unite.setStep(cursor.getString(cursor.getColumnIndex(STEPS)));
        unite.setSeason(cursor.getString(cursor.getColumnIndex(SEASON)));
        unite.setTags(cursor.getString(cursor.getColumnIndex(TAGS)));
        return unite;
    }
}
