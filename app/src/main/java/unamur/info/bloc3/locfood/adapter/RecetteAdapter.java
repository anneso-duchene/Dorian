package unamur.info.bloc3.locfood.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import unamur.info.bloc3.locfood.Constant;
import unamur.info.bloc3.locfood.R;
import unamur.info.bloc3.locfood.activities.MainActivity;
import unamur.info.bloc3.locfood.models.Recette;

public class RecetteAdapter extends RecyclerView.Adapter<RecetteAdapter.ViewHolder> {

    private Context context;
    private MainActivity mainActivity;
    private List<Recette> recetteList;

    public RecetteAdapter(MainActivity mainActivity, Context context, List<Recette> contactList) {
        this.recetteList = contactList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cell_recette, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Recette recette = recetteList.get(position);

        holder.title.setText(recette.getName());

        String persTxt = context.getString(R.string.nb_pers) + " " + recette.getNbPers();
        holder.nbPers.setText(persTxt);

        String timeTxt = context.getString(R.string.time) + " " + recette.getTotalTime();
        holder.time.setText(timeTxt);

        String tagsTxt;
        if (recette.getTags().length() > 18) {
            tagsTxt = recette.getTags().substring(0, 18) + "...";
        } else {
            tagsTxt = recette.getTags();
        }


        holder.tags.setText(tagsTxt);

        if (recette.getSeason().equals(Constant.Season.FALL)) {
            holder.background.setBackgroundResource(R.color.fall);
        } else if (recette.getSeason().equals(Constant.Season.WINTER)) {
            holder.background.setBackgroundResource(R.color.winter);
        } else if (recette.getSeason().equals(Constant.Season.SPRING)) {
            holder.background.setBackgroundResource(R.color.spring);
        } else if (recette.getSeason().equals(Constant.Season.SUMMER)) {
            holder.background.setBackgroundResource(R.color.summer);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.openRecette(recetteList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return recetteList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, nbPers, time, tags;
        private View background;

        public ViewHolder(View v) {
            super(v);
            background = v.findViewById(R.id.background);
            title = v.findViewById(R.id.title);
            nbPers = v.findViewById(R.id.nb_pers);
            time = v.findViewById(R.id.time);
            tags = v.findViewById(R.id.tags);
        }

    }
}
