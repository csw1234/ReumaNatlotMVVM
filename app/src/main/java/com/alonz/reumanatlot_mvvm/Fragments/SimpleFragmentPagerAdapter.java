/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alonz.reumanatlot_mvvm.Fragments;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentStatePagerAdapter {
    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
    return NatlotFragment.newInstance(position);
        }

    @Override
    public int getCount() {
        return 9;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return ("אדום");
            case 1:
                return ("סגול");
            case 2:
                return ("ירוק בהיר");
            case 3:
                return ("טורקיז בהיר");
            case 4:
                return ("לבן");
            case 5:
                return ("טורקיז");
            case 6:
                return ("צהוב");
            case 7:
                return ("כחול בהיר");
            default:
                return ("כתום");
        }
    }
}




