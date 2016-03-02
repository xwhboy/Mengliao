package com.init.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.init.listener.FaceChangeListener;
import com.init.domain.face_module.EyeModel;
import com.init.domain.face_module.FaceModel;
import com.init.domain.face_module.FacialInfo;
import com.init.domain.face_module.FeatureModel;
import com.init.domain.face_module.MouthModel;
import com.init.domain.face_module.NoseModel;
import com.init.domain.face_module.Position;
import com.init.ui.mengliao.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zoson on 3/24/15.
 */
public class FaceView extends SurfaceView implements SurfaceHolder.Callback , FaceChangeListener{

    private SurfaceHolder holder;
    private Context context;
    private Canvas canvas;
    private Paint paint = new Paint();
    private float center_x;
    private float center_y;
    //test
    private Boolean a = false;
    private float x = 0f;
    private float y =0f;
    private FacialInfo face;
    private int fada = 10;

    private int nictation = 10;

    private Timer timer;
    private Timer timer_refurbish;

    private int eye_l = R.drawable.eyes_l_0_g;
    private int eye_r = R.drawable.eyes_r_0_g;
    private int eyebrow_l = R.drawable.eyebrows_l_0_g;
    private int eyebrow_r = R.drawable.eyebrows_r_0_g;
    private int mouth = R.drawable.mouth_normal_g;

    public FaceView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public FaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public void init(){
        this.setBackgroundColor(0xeeeeee);
        this.holder = this.getHolder();
        holder.addCallback(this);
       // paint = new Paint();
        center_x = getWidth()/2;
        center_y = getHeight()/2;
        timer = new Timer();
        if (FaceModel.sex){
            eye_l = R.drawable.eyes_l_0_b;
            eye_r = R.drawable.eyes_r_0_b;
            eyebrow_l = R.drawable.eyebrows_l_0_b;
            eyebrow_r = R.drawable.eyebrows_r_0_b;
            mouth = R.drawable.mouth_0_b;
        }else {
            eye_l = R.drawable.eyes_l_0_g;
            eye_r = R.drawable.eyes_r_0_g;
            eyebrow_l = R.drawable.eyebrows_l_0_g;
            eyebrow_r = R.drawable.eyebrows_r_0_g;
            mouth = R.drawable.mouth_normal_g;
        }

    }

    public void startDrawFace(){
        timer.schedule(new TimerTask_FaceChange(),0,5000);

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.holder = holder;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }


