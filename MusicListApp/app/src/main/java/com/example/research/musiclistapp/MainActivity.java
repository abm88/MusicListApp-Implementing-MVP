package com.example.research.musiclistapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


import com.example.research.musiclistapp.Adapter.RockListAdapter;
import com.example.research.musiclistapp.data.network.service.ConnectionService;
import com.example.research.musiclistapp.services.IRequestInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private IRequestInterface iRequestInterface;
    private RecyclerView recyclerView;
    private ProgressDialog mProgressDialog;

 //   private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            /// / fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.homeListFragment:
                   transaction.replace(R.id.content, new HomeListFragment()).commit();

                    return true;
                case R.id.playListOneFrgament:

                    transaction.replace(R.id.content, new PlayListOneFragment()).commit();
                    return true;
                case R.id.playListTwoFragment:

                   transaction.replace(R.id.content, new PlayListTwoFragment()).commit();

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetworkConnected()) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Please wait...");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();

            cacheDataToRealm();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("No Internet Connection")
                    .setMessage("It looks like your internet connection is off. Please turn it " +
                            "on and try again")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();

            startDownload();
        }


        connectionMethod();
        initializeRecycler();
        
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void connectionMethod() {
        iRequestInterface = ConnectionService.getConnectionService();
        iRequestInterface.getResultList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(this::onSuccess, this::onError);
    }
    //Check Network status
    private boolean isNetworkConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public void startDownload(){

    }

    public void cacheDataToRealm(){

    }

    private void onError(Throwable throwable) {
    }

    private void onSuccess(RockListModel rockListModels) {
        recyclerView.setAdapter(new RockListAdapter(rockListModels.getResults(), R.layout.fragment_home_list, getApplicationContext()));


    }


    public void initializeRecycler(){
        recyclerView = (RecyclerView)findViewById(R.id.recycllerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }



}
