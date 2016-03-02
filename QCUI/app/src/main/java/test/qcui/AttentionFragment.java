package test.qcui;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 文浩 on 2015/8/15.
 */
public class AttentionFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private View rootview;
    private ListView listView;
    private TextView nameImage;
    private TextView nameAtt;
    private TextView messageAtt;
    private List<Map<String, Object>> listems;
    private SimpleAdapter adapter;

//    测试
    private String [][]tsd={{"超","杨超","重要的事情说三遍"},
                            {"添","九添","重要的事情说三遍"},
                            {"键","晓键","重要的事情说三遍"}};
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity)activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_attention, container,false);
        findView();
        setAdapter(tsd,3);
        setListener();
        initData();

        return rootview;
    }
    private void findView(){
        listView=(ListView)rootview.findViewById(R.id.att_listview);

    }
    public void  setAdapter(String da[][],int num){
        listems  = new ArrayList<Map<String, Object>>();
        for(int i = 0; i <num; i++) {
            Map<String, Object> listem  = new HashMap<String, Object>();
            listem .put("nameImage", da[i][0]);
            listem .put("name", da[i][1]);
            listem .put("message", da[i][2]);
            listems .add(listem);
        }

        adapter = new SimpleAdapter(this.getActivity().getApplicationContext(),
                listems,R.layout.item_ly,
                new String[]{"nameImage","name","message"},
                new int[]{R.id.name_image,R.id.name_att,R.id.message_att});

        listView.setAdapter(adapter);

    }

    public void add_Item(String da[][],int num) {

        //更新得是同一个listitem，不能new
        for (int i = 0; i < num; i++) {
            Map<String, Object> listem2 = new HashMap<String, Object>();
            listem2.put("nameImage", da[i][0]);
            listem2.put("name", da[i][1]);
            listem2.put("message", da[i][2]);
            listems.add(listem2);

            adapter.notifyDataSetChanged();
            //获得新数据后得修改原来的data，data存储

        }
    }


    private void setListener(){
           listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                   测试
                   Toast.makeText(getActivity(),"等待添加功能",Toast.LENGTH_SHORT).show();
                   DialogFragment newFragment = PersonalDialogFragment.newInstance(new String[]{
                           "兴趣一", "兴趣2", "呵呵呵呵", "天啦撸"});
                   newFragment.show(getActivity().getFragmentManager(), "dialog");
               }
           });

    }
    private void initData(){

    }
    public static AttentionFragment newInstance(int sectionNumber){
        AttentionFragment fragment = new AttentionFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

}