    @Override
    public void  faceChange(final FacialInfo faceInfo,final FaceModel faceModel) {

        face = faceInfo;
        System.out.println("facePaint");
        //System.out.println("faceInfo::::::::::"+face.getFacialInfoStr());
        /*
        if(faceInfo.getFacialInfoStr().equals("")){
            return;
        }*/

        new Thread(){

            @Override
            public void run() {
                canvas = holder.lockCanvas();
                if (holder == null || canvas == null){
                    return;
                }
                a = !a;

                paint.setColor(Color.BLACK);
                canvas.drawRect(0, -400, getWidth(), getHeight(), paint);
                Bitmap bitmap;
                if (FaceModel.sex){
                    bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.face_b);
                }else {
                    bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.face_g);
                }

                canvas.drawBitmap(bitmap, -80, -400, paint);
                bitmap.recycle();
                bitmap = BitmapFactory.decodeResource(getResources(),eyebrow_l = faceInfo.getRes_pic_eye_brow_left());
                canvas.drawBitmap(bitmap,-80,-400,paint);
                bitmap.recycle();
                bitmap = BitmapFactory.decodeResource(getResources(),eyebrow_r = faceInfo.getRes_pic_eye_brow_right());
                canvas.drawBitmap(bitmap,-80,-400,paint);
                bitmap.recycle();
                bitmap = BitmapFactory.decodeResource(getResources(),eye_l = faceInfo.getRes_pic_eye_left());
                canvas.drawBitmap(bitmap,-80,-400,paint);
                bitmap.recycle();
                bitmap = BitmapFactory.decodeResource(getResources(),eye_r = faceInfo.getRes_pic_eye_right());
                canvas.drawBitmap(bitmap,-80,-400,paint);
                bitmap.recycle();
                bitmap = BitmapFactory.decodeResource(getResources(),mouth = faceInfo.getRes_pic_mouth());
                canvas.drawBitmap(bitmap,-80,-400,paint);



                paint.setColor(Color.WHITE);
                Position temp;
                EyeModel tempElModel = faceModel.getEyesModel();
                temp = tempElModel.getPos_left().get(0);
                Position cankao = faceModel.getNoseModel().getPos().get(7);
                float xd_x = getWidth()/2 - cankao.getX()*fada;
                float xd_y = 300 - cankao.getY()*fada;
                System.out.println("xd_x:"+xd_x+"  xd_y:"+xd_y);
                System.out.println("center_x:"+getWidth()+" center_y:"+getHeight());
                float c_x = cankao.getX()*fada+xd_x;
                float c_y = cankao.getY()*fada+xd_y;
                System.out.println("cankao:"+c_x+  "cankao:"+c_y);
                for (int i = 0;i<EyeModel.eyeOfleftPoint.length;i++){
                    float x = (faceModel.getEyesModel().getPos_left().get(i).getX()*fada+xd_x);
                    float y = (faceModel.getEyesModel().getPos_left().get(i).getY()*fada+xd_y);
                    float temp_x = (temp.getX()*fada+xd_x);
                    float temp_y = (temp.getY()*fada+xd_y);
                    if (i==0){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                    }
                    if (i>0&&i<=8) {
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                       // canvas.drawLine(temp_x,temp_y,x,y,paint);
                        temp = tempElModel.getPos_left().get(i);
                    }
                    if (i == 9){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        //canvas.drawCircle(x,y,10,paint);
                        temp = tempElModel.getPos_left().get(11);
                    }
                    if (i>10){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        //canvas.drawLine(temp_x,temp_y,x,y,paint);
                        temp = tempElModel.getPos_left().get(i);
                    }
                }
                EyeModel tempErModel = faceModel.getEyesModel();
                temp = tempErModel.getPos_right().get(0);
                for (int i = 0;i< EyeModel.eyeOfRightPoint.length;i++){
                    float x = (faceModel.getEyesModel().getPos_right().get(i).getX()*fada+xd_x);
                    float y = (faceModel.getEyesModel().getPos_right().get(i).getY()*fada+xd_y);
                    float temp_x = (temp.getX()*fada+xd_x);
                    float temp_y = (temp.getY()*fada+xd_y);
                    if (i==0){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        canvas.drawCircle(x,y,1,paint);
                    }
                    if (i>0&&i<=8) {
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        canvas.drawLine(temp_x,temp_y,x,y,paint);
                        temp = tempErModel.getPos_right().get(i);
                    }
                    if (i == 9){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        //canvas.drawCircle(x,y,10,paint);
                        temp = tempErModel.getPos_right().get(11);
                    }
                    if (i>10){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        canvas.drawLine(temp_x,temp_y,x,y,paint);
                        temp = tempErModel.getPos_right().get(i);
                    }
                }
                MouthModel tempMouthModel = faceModel.getMouthModel();
                temp = tempMouthModel.getPos().get(0);
                for (int i = 0;i< MouthModel.mouthPoint.length;i++){
                    float x = (faceModel.getMouthModel().getPos().get(i).getX()*fada+xd_x);
                    float y = (faceModel.getMouthModel().getPos().get(i).getY()*fada+xd_y);
                    float temp_x = (temp.getX()*fada+xd_x);
                    float temp_y = (temp.getY()*fada+xd_y);
                    if (i>=0&&i<=8) {
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        canvas.drawLine(temp_x, temp_y, x, y, paint);
                    }else if(i==9){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        canvas.drawCircle(x,y,1,paint);
                    }else if (i>9&&i<=13){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        canvas.drawLine(temp_x,temp_y,x,y,paint);
                    }else if (i == 14){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        canvas.drawCircle(x,y,1,paint);
                    }else if (i>14){
                        paint.setStrokeWidth(3);
                        canvas.drawText(""+i,x,y,paint);
                        paint.setStrokeWidth(1);
                        canvas.drawLine(temp_x,temp_y,x,y,paint);
                    }
                    temp = tempMouthModel.getPos().get(i);
                }
                FeatureModel tempFeatureModel = faceModel.getFeatureModel();
                temp = tempFeatureModel.getPos().get(0);
                for (int i = 0;i< FeatureModel.featurePoint.length;i++){
                    float x = (tempFeatureModel.getPos().get(i).getX()*fada+xd_x);
                    float y = tempFeatureModel.getPos().get(i).getY()*fada+xd_y;

                    float temp_x = temp.getX()*fada+xd_x;
                    float temp_y = temp.getY()*fada+xd_y;
                    paint.setStrokeWidth(3);
                    canvas.drawText(""+i,x,y,paint);
                    paint.setStrokeWidth(1);
                    canvas.drawLine(temp_x,temp_y,x,y,paint);
                    temp = tempFeatureModel.getPos().get(i);
                }
                NoseModel tempNoseModel = faceModel.getNoseModel();
                temp = tempNoseModel.getPos().get(0);
                for (int i = 0 ;i< NoseModel.nosePoint.length-1;i++){

                    float x = tempNoseModel.getPos().get(i).getX()*fada+xd_x;
                    float y = tempNoseModel.getPos().get(i).getY()*fada+xd_y;

                    float temp_x = temp.getX()*fada +xd_x;
                    float temp_y = temp.getY()*fada+xd_y;
                    paint.setStrokeWidth(3);
                    canvas.drawText(""+i,x,y,paint);
                    paint.setStrokeWidth(1);
                    canvas.drawLine(temp_x,temp_y,x,y,paint);
                    temp = tempNoseModel.getPos().get(i);
                }
                canvas.drawCircle(tempNoseModel.getPos().get(10).getX()*fada+xd_x,tempNoseModel.getPos().get(9).getY()*fada+xd_y,3,paint);

                holder.unlockCanvasAndPost(canvas);
                System.out.println("FacechangeandPaint");

            }
        }.start();

        //刷新face成正常状态

        timer_refurbish = new Timer();
        timer_refurbish.schedule(new TimerTask(){

            @Override
            public void run() {
                if (FaceModel.sex){
                    eye_l = R.drawable.eyes_l_0_b;
                    eye_r = R.drawable.eyes_r_0_b;
                    eyebrow_l = R.drawable.eyebrows_l_0_b;
                    eyebrow_r = R.drawable.eyebrows_r_0_b;
                    mouth = R.drawable.mouth_0_b;
                }else {
                    eye_l = R.drawable.eyes_l_0_g;
                    eye_r = R.drawable.eyes_r_0_g;
                    eyebrow_l = R.drawable.eyebrows_l_0_g;
                    eyebrow_r = R.drawable.eyebrows_r_0_g;
                    mouth = R.drawable.mouth_normal_g;
                }

            }
        },0,1000);

    }
    public void destroyFaceView(){
        if (timer_refurbish != null){
            timer_refurbish.cancel();
            timer_refurbish = null;
        }
        if (timer != null){
            timer.cancel();
            timer = null;
        }

    }


    private class TimerTask_FaceChange extends TimerTask{
        @Override
        public void run(){
            if (FaceModel.sex){
                DrawFace(R.drawable.face_b,R.drawable.eyebrows_l_0_b,R.drawable.eyebrows_r_0_b,R.drawable.eye_nictation_l_0_b,R.drawable.eye_nictation_r_0_b,R.drawable.mouth_0_b);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DrawFace(R.drawable.face_b, eyebrow_l, eyebrow_r, eye_l, eye_r, mouth);
            }else{
                DrawFace(R.drawable.face_g,R.drawable.eyebrows_l_0_g,R.drawable.eyebrows_r_0_g,R.drawable.eye_nictation_l_0_g,R.drawable.eye_nictation_r_0_g,R.drawable.mouth_normal_g);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DrawFace(R.drawable.face_g, eyebrow_l, eyebrow_r, eye_l, eye_r, mouth);

            }

        }
    }
    private void DrawFace(int face,int eyebrow_left,int eyebrow_right,int eye_left,int eye_right,int mouth){
        canvas = holder.lockCanvas();
        if (holder == null || canvas == null){
            return;
        }
        paint.setColor(Color.BLACK);
        canvas.drawRect(0,0,getWidth(),getHeight(),paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),face);
        canvas.drawBitmap(bitmap,-80,-400,paint);
        bitmap.recycle();
        bitmap = BitmapFactory.decodeResource(getResources(),eyebrow_left);
        canvas.drawBitmap(bitmap,-80,-400,paint);
        bitmap.recycle();
        bitmap = BitmapFactory.decodeResource(getResources(),eyebrow_right);
        canvas.drawBitmap(bitmap,-80,-400,paint);
        bitmap.recycle();
        bitmap = BitmapFactory.decodeResource(getResources(),eye_left);
        canvas.drawBitmap(bitmap,-80,-400,paint);
        bitmap.recycle();
        bitmap = BitmapFactory.decodeResource(getResources(),eye_right);
        canvas.drawBitmap(bitmap,-80,-400,paint);
        bitmap.recycle();
        bitmap = BitmapFactory.decodeResource(getResources(),mouth);
        canvas.drawBitmap(bitmap,-80,-400,paint);
        bitmap.recycle();
        holder.unlockCanvasAndPost(canvas);
    }
}
