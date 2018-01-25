package unamur.info.bloc3.locfood.activities;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import unamur.info.bloc3.locfood.Constant;
import unamur.info.bloc3.locfood.R;
import unamur.info.bloc3.locfood.database.DAOFactory;
import unamur.info.bloc3.locfood.models.Recette;

public class DetailActivity extends AppCompatActivity {

    private Recette recette;
    private TextView name, tags, prepa, steps, ingredients;
    private ImageView season;
    private LinearLayout ingredientsDetails;
    private View background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int idRecette = getIntent().getIntExtra(Constant.RECETTE_ID, -1);

        if (idRecette == -1) {
            finish();
        }


        recette = DAOFactory.getInstance().getRecetteDAO().getRecetteById(idRecette);
        recette.setRecetteIngredients(DAOFactory.getInstance().getRecetteIngredientDAO().getRecetteIngredientForRecette(idRecette));

        setTitle(recette.getName());

        ingredientsDetails = findViewById(R.id.ingredient_layout);
        name = findViewById(R.id.name);
        tags = findViewById(R.id.tags);
        prepa = findViewById(R.id.preparation_detail);
        ingredients = findViewById(R.id.ingredient);
        steps = findViewById(R.id.step_detail);
        season = findViewById(R.id.season);
        background = findViewById(R.id.background);

        initData();
    }

    private void initData() {
        name.setText(recette.getName());
        tags.setText(recette.getTags());

        Resources res = getResources();
        String ingredientTxt = String.format(res.getString(R.string.ingredient), recette.getNbPers());
        ingredients.setText(ingredientTxt);

        String prepaTxt = getString(R.string.time_prepa) + " " + recette.getPrepaTime() + " | " + getString(R.string.time_cook) + " " + recette.getCookTime();
        prepa.setText(prepaTxt);

        steps.setText(Html.fromHtml(recette.getStep()));

        if (recette.getSeason().equals(Constant.Season.FALL)) {
            season.setImageResource(R.drawable.fall);
            background.setBackgroundResource(R.color.fall);
        } else if (recette.getSeason().equals(Constant.Season.WINTER)) {
            season.setImageResource(R.drawable.winter);
            background.setBackgroundResource(R.color.winter);
        } else if (recette.getSeason().equals(Constant.Season.SPRING)) {
            season.setImageResource(R.drawable.spring);
            background.setBackgroundResource(R.color.spring);
        } else if (recette.getSeason().equals(Constant.Season.SUMMER)) {
            season.setImageResource(R.drawable.summer);
            background.setBackgroundResource(R.color.summer);
        }

        initIngredients();
    }

    private void initIngredients() {
        ingredientsDetails.removeAllViews();

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int counter = 0; counter < recette.getRecetteIngredients().size(); counter++) {
            TextView viewTxt = (TextView) inflater.inflate(R.layout.layout_cell_ingredient, null);

            String ingredientDescr = StringUtils.capitalize(recette.getRecetteIngredients().get(counter).getIngredientName()) + ": " +
                    recette.getRecetteIngredients().get(counter).getQuantite() + " ";

            if (!recette.getRecetteIngredients().get(counter).getNomUnite().equals("none")) {
                ingredientDescr = ingredientDescr + recette.getRecetteIngredients().get(counter).getNomUnite();
            }

            viewTxt.setText(ingredientDescr);
            ingredientsDetails.addView(viewTxt);
        }
    }
}
