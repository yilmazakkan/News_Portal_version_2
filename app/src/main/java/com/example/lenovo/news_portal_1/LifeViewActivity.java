package com.example.lenovo.news_portal_1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class LifeViewActivity extends AppCompatActivity {

    TextView txttitle,txttext;
    ImageView img2;
    NewsDb newsDB;
    Context context=this;

    News secilisinews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_view);            //Dikkat

        txttitle = (TextView) findViewById(R.id.selectedtitletekno);
        txttext = (TextView) findViewById(R.id.selectedtextlife);
        img2 = (ImageView) findViewById(R.id.selectedimgtekno);

        newsDB = new NewsDb(context);
        Intent intent = getIntent();
        int id = intent.getIntExtra("sport",-1);
        secilisinews = newsDB.haberOku(id);
        txttitle.setText(secilisinews.getBaslik());
        txttext.setText(secilisinews.getMetin());
        byte [] selected_image = secilisinews.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(selected_image,0,selected_image.length);
        img2.setImageBitmap(bitmap);
    }
}
