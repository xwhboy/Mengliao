package com.init.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.init.listener.ActivityListener;
import com.init.domain.face_module.FaceController;
import com.init.domain.MlController;
import com.init.service.CameraService;
import com.init.ui.mengliao.R;


public class FaceActivity extends ActionBarActivity implements ActivityListener{

    private ImageButton bt_call;
    private FaceView fv;
    private SurfaceView cameraView;
    private FaceController fc;
    private Boolean isClick;
    private CameraService cameraService;
    private MlController ml_controller;
    private TextView tv_duifang;
    private String account;
    private String account_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);
        isClick = false;
        initView();
        setListener();
        System.out.println("FaceActivity-start");
        getLastActivityData();
        ml_controller = MlController.getInstance();
        ml_controller.setActivity(this);
        account_me = MainActivity.account;
        //ml_controller.sendMessage(account_me,account);
    }
    protected void getLastActivityData(){
        Intent intent = getIntent();
        account = intent.getStringExtra("account");
    }
    protected void initView(){
        bt_call = (ImageButton)findViewById(R.id.ib_call);
        fv = (FaceView)findViewById(R.id.fv_face);
        tv_duifang = (TextView)findViewById(R.id.tv_duifang);
        cameraView = (SurfaceView)findViewById(R.id.fv_camera);
    }
    protected void setListener(){
        bt_call.setOnClickListener(new OnClickButtonListener());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
        ml_controller.destroyMl();
        if (cameraService!=null){
            cameraService.deleteCamera();
        }

        fv.destroyFaceView();
        //cameraView = null;
        //fv = null;
    }

    @Override
    public void singal(int singal) {

    }

    private class OnClickButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if (!isClick){
                isClick = !isClick;
                startFace();
                tv_duifang.setText("再点击一次进行语音识别");
                //cameraService.getCamera().startPreview();
            }else{
                startVoiceRecognize();
                //fc.destoryFaceModel();
                //cameraService.getCamera().stopPreview();
                //cameraService.deleteCamera();
            }
        }
    }
    public void startFace(){
        cameraService = new CameraService(cameraView.getHolder());
        fc = new FaceController(this,fv,cameraService);
        ml_controller.startFaceController(fc);
    }
    public void startVoiceRecognize(){
        ml_controller.startReco();
    }

    public TextView getTv_duifang() {
        return tv_duifang;
    }

}
