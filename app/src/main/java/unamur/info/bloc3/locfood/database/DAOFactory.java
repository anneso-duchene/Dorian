package unamur.info.bloc3.locfood.database;

import unamur.info.bloc3.locfood.database.dao.impl.IngredientDAOImpl;
import unamur.info.bloc3.locfood.database.dao.impl.RecetteDAOImpl;
import unamur.info.bloc3.locfood.database.dao.impl.RecetteIngredientDAOImpl;
import unamur.info.bloc3.locfood.database.dao.impl.UniteDAOImpl;
import unamur.info.bloc3.locfood.database.dao.interfaces.IngredientDAO;
import unamur.info.bloc3.locfood.database.dao.interfaces.RecetteDAO;
import unamur.info.bloc3.locfood.database.dao.interfaces.RecetteIngredientDAO;
import unamur.info.bloc3.locfood.database.dao.interfaces.UniteDAO;

public class DAOFactory {

    public static DAOFactory instance;
    private IngredientDAO ingredientDAO;
    private RecetteDAO recetteDAO;
    private RecetteIngredientDAO recetteIngredientDAO;
    private UniteDAO uniteDAO;


    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public IngredientDAO getIngredientDAO() {
        if (ingredientDAO == null) {
            ingredientDAO = new IngredientDAOImpl();
        }
        return ingredientDAO;
    }

    public RecetteDAO getRecetteDAO() {
        if (recetteDAO == null) {
            recetteDAO = new RecetteDAOImpl();
        }
        return recetteDAO;
    }

    public RecetteIngredientDAO getRecetteIngredientDAO() {
        if (recetteIngredientDAO == null) {
            recetteIngredientDAO = new RecetteIngredientDAOImpl();
        }
        return recetteIngredientDAO;
    }

    public UniteDAO getUniteDAO() {
        if (uniteDAO == null) {
            uniteDAO = new UniteDAOImpl();
        }
        return uniteDAO;
    }
}

