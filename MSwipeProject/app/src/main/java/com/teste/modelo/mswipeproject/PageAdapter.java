package com.teste.modelo.mswipeproject;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return MainActivity.QUANTIDADE_TELAS;  // Quantas telas existem?
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab "+ (position + 1);
    }
}
