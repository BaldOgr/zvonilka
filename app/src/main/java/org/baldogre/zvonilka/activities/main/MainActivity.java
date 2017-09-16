package org.baldogre.zvonilka.activities.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import org.baldogre.zvonilka.R;
import org.baldogre.zvonilka.adapter.ClientAdapter;
import org.baldogre.zvonilka.entity.Client;

import java.util.ArrayList;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements NavigationView.OnNavigationItemSelectedListener, MainView {

    ListView mClientListView;
    BaseAdapter mClientAdapter;
    ProgressDialog mProgressDialog;
    ViewPager mViewPager;

    //TODO tabs with history, clients and todos.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ViewPager viewPager = (ViewPager) findViewById(R.id.main_view_pager);
        viewPager.setAdapter(new CollectionPagerAdapter(getSupportFragmentManager()));

        viewPager.setCurrentItem(1);

        initUi();
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return MainPresenter.getPresenter();
    }

    private void initUi() {
        mClientAdapter = new ClientAdapter(new ArrayList<Client>(), getApplicationContext());
//        mClientListView = (ListView) findViewById(R.id.list_view);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getString(R.string.loading));
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            mProgressDialog.show();
        } else {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void showError(String message) {

    }

    public class CollectionPagerAdapter extends FragmentStatePagerAdapter {

        public CollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new TabFragment();
            Bundle arg = new Bundle();
            arg.putInt("index", position);
            fragment.setArguments(arg);
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.history);
                case 1:
                    return getString(R.string.clients);
                case 2:
                    return getString(R.string.todo);
            }
            return "Tab" + position;
        }
    }

    public static class TabFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(
                    R.layout.empty_list_view, container, false);
//            if (getArguments().getInt("index") == 1){
//                ListView clients = (ListView) rootView.findViewById(R.id.list_view);
//                clients.setAdapter(new ClientAdapter(new ArrayList<Client>(), rootView.getContext()));
//            }
            return rootView;
        }
    }
}
