package com.init.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.init.listener.ReceivceFaceInfoListener;
import com.init.ui.mengliao.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by zoson on 3/29/15.
 */
public class FaceIdentify {
    static int i = 0;
    Context context;
    String facialinfo;
    ReceivceFaceInfoListener receivceFaceInfoListener;
    HttpRequests httpRequests;
    CameraService cameraService;
    int count;
    public FaceIdentify(CameraService cameraService) {
        this.context = context;
        facialinfo = "";
        count = 0;
        this.cameraService = cameraService;
        this.cameraService.setFaceIdentify(this);
        httpRequests = new HttpRequests("08f1b404a0d813700de207cc3c0c5a80", "8QMwZl08qvuyVGTHD5gzffvSduWUV8KX", true, true);

    }
    public void setReceivceFaceInfoListener(ReceivceFaceInfoListener listener){
        this.receivceFaceInfoListener = listener;
    }
    public void receivceFaceInfo(){
        if (facialinfo.equals(""))return;
        receivceFaceInfoListener.receivceFaceInfo(facialinfo);
    }
    public void getRequireFaceInfo(final byte[] imageByte) {
        new Thread(){
            @Override
            public void run() {
                try {
                    JSONObject js = httpRequests.detectionDetect(new PostParameters().setImg(imageByte));
                    System.out.println("detectionDetect"+js.toString());
                    String face_id = "";
                    try {
                        face_id = js.getJSONArray("face").getJSONObject(0).getString("face_id");
                        facialinfo = httpRequests.detectionLandmark(new PostParameters().setFaceId(face_id)).toString();
                        System.out.println("faceInfo:"+facialinfo);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (FaceppParseException e) {
                    e.printStackTrace();
                }finally {
                    if (facialinfo == null) {
                        facialinfo = "";
                    }
                }
                receivceFaceInfo();
            }
        }.start();
    }
}