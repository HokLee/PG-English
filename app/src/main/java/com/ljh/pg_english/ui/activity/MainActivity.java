package com.ljh.pg_english.ui.activity;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ljh.pg_english.R;
import com.ljh.pg_english.ui.adapter.FragAdapter;
import com.ljh.pg_english.ui.fragment.ExamFragment;
import com.ljh.pg_english.ui.fragment.NewsFragment;
import com.ljh.pg_english.ui.fragment.VocabularyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private TabLayout tabs;
    private ViewPager viewPager;
    private FragAdapter fragAdapter;
    private List<Fragment> list_fragment;
    private List<String> list_title;
    private ExamFragment examFragment;
    private NewsFragment newsFragment;
    private VocabularyFragment vocabularyFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs=(TabLayout)findViewById(R.id.tabs);
        viewPager=(ViewPager)findViewById(R.id.viewpager);

        examFragment = new ExamFragment();
        newsFragment = new NewsFragment();
        vocabularyFragment = new VocabularyFragment();

        list_fragment = new ArrayList<>();
        list_fragment.add(vocabularyFragment);
        list_fragment.add(examFragment);
        list_fragment.add(newsFragment);

        list_title = new ArrayList<>();
        list_title.add("词汇");
        list_title.add("专项测试");
        list_title.add("新鲜事");

        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.addTab(tabs.newTab().setText(list_title.get(0)));
        tabs.addTab(tabs.newTab().setText(list_title.get(1)));
        tabs.addTab(tabs.newTab().setText(list_title.get(2)));

       fragAdapter = new FragAdapter(getSupportFragmentManager(), list_fragment,list_title);
        viewPager.setAdapter(fragAdapter);
        tabs.setupWithViewPager(viewPager);

    }
}
