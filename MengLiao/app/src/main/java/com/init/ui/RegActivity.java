package com.init.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.init.listener.ActivityListener;
import com.init.domain.MlController;
import com.init.service.P2PService;
import com.init.ui.mengliao.R;

/**
 * Created by zoson on 5/7/15.
 */
public class RegActivity extends Activity implements ActivityListener{

    private TextView bt_queding;
    private EditText et_reg_account;
    private EditText et_reg_password;
    private MlController mlController;
    private EditText et_service_ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        mlController = MlController.getInstance();
        findView();
        setListener();

    }
    protected void findView(){
        bt_queding = (TextView)findViewById(R.id.bt_queding);
        et_reg_account = (EditText)findViewById(R.id.et_reg_account);
        et_reg_password = (EditText)findViewById(R.id.et_reg_password);
        et_service_ip = (EditText)findViewById(R.id.et_service_ip);
    }
    protected void setListener(){
        mlController.setActivityListener(this);
        bt_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_reg_account.getText().toString().isEmpty()||et_reg_password.getText().toString().isEmpty()||et_service_ip.getText().toString().isEmpty()){
                    Toast.makeText(RegActivity.this,"请将信息填写完整",Toast.LENGTH_LONG).show();
                }else{
                    P2PService.xmpp_host = et_service_ip.getText().toString();
                    P2PService.xmpp_service_name = et_service_ip.getText().toString();
                    mlController.regXmpp(et_reg_account.getText().toString(),et_reg_password.getText().toString());
                }
            }
        });
    }

    @Override
    public void singal(int singal) {
        if (singal == 0){
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
        }
    }
}
