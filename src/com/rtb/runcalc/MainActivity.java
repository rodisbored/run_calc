package com.rtb.runcalc;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity
{
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager            mViewPager;

    public enum RunTypes 
    {
        INTERVAL_RUN(0),
        PROGRESSION_RUN(1),
        TEMPO_RUN(2),
        FARTLEK_RUN(3),
        BASIC_RUN(4),
        PYRAMID_RUN(5),
        VALLEY_RUN(6),
        RECOVERY_RUN(7),
        BASE_RUN(8),
        LONG_RUN(9),
        UNKNOWN_RUN(-1);
        
        private int value;
        
        private RunTypes(int value)
        {
            this.value = value;
        }
        
        private int returnVal()
        {
            return this.value;
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter
    {

        public SectionsPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            // Match fragment to appropriate run layout
            if (position == RunTypes.INTERVAL_RUN.returnVal())
            {
                Fragment fragment = new IntervalFragment();
                Bundle args = new Bundle();
//                args.putInt(IntervalFragment.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            }
            else if (position == RunTypes.PROGRESSION_RUN.returnVal())
            {
                Fragment fragment = new ProgressionFragment();
                Bundle args = new Bundle();
                fragment.setArguments(args);
                return fragment;
            }
            else if (position == RunTypes.TEMPO_RUN.returnVal())
            {
                Fragment fragment = new TempoFragment();
                Bundle args = new Bundle();
                fragment.setArguments(args);
                return fragment;
            }
            else if (position == RunTypes.FARTLEK_RUN.returnVal())
            {
                Fragment fragment = new FartlekFragment();
                Bundle args = new Bundle();
                fragment.setArguments(args);
                return fragment;
            }
            else
            {
                Fragment fragment = new BasicFragment();
                Bundle args = new Bundle();
                fragment.setArguments(args);
                return fragment;
            }
        }

        @Override
        public int getCount()
        {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            Locale loc = Locale.getDefault();
            
            switch (position)
            {
                case 0:
                    return getString(R.string.interval).toUpperCase(loc);
                case 1:
                    return getString(R.string.progression).toUpperCase(loc);
                case 2:
                    return getString(R.string.tempo).toUpperCase(loc);
                case 3:
                    return getString(R.string.fartlek).toUpperCase(loc);
                case 4:
                    return getString(R.string.basic).toUpperCase(loc);
            }
            return null;
        }
    }

    public static class IntervalFragment extends Fragment
    {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public IntervalFragment()
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            // Create a new TextView and set its text to the fragment's section
            // number argument value.
            LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.interval_layout,
                    container, false);
            
            Button mButton = (Button) mLinearLayout.findViewById(R.id.pyramid_button);
            mButton.setOnClickListener(new OnClickListener() 
            {
                @Override
                public void onClick(View v) 
                {
                    // here you set what you want to do when user clicks your button,
                    // e.g. launch a new activity
                }
            });
            
            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            
            return mLinearLayout;
//            return textView;
        }
    }
    
    public static class ProgressionFragment extends Fragment
    {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public ProgressionFragment()
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            // Create a new TextView and set its text to the fragment's section
            // number argument value.
            LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.progression_layout,
                    container, false);
            
            return mLinearLayout;
        }
    }
    
    public static class TempoFragment extends Fragment
    {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public TempoFragment()
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            // Create a new TextView and set its text to the fragment's section
            // number argument value.
            LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.tempo_layout,
                    container, false);
            
            return mLinearLayout;
        }
    }
    
    public static class FartlekFragment extends Fragment
    {
        public static final String ARG_SECTION_NUMBER = "section_number";

        public FartlekFragment()
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            // Create a new TextView and set its text to the fragment's section
            // number argument value.
            LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.fartlek_layout,
                    container, false);
            
            return mLinearLayout;
        }
    }
    
    
    public static class BasicFragment extends Fragment
    {
        public static final String ARG_SECTION_NUMBER = "section_number";

        public BasicFragment()
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            // Create a new TextView and set its text to the fragment's section
            // number argument value.
            LinearLayout mLinearLayout = (LinearLayout) inflater.inflate(R.layout.basic_run_layout,
                    container, false);
            
//            Button mButton = (Button) mLinearLayout.findViewById(R.id.pyramid_button);
//            mButton.setOnClickListener(new OnClickListener() 
//            {
//                @Override
//                public void onClick(View v) 
//                {
//                    // here you set what you want to do when user clicks your button,
//                    // e.g. launch a new activity
//                }
//            });
            
            TextView textView = new TextView(getActivity());
            textView.setGravity(Gravity.CENTER);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            
            return mLinearLayout;
//            return textView;
        }
    }

}
