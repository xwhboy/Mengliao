package test.qcui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 文浩 on 2015/8/14.
 */
public class WelcomRegisterActivity extends Activity{

//    注册账户按钮
    private Button bn_ewlreg;
//    使用说明文本
    private TextView instruction;
    private String instruction_text="说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明" +
            "说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明说明";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome_register);
        findView();
        setListener();
        initData();
    }


    private void findView(){
        bn_ewlreg=(Button) findViewById(R.id.wel_reg);
        instruction=(TextView)findViewById(R.id.instruction);
    }
    private void setListener(){
        bn_ewlreg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(WelcomRegisterActivity.this, PreSettingActivity.class);
                startActivity(intent);
                finish();
            }

        });
        instruction.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(WelcomRegisterActivity.this)
                        .setTitle("使用说明及条款")
                        .setMessage(instruction_text)
                        .setPositiveButton("     确定      ", null)
                        .show();
//                dialog.getWindow().setContentView(layout);
            }

        });
    }
    private void initData(){

        instruction.setText(Html.fromHtml("<u>" + "请阅读使用说明及条款" + "</u>"));
    }

}
