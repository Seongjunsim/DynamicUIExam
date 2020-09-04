package com.android.dynamicuiexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HeadlinesFragment.OnHeadlineSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.fragment_container)!= null){
            if(savedInstanceState == null){
                HeadlinesFragment headlinesFragment = new HeadlinesFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, headlinesFragment).commit();
            }
        }

    }

    @Override
    public void onHeadlineSeleceted(int position){
        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        if(articleFragment == null){
            ArticleFragment newArticleFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(newArticleFragment.ARG_POSITION, position);
            articleFragment.setArguments(args);

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, newArticleFragment).addToBackStack(null).commit();
        }else{
            articleFragment.updateArticleView(position);
        }


    }
}