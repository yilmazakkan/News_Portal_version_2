package com.example.lenovo.news_portal_1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SaveeconomyActivity extends AppCompatActivity {

    EditText baslik,metin;
    ImageView image_selected,back;
    Button save;
    String kategori="Economy";
    NewsDb newsDB;
    Bitmap resim;
    final int PICK_IMAGE=999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveeconomy);
        back =(ImageView)findViewById(R.id.backebtn);
        baslik = (EditText) findViewById(R.id.teknostitle);
        metin =(EditText) findViewById(R.id.teknostext);
        image_selected=(ImageView) findViewById(R.id.imagetekno);
        save=(Button) findViewById(R.id.teknosave);
        newsDB=new NewsDb(this);
        image_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(SaveeconomyActivity.this,new String[]
                        {Manifest.permission.READ_EXTERNAL_STORAGE},PICK_IMAGE);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    resim.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                    byte[] byteArray = outputStream.toByteArray();

                    kategori = "economy";

                    newsDB.addNews(baslik.getText().toString(),
                            metin.getText().toString(),kategori,
                            byteArray);
                    Toast.makeText(getApplicationContext(),"haber eklendi",Toast.LENGTH_LONG).show();
                }catch (Exception e){e.printStackTrace();}

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PICK_IMAGE){
            if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,PICK_IMAGE);
            }
            else {
                Toast.makeText(getApplicationContext(),"İznin Yok",Toast.LENGTH_SHORT).show();
            }
            return;
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {

            Uri uri = data.getData();

            try {
                resim = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                image_selected.setImageBitmap(resim);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    public void back (View view){

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
