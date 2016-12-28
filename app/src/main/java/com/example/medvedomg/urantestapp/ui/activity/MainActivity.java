package com.example.medvedomg.urantestapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.medvedomg.urantestapp.App;
import com.example.medvedomg.urantestapp.R;
import com.example.medvedomg.urantestapp.data.TestdbModule;
import com.example.medvedomg.urantestapp.ui.adapter.Adapter;
import com.example.medvedomg.urantestapp.ui.component.DaggerMainActivityComponent;
import com.example.medvedomg.urantestapp.ui.module.MainActivityModule;
import com.example.medvedomg.urantestapp.ui.presenter.MainPresenterImpl;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

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

        mRvList.setAdapter(mAdapter);

        mRvList.setLayoutManager(llManger);

        mMainPresenter.loadData();

    }

    @Override
    public void longPress() {

    }

    @Override
    public void fastPress() {

    }
}
