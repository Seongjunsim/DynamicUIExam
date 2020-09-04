package com.android.dynamicuiexam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArticleFragment extends Fragment {
    public static final String ARG_POSITION = "position";
    private int mCurrentPosision = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        if(savedInstanceState != null){
            mCurrentPosision = savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.fragment_article,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if(args != null){
            updateArticleView(args.getInt(ARG_POSITION));
        }else if(mCurrentPosision != -1){
            updateArticleView(mCurrentPosision);
        }
    }

    public void updateArticleView(int position){
        TextView article = (TextView)getView().findViewById(R.id.article_text);
        article.setText(Articles.Articles[position]);
        mCurrentPosision = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION,mCurrentPosision);
    }
}
