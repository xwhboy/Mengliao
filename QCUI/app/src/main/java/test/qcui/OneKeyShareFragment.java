package test.qcui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 文浩 on 2015/8/15.
 */
public class OneKeyShareFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private View rootview;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity)activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_onekeyshare,container,false);
        findView();
        setListener();
        initData();

        return rootview;
    }
    private void findView(){

    }

    private void setListener(){


    }
    private void initData(){

    }
    public static OneKeyShareFragment newInstance(int sectionNumber){
        OneKeyShareFragment fragment = new OneKeyShareFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

}

