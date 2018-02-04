package com.alonz.reumanatlot_mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.alonz.reumanatlot_mvvm.Database.Product;
import com.alonz.reumanatlot_mvvm.Fragments.DashFragment;
import com.alonz.reumanatlot_mvvm.Fragments.HomeFragment;
import com.alonz.reumanatlot_mvvm.Fragments.ItemsMainFragment;
import com.alonz.reumanatlot_mvvm.Fragments.Notificationragment;
import com.alonz.reumanatlot_mvvm.Utils.FragmentUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NatlotViewModel natlotViewModel;
    private List<Product> data;
    HomeFragment homeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewModel();

    natlotViewModel.getNatlotList().observe(this, new Observer<List<Product>>() {
        @Override
        public void onChanged(@Nullable List<Product> products) {
            data=products;
        }
    });

        homeFragment = HomeFragment.newInstance();
        homeFragment.setRetainInstance(true);
        FragmentUtils.swapFragment(homeFragment,getSupportFragmentManager());
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment dashFragment = fragmentManager.findFragmentByTag("DASH");


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FragmentUtils.swapFragment(homeFragment,getSupportFragmentManager());
                    return true;
                case R.id.navigation_dashboard:
                    DashFragment dashFragment = DashFragment.newInstance(null,null);
                    FragmentUtils.swapFragment(dashFragment,getSupportFragmentManager(),"DASH");
                    return true;
                case R.id.navigation_notifications:
                    Notificationragment notificationragment = Notificationragment.newInstance(null,null);
                    FragmentUtils.swapFragment(notificationragment,getSupportFragmentManager());
                    return true;
            }
            return false;
        }
    };

    private void initViewModel(){
        natlotViewModel = ViewModelProviders.of(this).get(NatlotViewModel.class);
    }
}
