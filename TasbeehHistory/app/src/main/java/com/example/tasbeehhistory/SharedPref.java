package com.example.tasbeehhistory;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPref {

    public static final String count_history = "COUNTER_HISTORY";

    String var;

    public boolean setCount(Context c, String count)
    {


  SharedPreferences pref = c.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE); //"MODE_PRIVATE" because  shared pref would only be access able to this app, no other app would access it

       SharedPreferences.Editor editor = pref.edit(); //now editor is created of this preferences, and by using it we can store these var i.e username and pwd

        editor.putString(count_history, count);

        return editor.commit(); // returning boolean val, either modification done successfully or not

    }

    public  String getCount(Context c)

    {
        SharedPreferences pref = c.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE); //"MODE_PRIVATE" because  shared pref would only be access able to this app, no other app would access it
var= pref.getString(count_history, "");

        return var;

    }







}

// Set<String> myStrings = new HashSet<String>();


//  for(int k =0;k<count.length;k++)
//  {
//  set.add(count[k]);

//  myStrings.add(count[k]);

// my= count[k];

//    }
//Set<String> fetch = pref.getStringSet(count_history, null);
// List<String> list = new ArrayList<String>(fetch);

//  for(int i = 0 ; i < list.size() ; i++){
//     Log.d("fetching values", "fetch value " + list.get(i));
//    }


//  Set<String> myStrings = pref.getStringSet(count_history, new HashSet<String>());

//  for(int j=0;j<arr.length;j++)
//    {
//        plus++;

//        arr[j]= "Count " + plus + ") " + pref.getStringSet(count_history, null);
//    }