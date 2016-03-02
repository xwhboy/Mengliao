package com.init.ui;

import android.app.Activity;
import android.content.Intent;
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
 * Created by zoson on 4/19/15.
 */
public class LogActivity extends Activity implements ActivityListener{

    private EditText et_account;
    private EditText et_password;
    private EditText et_service_ip;
    private TextView bt_connect;
    private TextView bt_reg;
    private MlController mlController;
    private String account;
    private String password;
    private String service_ip;
    private boolean isLog;

    private CustomerDialog customerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        mlController = MlController.getInstance();
        mlController.setActivityListener(this);

        isLog = false;

        View view = getLayoutInflater().inflate(R.layout.dialog_loading,null);
        customerDialog = new CustomerDialog(this,view,R.style.Theme_dialog,140,50);

        et_account = (EditText)findViewById(R.id.et_account);
        et_password = (EditText)findViewById(R.id.et_password);
        et_service_ip = (EditText)findViewById(R.id.et_service_ip);
        bt_connect = (TextView)findViewById(R.id.bt_connect);
        bt_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogActivity.this,FaceActivity.class);
                startActivity(intent);
//                account = et_account.getText().toString();
//                password = et_password.getText().toString();
//                service_ip = et_service_ip.getText().toString();
//                customerDialog.setCancelable(false);
//                if (!account.isEmpty()||!password.isEmpty()||!service_ip.isEmpty()){
//                    P2PService.xmpp_service_name = service_ip;
//                    P2PService.xmpp_host = service_ip;
//                    customerDialog.show();
//                    mlController.loginToXmppService(account,password);
//                }else {
//                    Toast.makeText(LogActivity.this,"请输入你的账号和密码",Toast.LENGTH_SHORT).show();
//                }
            }
        });
        bt_reg = (TextView)findViewById(R.id.bt_reg);
        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogActivity.this,RegActivity.class);

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mlController.setActivityListener(this);
    }

    @Override
    public void singal(int singal) {
        if (!isLog){
            switch (singal){
                case 0:Toast.makeText(LogActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    startMainActivity();
                    customerDialog.dismiss();
                    isLog = true;
                    finish();
                    break;
                case 1:Toast.makeText(LogActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                    customerDialog.dismiss();
                    break;
            }
        }

    }
    public void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("account",account);
        intent.putExtra("password",password);
        startActivity(intent);
    }
}
