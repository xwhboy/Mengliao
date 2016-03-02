package com.init.domain;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.init.listener.ActivityListener;
import com.init.listener.FaceInfoGetListener;
import com.init.listener.P2PListener;
import com.init.listener.VoiceRecoginzerFinishListener;
import com.init.domain.face_module.FaceController;
import com.init.service.Ml_VoiceRecognizer;
import com.init.service.P2PService;
import com.init.ui.FaceActivity;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zoson on 4/19/15.
 */
public class MlController implements P2PListener,VoiceRecoginzerFinishListener,FaceInfoGetListener{
    private FaceController faceController;

    private FaceActivity activity;
    private P2PService p2pService;
    private Ml_VoiceRecognizer vr;
    private Handler handler;
    private Timer timer_getFaceInfo;
    private Queue<String> queue_getFaceInfo;
    private ActivityListener activityListener;

    private static MlController mlController = new MlController();
    public static MlController getInstance(){
        return mlController;
    }
    public MlController(){
        handler = new Handle_Ml();
    }
    public void setActivityListener(ActivityListener listener){
        activityListener = listener;
    }
    public void loginToXmppService(String account,String password){
        this.p2pService = new P2PService(account,password,this);
        new Thread(){
            @Override
            public void run() {
                try {
                    if (p2pService.connect()){
                        Message msg = Message.obtain();
                        msg.what = 0x0;
                        msg.obj = 0;
                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Message msg = Message.obtain();
                msg.what = 0x0;
                msg.obj = 1;
                handler.sendMessage(msg);
            }
        }.start();
    }
    public ArrayList<String> getAllUser(){
        if (p2pService!=null){
            return p2pService.searchUsers("zoson");
        }
        return null;

    }
    public void setActivity(FaceActivity activity){
        this.activity = activity;
    }
   public void startFaceController(FaceController fc){
       System.out.println("startFaceController++++++");
       this.faceController = fc;
       fc.startFaceRecognize();
       queue_getFaceInfo = faceController.getQueue_face();
       timer_getFaceInfo = new Timer();
       timer_getFaceInfo.schedule(new TimerTask() {
           @Override
           public void run() {
               if (!queue_getFaceInfo.isEmpty()){
                   getFaceInfo(queue_getFaceInfo.poll());
               }
           }
       },0,1000);
   }

    public void sendMessage(String msg,String user){
        p2pService.createChat(user);
        p2pService.sendMessage(msg);
    }

    public void destroyMl(){
        if (timer_getFaceInfo==null){
            return;
        }
        timer_getFaceInfo.cancel();
        timer_getFaceInfo = null;
    }
    @Override
    public void getMessage(String content) {
        Message msg = Message.obtain();
        msg.what = 0x1;
        System.out.println("getContent============================"+content);
        String pre = content.split("&")[0];
        String cont = content.split("&")[1];
        if (pre.equals("voice")&&cont!=null){
            msg.obj = cont;
            handler.sendMessage(msg);
        }else{
            faceController.DealWithFaceInfo(cont);
        }

    }



    @Override
    public void voiceRecognizerFinish(String content) {
        p2pService.sendMessage("voice&"+content.substring(2,content.length()-2));
    }

    @Override
    public void voiceRecognizerStart() {
        activity.getTv_duifang().setText("我:开始说话");
    }

    @Override
    public void voiceRecognizerCancel() {
        Toast.makeText(activity, "说完了", Toast.LENGTH_SHORT).show();
    }

    public void startReco() {
        vr = new Ml_VoiceRecognizer(activity,this);
        vr.startRecognizer();
    }
    public void regXmpp(final String account, final String password){
        new Thread(){
            @Override
            public void run(){
                if(P2PService.regXmpp(account,password)){
                    Message message = Message.obtain();
                    message.what = 0;
                    message.obj = 0;
                    handler.sendMessage(message);
                }else {
                    Message message = Message.obtain();
                    message.what = 0;
                    message.obj = 1;
                }
            }
        }.start();

    }
    @Override
    public void getFaceInfo(String faceInfo) {
        System.out.println("getFaceInfo++++++");
        //p2pService.sendMessage("face&"+faceInfo);//联网
        faceController.DealWithFaceInfo(faceInfo);//本地测试
    }

    class Handle_Ml extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:activityListener.singal((int)msg.obj);break;
                case 1:activity.getTv_duifang().setText((String)msg.obj);break;
            }
        }
    }

}
