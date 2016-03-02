package com.init.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.init.domain.face_module.FaceModel;
import com.init.ui.mengliao.R;

/**
 * Created by zoson on 5/5/15.
 */
public class MeFragment extends android.support.v4.app.Fragment {

    LinearLayout ll_me_mainview;
    ImageView im_sex;
    TextView tv_me;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View)inflater.inflate(R.layout.activity_me,null);
        ll_me_mainview = (LinearLayout)view.findViewById(R.id.ll_me_mainview);
        tv_me = (TextView)view.findViewById(R.id.tv_me);
        im_sex = (ImageView)view.findViewById(R.id.im_sex);
        im_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FaceModel.sex = !FaceModel.sex;
                if (FaceModel.sex){
                    im_sex.setImageResource(R.drawable.boy);
                }else {
                    im_sex.setImageResource(R.drawable.girl);
                }
            }
        });
        return view;
    }

    public View getMainView(){
        return ll_me_mainview;
    }
}
