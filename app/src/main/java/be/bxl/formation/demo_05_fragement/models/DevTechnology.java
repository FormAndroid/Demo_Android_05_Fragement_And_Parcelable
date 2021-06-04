package be.bxl.formation.demo_05_fragement.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;

// Tips : Implementation automatique via  "Alt+Enter -> Add Parcelable Implementation"
public class DevTechnology implements Parcelable {

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


    @Override
    public String toString() {
        return name;
    }

    //region Implementation necessaire pour le Parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Découpe les données sous forme de parcel
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(techno.name());
        dest.writeInt(resImg);
    }

    @Override
    public int describeContents() {
        // Défini le nombre d'objet complexe contenu dans mon objet (Parcelable / Serializable)
        return 0;
    }

    DevTechnology(Parcel parcel) {
        // Recréer l'objet via la parcel => Atttention l'ordre doit être identique au "writeToParcel"
        this.id = parcel.readLong();
        this.name = parcel.readString();
        this.desc = parcel.readString();
        this.techno = TechnoEnum.valueOf(parcel.readString());
        this.resImg = parcel.readInt();
    }

    // Définition d'un CREATOR => Permet de recréer l'objet depuis la parcel
    public static final Parcelable.Creator<DevTechnology> CREATOR = new Creator<DevTechnology>() {
        @Override
        public DevTechnology createFromParcel(Parcel source) {
            return new DevTechnology(source);
        }

        @Override
        public DevTechnology[] newArray(int size) {
            return new DevTechnology[size];
        }
    };
    //endregion
}
