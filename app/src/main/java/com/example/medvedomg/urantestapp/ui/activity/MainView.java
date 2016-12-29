package com.example.medvedomg.urantestapp.ui.activity;

import com.example.medvedomg.urantestapp.ui.model.FileModel;

import java.util.ArrayList;

/**
 * Created by medvedomg on 28.12.16.
 */

public interface MainView {

    void longPress();

    void fastPress();

    void setFiles(ArrayList<FileModel> listModels);

}
