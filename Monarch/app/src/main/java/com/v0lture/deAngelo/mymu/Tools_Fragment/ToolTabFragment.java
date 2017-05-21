package com.v0lture.deAngelo.mymu.tools_fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.v0lture.deAngelo.mymu.R;

/**
 * Created by De'Angelo on 12/20/2016.
 */

public class ToolTabFragment extends Fragment {
    public static TabLayout toolTabLayout;
    public static ViewPager toolViewPager;
    public static int int_toolitems = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View y = inflater.inflate(R.layout.tool_tab_layout, null);
        toolTabLayout = (TabLayout) y.findViewById(R.id.tooltabs);
        toolViewPager = (ViewPager) y.findViewById(R.id.toolviewpager);
        toolViewPager.setAdapter(new ToolMyAdapter(getChildFragmentManager()));

        toolTabLayout.post(new Runnable() {
            @Override
            public void run() {
                toolTabLayout.setupWithViewPager(toolViewPager);
            }
        });
        return y;
    }
    class ToolMyAdapter extends FragmentPagerAdapter {
        public ToolMyAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }


        /*public ToolMyAdapter(Object childFragmentManager){
            super((FragmentManager) childFragmentManager);
        }*/
        @Override
        public  Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new GPAFragment();
                case 1:
                    return new SyllabusFragment();
                case 2:
                    return new AdvisingFragment();
                default:
                    Toast.makeText(getContext(), "Invalid Choice", Toast.LENGTH_SHORT).show();
                    break;

            }
            return null;
        }
        @Override
        public int getCount() {
            return int_toolitems;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "GPA";
                case 1:
                    return "Syllabus";
                case 2:
                    return "Advising";
                default:
                    Toast.makeText(getContext(), "Invalid Choice", Toast.LENGTH_SHORT).show();
                    break;
            }
            return null;
        }
    }
}
