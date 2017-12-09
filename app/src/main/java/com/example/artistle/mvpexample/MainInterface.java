package com.example.artistle.mvpexample;

import com.arellomobile.mvp.MvpView;

public interface MainInterface extends MvpView {
    void showMessage(int message);

    void setMessage(String editTest);
}
