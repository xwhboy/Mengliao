package com.init.domain.face_module;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.init.listener.FaceChangeListener;
import com.init.listener.FaceInfoGetListener;
import com.init.listener.ReceivceFaceInfoListener;
import com.init.service.CameraService;
import com.init.service.FaceIdentify;
import com.init.ui.FaceView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;

/**
 * Created by zoson on 3/30/15.
 */
public class FaceController implements ReceivceFaceInfoListener {
    FaceView faceView;
    FaceModel faceModel;
    Context context;
    Timer timer_getFacialInfo;
    Handler handler;
    FaceIdentify faceIdentify;
    List<FaceChangeListener> faceListener;
    FaceInfoGetListener listener;
    Queue<String> queue_face;
    CameraService cameraService;
    private String preFaceInfo = "";

    public FaceController(Context context,FaceView fv,CameraService cameraService){
        this.cameraService = cameraService;
        this.context = context;
        this.faceView = fv;
        faceListener = new ArrayList<FaceChangeListener>();
        addFaceListener(fv);
    }
    public void startFaceRecognize(){
        faceIdentify = new  FaceIdentify(cameraService);
        faceIdentify.setReceivceFaceInfoListener(this);
        queue_face = new LinkedList<String>();
        handler = new Handler_face();
        faceView.startDrawFace();
    }
    public void addFaceListener(FaceChangeListener lis){
        faceListener.add(lis);
    }
    public void notifyFaceListener(){
        for (FaceChangeListener lis:faceListener){
            lis.faceChange(faceModel.getFacialInfo(),faceModel);
        }
    }

    @Override
    public void receivceFaceInfo(String faceInfo) {
        System.out.println("rece++");
        if (faceInfo.equals("")){
            return;
        }
        if (preFaceInfo.equals(faceInfo)){
            return;
        }
        preFaceInfo = faceInfo;
        System.out.println("faceInfo:"+faceInfo);
        System.out.println("queue="+queue_face.size());
        queue_face.offer(faceInfo);
    }
    public Queue<String> getQueue_face(){
        return queue_face;
    }
    public void DealWithFaceInfo(String faceinfo){
        System.out.println("dealWithFaceInfo+++++++++");
        faceModel = new FaceModel(faceinfo);
        Message msg = new Message();
        handler.sendMessage(msg);
    }

    class Handler_face extends Handler{
        @Override
        public void handleMessage(Message msg) {
            notifyFaceListener();
        }
    }
}
