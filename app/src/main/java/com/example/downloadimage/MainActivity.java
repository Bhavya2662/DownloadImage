package com.example.downloadimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    RequestQueue requestQueue;
    ImageRequest imageRequest;
    String url = "https://image.shutterstock.com/image-photo/surreal-image-african-elephant-wearing-600w-1365289022.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void downloadImage(View view){
        imageView = findViewById(R.id.imageView);
        button=findViewById(R.id.button);
        requestQueue =  Volley.newRequestQueue(this);
        imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        });
        requestQueue.add(imageRequest);
    }
}