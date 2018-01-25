package unamur.info.bloc3.locfood.database.dao.interfaces;

import java.util.List;

import unamur.info.bloc3.locfood.models.RecetteIngredient;

public interface RecetteIngredientDAO {

    List<RecetteIngredient> getRecetteIngredientForRecette(int recetteId);
}
