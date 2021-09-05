package com.example.labproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class uninstallApp extends AppCompatActivity {

    SwipeRefreshLayout refreshMe;
    int my_pos;

        ListView listView;
        List<AppData> data_list = new ArrayList<>();
        @Override

        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uninstall_app);
        listView = findViewById(R.id.listView);

        refreshMe= findViewById(R.id.refresh);
//            requestWindowFeature(Window.FEATURE_NO_TITLE);
      //      this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       //     getSupportActionBar().hide(); //hides the action bar
            getSupportActionBar().setTitle("Uninstall Apps");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        PackageManager manager = getPackageManager(); //initialized package manager

        List<ApplicationInfo> infoList = manager.getInstalledApplications(


                PackageManager.GET_META_DATA
        );                                          //initialized installed app list

        for (ApplicationInfo info : infoList) {
            if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                AppData data = new AppData();
                data.setName(info.loadLabel(manager).toString()); //setting app name
                data.setPackage_name(info.packageName); //setting package name
                data.setLogo(info.loadIcon(manager));
                data_list.add(data);

            }
        }

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {

                return data_list.size();
            }

            @Override
            public Object getItem(int position)
            {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int pos, View convertView, ViewGroup parent) {

                View v = getLayoutInflater().inflate(R.layout.list_row_item, null);
//initialize appdata
                AppData apd = data_list.get(pos);
                ImageView app_Logo = v.findViewById(R.id.app_logo);
                TextView app_name = v.findViewById(R.id.app_name);
                Button uninstall_btn = v.findViewById(R.id.btn_Uninstall);
//convertView.getContext()
                //setting data
                app_Logo.setImageDrawable(apd.getLogo());
                app_name.setText(apd.getName());
                uninstall_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppData ap = data_list.get(pos);
                         my_pos= pos;

                        Intent intent = new Intent(Intent.ACTION_DELETE);
                        intent.setData(Uri.parse("package:" + ap.getPackage_name()));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);



                    }
                });
app_Logo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent ob = new Intent(convertView.getContext(),open.class);
        //image can be integer also
        ob.putExtra("logo", (Parcelable) apd.getLogo());
        ob.putExtra("namee", apd.getName());
        ob.setFlags(ob.FLAG_ACTIVITY_NEW_TASK);
        convertView.getContext().startActivity(ob);

    }
});
                refreshMe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        refreshMe.setRefreshing(false);
                        data_list.remove(my_pos);
                        notifyDataSetChanged();
                       // Toast.makeText(uninstallApp.this, "App removed from list!", Toast.LENGTH_SHORT).show();


                    }
                });
                return v;
            }
        });

    }



    }