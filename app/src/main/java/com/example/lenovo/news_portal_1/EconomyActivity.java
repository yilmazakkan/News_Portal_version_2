package com.example.lenovo.news_portal_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EconomyActivity extends AppCompatActivity {
    Context context = this;
    ListView listemiz;
    List<News> list;
    NewsDb sqLiteDatabase = new NewsDb(context);
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economy);

        listemiz = (ListView) findViewById(R.id.economylist);
        list = sqLiteDatabase.economyGetir();
        List<String> listBaslik = new ArrayList<>();
        for (int i = 0; i < list.size();i++){
            listBaslik.add(i,list.get(i).getBaslik());
        }
        mAdapter = new ArrayAdapter<String>(context,R.layout.satir_layout,R.id.listMetin,listBaslik);
        listemiz.setAdapter(mAdapter);

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context,EconomyViewActivity.class);
                intent.putExtra("sport",list.get(i).getId());
                Log.i("idimiz", String.valueOf(list.get(i).getId()));
                startActivity(intent);
            }
        });
    }
}
