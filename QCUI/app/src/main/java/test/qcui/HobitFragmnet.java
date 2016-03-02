package test.qcui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 文浩 on 2015/8/15.
 */
public class HobitFragmnet extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private View rootview;
    private Button bn_get;
    private TextView personalAddress;
    //这是只有互相加关注之后才会显示的名字，在特别关注的通讯录中显示
    private TextView personalName;
    private TextView personalHabit;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity)activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_hobit,container,false);
        findView();
        setListener();
        initData();

        return rootview;
    }
    private void findView(){
        personalAddress=(TextView)rootview.findViewById(R.id.add_ui);
        personalHabit=(TextView)rootview.findViewById(R.id.habit_item_ui);
        personalName=(TextView)rootview.findViewById(R.id.pname_ui);
        bn_get=(Button)(TextView)rootview.findViewById(R.id.bn_habit);
    }

    private void setListener(){

        bn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void initData(){

    }

//    获取相关数据
    public String getpersonalAddress(){
        String fanhui=personalAddress.getText().toString();
        return fanhui;
    }
    public String getpersonalName(){
        String fanhui=personalName.getText().toString();
        return fanhui;
    }
    public String getpersonalHabit(){
        String fanhui=personalHabit.getText().toString();
        return fanhui;
//        需要对数据分割处理，以空格为界限
    }
    public static HobitFragmnet newInstance(int sectionNumber){
        HobitFragmnet fragment = new HobitFragmnet();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

}
