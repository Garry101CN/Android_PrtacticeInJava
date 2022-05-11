package com.garroid.androidadvancejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("GaryNote", "Done");
        Button textInputButton = findViewById(R.id.textInputBtn);
        textInputButton.setOnClickListener(this);
        Button geoQuizButton = findViewById(R.id.geoquizBtn);
        geoQuizButton.setOnClickListener(this);
        Button movableViewButton = findViewById(R.id.movableView);
        movableViewButton.setOnClickListener(this);
        Button requestNetworkButton = findViewById(R.id.requestNetwork);
        requestNetworkButton.setOnClickListener(this);
        Button diyViewButton = findViewById(R.id.diyView);
        diyViewButton.setOnClickListener(this);
        Button rxjavaButton = findViewById(R.id.RxJavaBtn);
        rxjavaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.textInputBtn:{
                Toast toast = Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Intent intent = new Intent(MainActivity.this, TextInputLayoutTest.class);
                startActivity(intent);
                break;
            }
            case R.id.geoquizBtn:{
                Intent intent = new Intent(MainActivity.this, GeoQuiz.class);
                startActivity(intent);
                break;
            }
            case R.id.movableView:{
                startActivity(new Intent(MainActivity.this, MovableViewActivity.class));
                break;
            }
            case R.id.requestNetwork:{

                // Request a Http Connection via Retrofit Framework
                String url = "http://192.168.31.90:8081/";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        // 增加返回值为Json的支持
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IpService ipService = retrofit.create(IpService.class);
                Call<IpModel> call = ipService.getIpMsg();
                call.enqueue(new Callback<IpModel>(){

                    @Override
                    public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                        String country = response.body().getData().getCountry();
                        Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<IpModel> call, Throwable throwable) {
                        // Do nothing.
                        Toast.makeText(getApplicationContext(), "HTTP request failed. Because ", Toast.LENGTH_SHORT).show();
                        throwable.printStackTrace();
                    }
                });
                break;
            }
            case R.id.diyView:{
                startActivity(new Intent(MainActivity.this, DIYViewGallery.class));
            }
            case R.id.RxJavaBtn:{
                startActivity(new Intent(MainActivity.this, RxJavaActivity.class));
            }
        }

        CheckBox checkBox = findViewById(R.id.myCheckBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });




    }
}