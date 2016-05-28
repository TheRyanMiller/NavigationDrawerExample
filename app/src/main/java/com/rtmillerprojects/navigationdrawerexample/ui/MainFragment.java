package com.rtmillerprojects.navigationdrawerexample.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rtmillerprojects.navigationdrawerexample.R;
import com.rtmillerprojects.navigationdrawerexample.listener.MainListener;

/**
 * Created by Ryan on 5/28/2016.
 */
public class MainFragment extends BaseFragment {

    private FloatingActionButton fab;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private MainListener listener;


    public MainFragment() {
        // Required empty public constructor
    }
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override public void onAttach(Context context) {
        super.onAttach(context);
        listener = (MainActivity) context;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.main_fragment, container, false);

        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);

        //Set toolbar as default action bar
        ACA.setSupportActionBar(toolbar);
        ACA.getSupportActionBar().setTitle("WASSUP");

        DrawerLayout drawer = listener.getDrawer();
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(ACA, drawer, toolbar, R.string.navigation_drawer_open,
                        R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Toast.makeText(ACA,"FAB has been clicked",Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
    
    @Override public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
