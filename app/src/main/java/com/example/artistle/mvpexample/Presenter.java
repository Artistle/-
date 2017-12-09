package com.example.artistle.mvpexample;

import com.arellomobile.mvp.MvpPresenter;
import com.example.artistle.speciallitylistprojects.R;

public class Presenter extends MvpPresenter<MainInterface> {

    public Presenter(String g){
        getViewState().showMessage(R.string.app_name);
        getViewState().setMessage(g);
    }
}
