package com.example.medvedomg.urantestapp.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.medvedomg.urantestapp.App;
import com.example.medvedomg.urantestapp.R;
import com.example.medvedomg.urantestapp.data.TestdbModule;
import com.example.medvedomg.urantestapp.ui.adapter.Adapter;
import com.example.medvedomg.urantestapp.ui.component.DaggerMainActivityComponent;
import com.example.medvedomg.urantestapp.ui.model.FileModel;
import com.example.medvedomg.urantestapp.ui.module.MainActivityModule;
import com.example.medvedomg.urantestapp.ui.presenter.MainPresenterImpl;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    public static final String TAG = Class.class.getSimpleName();

    @BindView(R.id.rv_main)
    RecyclerView mRvList;

    @Inject
    Adapter mAdapter;

    @Inject
    MainPresenterImpl mMainPresenter;

    @Inject
    TestdbModule testdbModule;

    @Inject
    LinearLayoutManager llManger;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerMainActivityComponent.builder()
                .appComponent(((App) getApplicationContext()).getAppComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);

//        adapter = new Adapter(this);

        mRvList.setAdapter(mAdapter);

        mRvList.setLayoutManager(llManger);

        mMainPresenter.loadData();

//        TestdbModule db = new TestdbModule(this);
//        db.getReadableDatabase();

    }

    @Override
    public void longPress() {

    }

    @Override
    public void fastPress() {

    }

    @Override
    public void setFiles(ArrayList<FileModel> listModels) {
        Log.d(TAG, listModels.size() + " main activity" + listModels.get(1).getFileName());

//        listModels = listModels;
//        ArrayList<FileModel> models = new ArrayList<>();
//        adapter.updateFilesList(models);
        mAdapter.updateFilesList(listModels);
    }

    public Context getActivityContext() {
        return this;
    }
}
