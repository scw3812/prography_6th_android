package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class TabPagerAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public TabPagerAdapter(@NonNull FragmentManager fm, int behavior, int tabCount) {
        super(fm, behavior);
        this.tabCount = tabCount;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                TabFragmentCall tabFragmentCall = new TabFragmentCall();
                return tabFragmentCall;
            case 1:
                TabFragmentChat tabFragmentChat = new TabFragmentChat();
                return tabFragmentChat;
            case 2:
                TabFragmentContact tabFragmentContact = new TabFragmentContact();
                return tabFragmentContact;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
