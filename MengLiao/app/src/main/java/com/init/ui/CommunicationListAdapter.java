package com.init.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.init.ui.mengliao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoson on 5/6/15.
 */
public class CommunicationListAdapter extends BaseAdapter {
    private List<CommunicationItem> communicationItem;
    private LayoutInflater inflater;

    public CommunicationListAdapter(LayoutInflater inflater,ArrayList<CommunicationItem> communicationItem){
        this.inflater = inflater;
        this.communicationItem = communicationItem;
    }
    @Override
    public int getCount() {
        return communicationItem.size();
    }

    @Override
    public Object getItem(int position) {
        return communicationItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.communication_listview_item,null);
        TextView textView = (TextView)view.findViewById(R.id.et_account);
        textView.setText(communicationItem.get(position).getName());
        return view;
    }
}
