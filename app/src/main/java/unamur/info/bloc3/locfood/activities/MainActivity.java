package unamur.info.bloc3.locfood.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import unamur.info.bloc3.locfood.Constant;
import unamur.info.bloc3.locfood.R;
import unamur.info.bloc3.locfood.Utils;
import unamur.info.bloc3.locfood.adapter.RecetteAdapter;
import unamur.info.bloc3.locfood.database.DAOFactory;
import unamur.info.bloc3.locfood.models.Recette;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private TextView welcome, noResult;
    private RecyclerView recyclerView;
    private RecetteAdapter recetteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);
        welcome = findViewById(R.id.welcome);
        noResult = findViewById(R.id.no_result);
        recyclerView = findViewById(R.id.recycler);

        RecyclerView.LayoutManager rvLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(rvLayoutManager);

        initData();
        initSeach();
    }

    private void initData() {
        welcome.setVisibility(View.VISIBLE);
        noResult.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        String season = Utils.getSeason();

        if (season.equals(Constant.Season.SUMMER)) {
            welcome.setText(getString(R.string.welcome_summer));
        } else if (season.equals(Constant.Season.FALL)) {
            welcome.setText(getString(R.string.welcome_fall));
        } else if (season.equals(Constant.Season.WINTER)) {
            welcome.setText(getString(R.string.welcome_winter));
        } else if (season.equals(Constant.Season.SPRING)) {
            welcome.setText(getString(R.string.welcome_spring));
        }

        searchView.setIconifiedByDefault(false);

        List<Recette> recetteList = DAOFactory.getInstance().getRecetteDAO().getRecetteForSeason(season);
        recetteAdapter = new RecetteAdapter(MainActivity.this, getApplicationContext(), recetteList);
        recyclerView.setAdapter(recetteAdapter);
    }

    private void initSeach() {
        searchView.setQueryHint(getString(R.string.search_query));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                executeSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() == 0) {
                    initData();
                }
                return false;
            }
        });
    }

    public void openRecette(Recette recette) {
        Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
        detailIntent.putExtra(Constant.RECETTE_ID, recette.getId());
        startActivity(detailIntent);
    }

    private void executeSearch(String query) {
        List<Recette> recetteList = DAOFactory.getInstance().getRecetteDAO().getRecetteForSearch(query);
        recetteAdapter = new RecetteAdapter(MainActivity.this, getApplicationContext(), recetteList);
        recyclerView.setAdapter(recetteAdapter);

        welcome.setVisibility(View.GONE);

        if (recetteList.size() == 0) {
            noResult.setText(getString(R.string.no_result));
            noResult.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            noResult.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
}
