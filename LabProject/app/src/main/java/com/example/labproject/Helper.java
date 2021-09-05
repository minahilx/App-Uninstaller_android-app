package com.example.labproject;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class Helper extends AppCompatActivity {
public Helper()
{

}
    public static final String Pref_Name = "Preference";

    public  boolean setPreference(String key, String value)
    {
        //mode if public then other apps can access shared pref value =>privacy issue
        SharedPreferences settings = getSharedPreferences(Pref_Name, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
        //active mobiles editor mode, that we're setting or deleting something here

    }
    public  String getPreference(String key)
    {
        SharedPreferences settings = getSharedPreferences(Pref_Name, MODE_PRIVATE);
        return settings.getString(key, "true");
    }
}

