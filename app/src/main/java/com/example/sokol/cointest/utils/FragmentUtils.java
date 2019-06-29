package com.example.sokol.cointest.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sokol.cointest.R;

import androidx.appcompat.app.AppCompatActivity;


public class FragmentUtils {

    public static void changeFragmentWithoutBackStack(AppCompatActivity activity, Fragment fragment) {
        FragmentManager fm = activity.getSupportFragmentManager();
        if (fm.getFragments() != null) {
            for (Fragment item : fm.getFragments()) {
                if (item != null) {
                    fm.popBackStack(0, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                }
            }
        }
        fm.beginTransaction()
                .replace(R.id.fragment, fragment, fragment.getClass().getName())
                .commitAllowingStateLoss();
    }

    public static void changeFragment(FragmentActivity activity, Fragment fragment) {
        changeFragment(activity.getSupportFragmentManager(), fragment);
    }

    public static void changeFragment(FragmentManager fragmentManager, Fragment fragment) {
        changeFragment(fragmentManager, fragment, false);
    }

    public static void changeFragment(FragmentManager fragmentManager,
                                      Fragment fragment, boolean fade) {
        fragmentManager.findFragmentById(R.id.fragment).onHiddenChanged(true);
        FragmentTransaction tr = fragmentManager.beginTransaction();



        tr.replace(R.id.fragment, fragment, fragment.getClass().getName())
                .addToBackStack(fragment.getClass().getName())
                .commitAllowingStateLoss();
    }
}
