package be.bxl.formation.demo_05_fragement.models;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;

public class DevTechnology {

    public enum TechnoEnum {
        LIBRARY,
        FRAMEWORK,
        LANGUAGE,
        PLATEFORM
    }

    //region Champs
    private long id;
    @NonNull
    private String name;
    private String desc;
    private TechnoEnum techno;
    @RawRes
    private int resImg;
    //endregion

    //region Constructeur
    public DevTechnology(long id, @NonNull String name, String desc, TechnoEnum techno, @RawRes int resImg) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.techno = techno;
        this.resImg = resImg;
    }
    //endregion

    //region Getters et Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TechnoEnum getTechno() {
        return techno;
    }

    public void setTechno(TechnoEnum techno) {
        this.techno = techno;
    }

    @RawRes
    public int getResImg() {
        return resImg;
    }

    public void setResImg(@RawRes int resImg) {
        this.resImg = resImg;
    }
    //endregion

}
