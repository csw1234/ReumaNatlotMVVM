package com.alonz.reumanatlot_mvvm.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by alonz on 16/11/2017.
 */
@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)
    public int id;
    int type; // 0=Natla, 1=KidushCup, 2 = Meyham, 3= Holders, 4= Sakomonim, 5=Salt
    String Url;
    boolean favorite; //0=not favorite, 1 = favorite
    int color; // 0=Red, 1 =Purple, 2=LightGreen, 3 =LightTurquoise, 4 = White, 5 = Turquoise, 6= Yellow, 7=LightBlue, 8 = Orange
    int serialNumber;

    public Product() {
    }

    public int getIdText(){
        return id;
    }
    public String getUrl(){
        return Url;
    }
    public boolean getFavorite(){
        return favorite;
    }
    public int getColor() {return color;}
    public int getType() {return type;}
    public int getSerialNumber() {return serialNumber;}

    public void setFavorite(boolean favorite){
         this.favorite=favorite;
    }
    public void setUrl(String url){
        this.Url=url;
    }
    public void setColor(int color) {this.color = color;}
    public void setType(int type) {this.type = type;}
    public void setSerialNumber(int serialNumber) {this.serialNumber = serialNumber;}
}