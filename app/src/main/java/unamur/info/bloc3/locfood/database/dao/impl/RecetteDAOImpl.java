package unamur.info.bloc3.locfood.database.dao.impl;

import android.database.Cursor;

import unamur.info.bloc3.locfood.database.dao.interfaces.RecetteDAO;
import unamur.info.bloc3.locfood.models.Recette;

public class RecetteDAOImpl implements RecetteDAO {

    public static final String TABLE_NAME = "Recette";
    private static final String ID = "id_recette";
    private static final String NAME = "nom_recette";
    private static final String NB_PERS = "nbr_personne";
    private static final String TOTAL_TIME = "temps_total";
    private static final String PREPA_TIME = "temps_prepa";
    private static final String COOK_TIME = "temps_cuisson";
    private static final String STEPS = "etapes";
    private static final String SEASON = "saison";
    private static final String TAGS = "tags";

    public static final String[] COLUMN = {ID, NAME, NB_PERS, TOTAL_TIME, PREPA_TIME, COOK_TIME, STEPS, SEASON, TAGS};

    public static Recette cursorToModel(Cursor cursor) {
        if (cursor.moveToNext()) {
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
        } else {
            return null;
        }
    }

}
