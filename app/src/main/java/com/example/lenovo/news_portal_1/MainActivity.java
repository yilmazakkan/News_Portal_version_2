package com.example.lenovo.news_portal_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView sportimg,economyimg,lifeimg,technologyimg;
    NewsDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sportimg = (ImageView) findViewById(R.id.sports);
        economyimg = (ImageView) findViewById(R.id.economy);
        lifeimg = (ImageView) findViewById(R.id.life);
        db =new NewsDb(this);




        sportimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SportActivity.class);
                startActivity(intent);
            }
        });

        economyimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EconomyActivity.class);
                startActivity(intent);

            }
        });
        lifeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LifeActivity.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.add_sport){

            startActivity(new Intent(MainActivity.this,SaveActivity.class));
        }
        if (item.getItemId() == R.id.add_economy){
            startActivity(new Intent(MainActivity.this,SaveeconomyActivity.class));
        }
        if (item.getItemId() == R.id.add_life){
            startActivity(new Intent(MainActivity.this,SaveLifeActivity.class));
        }

        if (item.getItemId() == R.id.add_delete){
            db.deleteAll();
            startActivity(new Intent(MainActivity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }


}
