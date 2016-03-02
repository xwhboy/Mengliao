package com.init.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.init.domain.MlController;
import com.init.ui.mengliao.R;

import java.util.ArrayList;

/**
 * Created by zoson on 5/5/15.
 */
public class CommunicationFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {

    RelativeLayout rl_item;
    EditText et_account;
    TextView tv_queding;
    View view;

    ListView lv_comm;
    CommunicationListAdapter communicationListAdapter;
    ArrayList<CommunicationItem> al_comm;

    MlController mlController = MlController.getInstance();
    Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_commucation,null);
        bundle = savedInstanceState;
        initView();
        initData();
        setListener();

        return view;
    }
    protected void initData(){
        al_comm = new ArrayList<CommunicationItem>();
        ArrayList<String> list = mlController.getAllUser();
        if (list==null)return;
        for (int i = 0;i<list.size();i++){
            al_comm.add(new CommunicationItem(list.get(i)));
        }
        communicationListAdapter = new CommunicationListAdapter(getLayoutInflater(bundle),al_comm);
        lv_comm.setAdapter(communicationListAdapter);
    }
    protected void initView(){
        lv_comm = (ListView)view.findViewById(R.id.lv_comm);
    }
    protected void setListener(){
        lv_comm.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String account = al_comm.get(position).getName();
        Intent intent = new Intent(getActivity(),FaceActivity.class);
        intent.putExtra("account",account);
        startActivity(intent);
        //mlController.sendMessage("我时猛料",account);
    }
    public View getMainView(){
        return lv_comm;
    }
}
