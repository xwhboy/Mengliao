package com.init.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.view.SurfaceHolder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by zoson on 4/2/15.
 */
public class CameraService implements Camera.PreviewCallback{

    Camera camera;
    byte[] imageByte;
    Camera.Parameters parameters;
    int width;
    int height;
    int count = 0;
    boolean if_getImg = false;

    public void setFaceIdentify(FaceIdentify faceIdentify) {
        this.faceIdentify = faceIdentify;
    }

    FaceIdentify faceIdentify;
    public CameraService(SurfaceHolder surfaceHolder){
        camera = Camera.open(1);
        parameters = camera.getParameters();
        parameters.setPreviewSize(352,288);
        camera.setParameters(parameters);
        width = parameters.getPreviewSize().width;
        height = parameters.getPreviewSize().height;
        try {
            camera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        camera.startPreview();
        camera.setDisplayOrientation(90);
        camera.setPreviewCallback(this);
        imageByte = ("").getBytes();
    }
    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        System.out.println("onPreviewFrame");
        //Camera.Parameters parameters = camera.getParameters();
        int imageFormat = parameters.getPreviewFormat();

        Rect rect = new Rect(0,0,width,height);
        YuvImage yuvImage = new YuvImage(data,imageFormat,width,height,null);

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(rect,100,outputStream);
            imageByte = outputStream.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        Bitmap mp = BitmapFactory.decodeByteArray(imageByte,0,imageByte.length);
        Matrix m = new Matrix();
        m.setRotate(270);
        Bitmap mpp = Bitmap.createBitmap(mp,0,0,width,height,m,true);
        imageByte = BitmapToBytes(mpp);
        count++;
        if(count == 8){
            if (faceIdentify == null){
                count = 0;
                return;
            }
            faceIdentify.getRequireFaceInfo(imageByte);
            count = 0;
        }
    }
    public Camera getCamera(){
        return camera;
    }
    public byte[] getImageByte(){
        return imageByte;
    }
    public byte[] BitmapToBytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG,100,baos);
        return baos.toByteArray();
    }
    public void deleteCamera(){
        camera.stopPreview();
        camera.release();
        camera = null;
    }
}
