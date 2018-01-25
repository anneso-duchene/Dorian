package unamur.info.bloc3.locfood.models;

/**
 * Created by aduc on 25/01/18.
 */

public class Recette {

    private int id, nbPers;
    private String name, step, season, tags, totalTime, prepaTime, cookTime;

    public Recette() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getPrepaTime() {
        return prepaTime;
    }

    public void setPrepaTime(String prepaTime) {
        this.prepaTime = prepaTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public int getNbPers() {
        return nbPers;
    }

    public void setNbPers(int nbPers) {
        this.nbPers = nbPers;
    }
}
