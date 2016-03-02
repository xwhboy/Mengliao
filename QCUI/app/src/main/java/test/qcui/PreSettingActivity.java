package test.qcui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by 文浩 on 2015/8/14.
 */
public class PreSettingActivity extends Activity{
    private RadioButton bn_boy;
    private RadioButton bn_gril;
    private RadioGroup radioGroup;
    private Button bn_login;
    private boolean choose_BG=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pre_setting);
        findView();
        setListener();
        initData();
    }
    private void findView(){

        radioGroup=(RadioGroup)findViewById(R.id.rg);
        bn_login=(Button)findViewById(R.id.bn_login_ui);
        bn_boy=(RadioButton)findViewById(R.id.bn_boy_ui);
        bn_gril=(RadioButton)findViewById(R.id.bn_gril_ui);
    }
    private void setListener(){

        bn_login.setOnClickListener(new View.OnClickListener() {

//            先判断是否选择性别
//            if()
//            {
//
//            }
//
            @Override
            public void onClick(View v) {

                if( choose_BG) {
                    Intent intent = new Intent();
                    intent.setClass(PreSettingActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(PreSettingActivity.this,"请选择性别",Toast.LENGTH_SHORT).show();
                }
            }

        });

//       选择监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==bn_boy.getId()){
                    Log.i("选择性别：","boy");
//                    判断测试
                    choose_BG=true;
                }else if(checkedId==bn_gril.getId()){
                    Log.i("选择性别：","gril");
                    choose_BG=true;

                }
            }
        });


    }
    private void initData(){

    }
}
