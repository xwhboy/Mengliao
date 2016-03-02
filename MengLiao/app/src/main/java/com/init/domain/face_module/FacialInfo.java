package com.init.domain.face_module;

/**
 * Created by zoson on 3/30/15.
 */
public class FacialInfo {

    private int res_pic_eye_brow_left;
    private int res_pic_eye_brow_right;
    private int res_pic_eye_left;
    private int res_pic_eye_right;
    private int res_pic_nose;
    private int res_pic_mouth;

    public FacialInfo(int res_el_brow,int res_el,int res_er_brow,int res_er,int res_m){
        this.res_pic_eye_left = res_el;
        this.res_pic_eye_right = res_er;
        this.res_pic_eye_brow_left = res_el_brow;
        this.res_pic_eye_brow_right = res_er_brow;
        this.res_pic_mouth = res_m;
    }


    public int getRes_pic_eye_brow_left() {
        return res_pic_eye_brow_left;
    }

    public int getRes_pic_eye_brow_right() {
        return res_pic_eye_brow_right;
    }

    public int getRes_pic_eye_left() {
        return res_pic_eye_left;
    }

    public int getRes_pic_eye_right() {
        return res_pic_eye_right;
    }

    public int getRes_pic_nose() {
        return res_pic_nose;
    }

    public int getRes_pic_mouth() {
        return res_pic_mouth;
    }

}
