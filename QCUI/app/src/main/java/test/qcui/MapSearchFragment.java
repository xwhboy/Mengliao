package test.qcui;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

/**
 * Created by 文浩 on 2015/8/15.
 */
public class MapSearchFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button bu;
    private View rootview;
    private String[] hobit_data;



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity)activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_mapseacher,container,false);
        setHobit_data(new String[]{"兴趣一","兴趣2","呵呵呵呵",
                                   "天啦撸"});
        findView();
        setListener();
        initData();

        return rootview;
    }
    private void findView(){
        bu=(Button)rootview.findViewById(R.id.button);
    }

    private void setListener(){
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = PersonalDialogFragment.newInstance(hobit_data);

                newFragment.show(getActivity().getFragmentManager(), "dialog");

            }
        });

    }
    private void initData(){

    }
    public String[] setHobit_data(String test_data[]){
        hobit_data=new String[test_data.length];
        hobit_data=test_data;
        return hobit_data;

    }
    public static MapSearchFragment newInstance(int sectionNumber){
        MapSearchFragment fragment = new MapSearchFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

}
