package unamur.info.bloc3.locfood.database.dao.interfaces;

import java.util.List;

import unamur.info.bloc3.locfood.models.Recette;

public interface RecetteDAO {

    List<Recette> getRecetteForSeason(String season);

    List<Recette> getRecetteForSearch(String query);
}
