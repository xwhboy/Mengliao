package test.qcui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 文浩 on 2015/8/16.
 */
public  class PersonalDialogFragment extends DialogFragment {

    private Button ok;
    private Button cancel;
    private View view;
    private  Dialog dialog;
    private GridView gv;
    private ImageView headImage;
    private TextView headName;
    private TextView headMessage;
    private TextView headAddress;
    private static String show_data[];
    public PersonalDialogFragment(){

    }

    public static PersonalDialogFragment newInstance(String test_data[]){
        show_data=new String[test_data.length];
        show_data=test_data;
        PersonalDialogFragment frag = new PersonalDialogFragment();
        Bundle b = new Bundle();

        frag.setArguments(b);
        return frag;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.dialog_person, null, false);
        findView();
        setListener();
        initData();

//        测试
//        Log.v("mabi",show_data[1]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                R.layout.hobit_item,R.id.hobit_text_item);
        for(int i=0;i<show_data.length;i++){
            adapter.add(show_data[i]);
        }
        gv.setAdapter(adapter);
        dialog.setContentView(view);
        return dialog;
    }
    private void findView(){
        ok=(Button)view.findViewById(R.id.bn_ok);
        cancel=(Button)view.findViewById(R.id.bn_cancel);
        gv=(GridView)view.findViewById(R.id.grigview_ui);
        headImage=(ImageView)view.findViewById(R.id.head_image);
        headMessage=(TextView)view.findViewById(R.id.head_message);
        headAddress=(TextView)view.findViewById(R.id.head_address);
        headName=(TextView)view.findViewById(R.id.head_name);
    }
    private void setListener(){

        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent=new Intent(getActivity(),CuteChatActivity.class);
                getActivity().startActivity(intent);

            }

        });

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }

        });
    }
    private void initData(){



    }
    public void onResume() {

        super.onResume();
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = this.getActivity().getWindowManager();
        wm.getDefaultDisplay().getMetrics(dm);
        int mScreenWidth = dm.widthPixels;// 获取屏幕分辨率宽度
        int mScreenHeight = dm.heightPixels;
        double width2=(mScreenWidth*0.9);
        double height2=(mScreenHeight*0.8);
        int width=Integer.parseInt(new java.text.DecimalFormat("0").format(width2));
        int height=Integer.parseInt(new java.text.DecimalFormat("0").format(height2));

        getDialog().getWindow().setLayout(width,height);
    }
}