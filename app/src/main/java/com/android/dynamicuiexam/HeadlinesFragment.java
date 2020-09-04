package com.android.dynamicuiexam;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeadlinesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeadlinesFragment extends ListFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    interface OnHeadlineSelectedListener{
        void onHeadlineSeleceted(int position);
    }

    private OnHeadlineSelectedListener mListener;

    public HeadlinesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Articles.Headlines));

    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try{
            mListener = (OnHeadlineSelectedListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implement onheadlineSelected");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id){
        super.onListItemClick(l,v,pos,id);
        if(mListener != null){
            mListener.onHeadlineSeleceted(pos);
        }
    }


}