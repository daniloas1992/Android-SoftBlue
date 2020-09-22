package com.teste.modelo.planetas;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Planet implements Serializable {

    private String _name;
    private int _imageID;

    public String getName(){
        return _name;
    }

    public void setName(final String name){
        _name = name;
    }

    public int getImageID(){
        return _imageID;
    }

    public void setImageID(final int imageID){
        _imageID = imageID;
    }

    public static List<Planet> buildPlanets(Context contex){

        List<Planet> planets = new ArrayList<>();

        Resources res = contex.getResources();
        String[] names = res.getStringArray(R.array.planet_names);
        TypedArray images = res.obtainTypedArray(R.array.planets_imgs);

        for(int i = 0; i < names.length; i++){
            Planet p = new Planet();
            p.setName(names[i]);
            p.setImageID(images.getResourceId(i, -1));
            planets.add(p);
        }

        images.recycle(); // Chama depois de utilizar TypedArray

        return planets;
    }

}
