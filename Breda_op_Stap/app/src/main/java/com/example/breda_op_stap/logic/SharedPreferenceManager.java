package com.example.breda_op_stap.logic;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.breda_op_stap.data.Waypoint;

public class SharedPreferenceManager
{
    public static final String SHARED_PREFS = "shared_prefs";
    private static SharedPreferenceManager insance;
    public Context context;

    private SharedPreferenceManager(Context context)
    {
        this.context = context;
    }

    public static SharedPreferenceManager getInstance(Context context)
    {
        if (insance == null) {
            insance = new SharedPreferenceManager(context);
        }

        return insance;
    }

    /**
    * checkt of de gegeven waypoint verborgen is doormiddel van de opgeslagen sharedPreferance data.
    * data wordt opgehaald met de key ([naam waypoint]Hidden). als geen data bekend is returnt deze
    * automatisch 'false'.
     * @param waypoint: waypoint waarbij de hidden status gevraagd is.
     * @return hidden status van waypoint. true als waypoint verborgen is. */
    public boolean getIsHidden(Waypoint waypoint)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(waypoint.getName()+"Hidden", false);
    }

    /**
     * checkt of de gegeven waypoint favoriet is doormiddel van de opgeslagen sharedPreferance data.
     * data wordt opgehaald met de key ([naam waypoint]Favourite). als geen data bekend is returnt deze
     * automatisch 'false'.
     * @param waypoint: waypoint waarbij de hidden status gevraagd is.
     * @return hidden status van waypoint. true als waypoint favoriet is. */
    public boolean getIsFavourite(Waypoint waypoint)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(waypoint.getName()+"Favourite", false);
    }

    public boolean getIsVisited(Waypoint waypoint)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(waypoint.getName()+"Visited", false);
    }

    /**
    * slaat op of een waypoint verborgen is.
    * waypoint wordt opgeslagen met (naam)Hidden als key en de gegeven boolean als waarde.
    * als de waarde true is, is deze dus verborgen.
     * @param waypoint: waypoint waarvan de waarde opgeslagen wordt
     * @param value: waarde van de waypoint die opgeslagen wordt */
    public void setIsHidden(Waypoint waypoint, boolean value)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(waypoint.getName() + "Hidden", value);
        editor.apply();
    }

    /**
    * slaat op of een waypoint favoriet is.
    * waypoint wordt opgeslagen met (naam)Favouret als key en de gegeven boolean als waarde.
    * als de waarde true is, is deze dus favoriet.
     * @param waypoint: waypoint waarvan de waarde opgeslagen wordt
     * @param value: waarde van de waypoint die opgeslagen wordt */
    public void setIsFavourite(Waypoint waypoint, boolean value)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(waypoint.getName() + "Favourite", value);
        editor.apply();
    }

    public void setIsVisited(Waypoint waypoint, boolean value)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(waypoint.getName() + "Visited", value);
        editor.apply();
    }
}