package com.example.artistle.retrofit_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    private Button mButtonTranslate;
    private EditText mEditTextTranslate;
    private TextView mTextViewTranslateResult;
    private Gson gson;
    private Retrofit retrofit;
    private final String URL = "https://translate.yandex.ru";
    private final String KEY = "trnsl.1.1.20171112T172823Z.860349c2d872cb9d.d1baf5fa3670ff6122ada3e9ae87309451a7daa0";
    private Link intf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new GsonBuilder().create();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(URL)
                .build();

        mButtonTranslate = (Button)findViewById(R.id.ButtonTranslate);
        mEditTextTranslate = (EditText)findViewById(R.id.EditTextTranslate);
        mTextViewTranslateResult = (TextView)findViewById(R.id.translateResult);

        intf = retrofit.create(Link.class);

        mButtonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> mapJson = new HashMap<String, String>();
                mapJson.put("key", KEY);
                mapJson.put("text", mEditTextTranslate.getText().toString());
                mapJson.put("lang", "en-ru");

                Call<Object> call = intf.translate(mapJson);

                try {
                    Response<Object> response = call.execute();

                    Map <String ,String> map = gson.fromJson(response.body().toString(), Map.class);

                    for(Map.Entry e : map.entrySet()){
                        if(e.getKey().equals("text")){
                            mTextViewTranslateResult.setText(e.getValue().toString());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
