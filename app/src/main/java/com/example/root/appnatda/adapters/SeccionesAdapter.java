package com.example.root.appnatda.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeccionesAdapter extends FragmentStatePagerAdapter {

    private  final List<Fragment> listaFragments= new ArrayList<>();
    private final List<String> listaTitulos= new ArrayList<>();

    public SeccionesAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments(Fragment fragment, String titulo){
        listaFragments.add(fragment);
        listaTitulos.add(titulo);

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    @Override
    public Fragment getItem(int positio) {


        return listaFragments.get(positio);

    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }
}
