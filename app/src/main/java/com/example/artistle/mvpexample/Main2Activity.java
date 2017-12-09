package com.example.artistle.mvpexample;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.artistle.speciallitylistprojects.R;

public class Main2Activity extends MvpActivity implements MainInterface {

    @InjectPresenter
    Presenter presenter;

    private TextView hello;
    private EditText text;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = (EditText)findViewById(R.id.editText);

        presenter = new Presenter(text.getText().toString());

        hello = (TextView)findViewById(R.id.hello);

        textView = (TextView)findViewById(R.id.text);
    }

    @Override
    public void showMessage(int message) {
        hello.setText(message);
    }

    @Override
    public void setMessage(String editTest) {
        textView.setText(editTest);
    }
}
