package com.init.domain.face_module;

import com.init.ui.mengliao.R;

import java.util.List;

/**
 * Created by zoson on 4/14/15.
 */
public class EyeModel extends OrganModel {
    protected int[] eyebrows_l_picres_g = {
            R.drawable.eyebrows_l_0_g,
            R.drawable.eyebrows_l_1_g,//愤怒
            R.drawable.eyebrows_l_2_g,//笑，弧形
            R.drawable.eyebrows_l_3_g//可怜
    };
    protected int[] eyebrows_r_picres_g = {
            R.drawable.eyebrows_r_0_g,
            R.drawable.eyebrows_r_1_g,
            R.drawable.eyebrows_r_2_g,
            R.drawable.eyebrows_r_3_g
    };
    protected int[] eye_l_picres_g = {
            R.drawable.eyes_l_0_g,
            R.drawable.eyes_l_angry_g,
            R.drawable.eyes_l_astonished_g,
            R.drawable.eyes_l_detest_g,
            R.drawable.eyes_l_fear_g,
            R.drawable.eyes_l_happy_g,
            R.drawable.eyes_l_sad_g,
            R.drawable.eye_nictation_l_0_g,
            R.drawable.eye_nictation_l_1_g
    };
    protected int[] eye_r_picres_g = {
            R.drawable.eyes_r_0_g,
            R.drawable.eyes_r_angry_g,
            R.drawable.eyes_r_astonish_g,
            R.drawable.eyes_r_detest_g,
            R.drawable.eyes_r_fear_g,
            R.drawable.eyes_r_happy_g,
            R.drawable.eyes_r_sad_g,
            R.drawable.eye_nictation_r_0_g,
            R.drawable.eye_nictation_r_1_g
    };
    protected int[] eyebrows_l_picres_b = {
            R.drawable.eyebrows_l_0_b,
            R.drawable.eyebrows_angry_l_b,
            R.drawable.eyebrows_happy_l_b,
            R.drawable.eyebrows_sad_l_b
    };
    protected int[] eyebrows_r_picres_b = {
            R.drawable.eyebrows_r_0_b,
            R.drawable.eyebrows_angry_r_b,
            R.drawable.eyebrows_happy_r_b,
            R.drawable.eyebrows_sad_r_b
    };
    protected int[] eye_l_picres_b = {
            R.drawable.eyes_l_0_b,
            R.drawable.eyes_angry_l_b,
            R.drawable.eyes_astonished_l_b,
            R.drawable.eyes_detest_l_b,
            R.drawable.eyes_frightened_l_b,
            R.drawable.eyes_happy_l_b,
            R.drawable.eyes_sad_l_b,
            R.drawable.eye_nictation_l_0_b,
            R.drawable.eye_nictation_l_1_b
    };
    protected int[] eye_r_picres_b = {
            R.drawable.eyes_r_0_b,
            R.drawable.eyes_angry_r_b,
            R.drawable.eyes_astonished_r_b,
            R.drawable.eyes_detest_r_b,
            R.drawable.eyes_frightened_r_b,
            R.drawable.eyes_happy_r_b,
            R.drawable.eyes_sad_r_b,
            R.drawable.eye_nictation_r_0_b,
            R.drawable.eye_nictation_r_1_b
    };
    public final static String[] eyeOfleftPointOriginal = {
            "0 left_eye_bottom",
            "1 left_eye_center",
            "2 left_eye_left_corner",
            "3 left_eye_lower_left_quarter",
            "4 left_eye_lower_right_quarter",
            "5 left_eye_pupil",
            "6 left_eye_right_corner",
            "7 left_eye_top",
            "8 left_eye_upper_left_quarter",
            "9 left_eye_upper_right_quarter",
            "10 left_eyebrow_left_corner",
            "11 left_eyebrow_lower_left_quarter",
            "12 left_eyebrow_lower_middle",
            "13 left_eyebrow_lower_right_quarter",
            "14 left_eyebrow_right_corner",
            "15 left_eyebrow_upper_left_quarter",
            "16 left_eyebrow_upper_middle",
            "17 left_eyebrow_upper_right_quarter"
    };
    public final static String[] eyeOfleftPoint = {
            "left_eye_bottom",
            "left_eye_lower_left_quarter",
            "left_eye_left_corner",
            "left_eye_upper_left_quarter",
            "left_eye_top",
            "left_eye_upper_right_quarter",
            "left_eye_right_corner",
            "left_eye_lower_right_quarter",
            "left_eye_bottom",
            "left_eye_center",
            "left_eye_pupil",

            "left_eyebrow_left_corner",
            "left_eyebrow_lower_left_quarter",
            "left_eyebrow_lower_middle",
            "left_eyebrow_lower_right_quarter",
            "left_eyebrow_right_corner",
            "left_eyebrow_upper_right_quarter",
            "left_eyebrow_upper_middle",
            "left_eyebrow_upper_left_quarter",
            "left_eyebrow_left_corner",

    };

    public static final String[] eyeOfRightPointOrigial = {
            "right_eye_bottom",
            "right_eye_center",
            "right_eye_left_corner",
            "right_eye_lower_left_quarter",
            "right_eye_lower_right_quarter",
            "right_eye_pupil",
            "right_eye_right_corner",
            "right_eye_top",
            "right_eye_upper_left_quarter",
            "right_eye_upper_right_quarter",
            "right_eyebrow_left_corner",
            "right_eyebrow_lower_left_quarter",
            "right_eyebrow_lower_middle",
            "right_eyebrow_lower_right_quarter",
            "right_eyebrow_right_corner",
            "right_eyebrow_upper_left_quarter",
            "right_eyebrow_upper_middle",
            "right_eyebrow_upper_right_quarter",
    };
    public static final String[] eyeOfRightPoint = {
            "right_eye_bottom",
            "right_eye_lower_left_quarter",
            "right_eye_left_corner",
            "right_eye_upper_left_quarter",
            "right_eye_top",
            "right_eye_upper_right_quarter",
            "right_eye_right_corner",
            "right_eye_lower_right_quarter",
            "right_eye_bottom",

            "right_eye_center",
            "right_eye_pupil",

            "right_eyebrow_left_corner",
            "right_eyebrow_lower_left_quarter",
            "right_eyebrow_lower_middle",
            "right_eyebrow_lower_right_quarter",
            "right_eyebrow_right_corner",
            "right_eyebrow_upper_right_quarter",
            "right_eyebrow_upper_middle",
            "right_eyebrow_upper_left_quarter",
            "right_eyebrow_left_corner",
    };

    private float[] precision = {
            0f,0.01f,0.02f,0.03f,0.04f,0.05f,0.06f,0.07f,0.08f,0.09f,0.1f,0.2f
    };
    private float[] rate = {
            2.0f,2.5f,3.0f,3.2f,4.0f,4.5f,5.0f,5.5f,6.0f,10.0f
    };
    private List<Position> pos_left;

    public List<Position> getPos_right() {
        return pos_right;
    }

    public List<Position> getPos_left() {
        return pos_left;
    }

    private List<Position> pos_right;
    private int eyeBrowsPic_left = R.drawable.eyebrows_l_0_b;
    private int eyePic_left = R.drawable.eyes_l_0_b;
    private int eyeBrowsPic_right = R.drawable.eyebrows_r_0_b;
    private int eyePic_right = R.drawable.eyes_r_0_b;

    public void setLeftPosition(List<Position> list){
        this.pos_left = list;
    }
    public void setRightPosition(List<Position> list){
        this.pos_right = list;
    }
    public int getEyeBrowsPic_left() {
        float k_12_13 = getK(this.pos_left.get(12),this.pos_left.get(13));
        float k_13_14 = getK(this.pos_left.get(13),this.pos_left.get(14));
        float k_12_14 = getK(this.pos_left.get(12),this.pos_left.get(14));
        float[] k = {k_12_13,k_13_14,k_12_14};
        for (float a:k){
            System.out.println("k::::"+a);
        }
        return eyeBrowsPic_left = get_eyebrow_pic(k,true);
    }
    public int getEyePic_left() {
        float d_2_6 = getD(pos_left.get(2),pos_left.get(6));
        float d_4_8 = getD(pos_left.get(4),pos_left.get(8));

        float k_2_4 = getK(pos_left.get(2),pos_left.get(4));
        float k_4_6 = getK(pos_left.get(4),pos_left.get(6));
        float k_6_8 = getK(pos_left.get(6),pos_left.get(8));
        float k_8_2 = getK(pos_left.get(8),pos_left.get(2));

        float[] k = {
                d_2_6,d_4_8,k_2_4,k_4_6,k_6_8,k_8_2
        };
        return eyePic_left = get_eyes_Pic(k,true);
    }
    public int get_eyebrow_pic(float[] k,boolean is_l){
        if (is_l){
            if (k[0]<precision[0]){
                if (k[1]<precision[0]){
                    if (FaceModel.sex) {
                        return eyebrows_l_picres_b[3];
                    }else {
                        return eyebrows_l_picres_g[3];
                    }
                }else if (k[1]>precision[6]&&k[0]<-precision[6]){
                    if (FaceModel.sex){
                        return eyebrows_l_picres_b[2];
                    }else {
                        return eyebrows_l_picres_g[2];
                    }
                }else{
                    if (FaceModel.sex){
                        return eyebrows_l_picres_b[0];
                    }else {
                        return eyebrows_l_picres_g[0];
                    }
                }
            }else{
                if (k[0]>precision[8]&&k[1]>precision[8]||k[0]>precision[8]){
                    if (FaceModel.sex){
                        return eyebrows_l_picres_b[1];
                    }else {
                        return eyebrows_l_picres_g[1];
                    }
                }
            }
            if (FaceModel.sex){
                return eyebrows_l_picres_b[0];
            }else {
                return eyebrows_l_picres_g[0];
            }
        }else {
            if (k[0]>precision[0]){
                if (k[1]>precision[0]){
                    if (FaceModel.sex){
                        return eyebrows_r_picres_b[3];
                    }else {
                        return eyebrows_r_picres_g[3];
                    }
                }else if (k[1]<-precision[6]&&k[0]>precision[6]){
                    if (FaceModel.sex){
                        return eyebrows_r_picres_b[2];
                    }else {
                        return eyebrows_r_picres_g[2];
                    }

                }else{
                    if (FaceModel.sex){
                        return eyebrows_r_picres_b[0];
                    }else {
                        return eyebrows_r_picres_g[0];
                    }

                }
            }else{
                if (k[0]<-precision[8]&&k[1]<-precision[8]||k[0]<-precision[8]){
                    if (FaceModel.sex){
                        return eyebrows_r_picres_b[1];
                    }else {
                        return eyebrows_r_picres_g[1];
                    }
                }
            }
            if (FaceModel.sex){
                return eyebrows_r_picres_b[0];
            }else {
                return eyebrows_r_picres_g[0];
            }

        }
    }

    public int getEyeBrowsPic_right() {
        float k_14_13 = getK(this.pos_right.get(14),this.pos_right.get(13));
        float k_13_12 = getK(this.pos_right.get(13),this.pos_right.get(12));
        float k_14_12 = getK(this.pos_right.get(14),this.pos_right.get(12));

        float[] k = {k_14_13,k_13_12,k_14_12};
        for (float a:k){
            System.out.println("k::::"+a);
        }

        return eyeBrowsPic_right = get_eyebrow_pic(k,false);
    }

    public int getEyePic_right(){
        float d_2_6 = getD(pos_right.get(2),pos_right.get(6));
        float d_4_8 = getD(pos_right.get(4),pos_right.get(8));
        float k_6_4 = getK(pos_right.get(6),pos_right.get(4));
        float k_4_2 = getK(pos_right.get(4),pos_right.get(2));
        float k_2_8 = getK(pos_right.get(2),pos_right.get(8));
        float k_8_6 = getK(pos_right.get(8),pos_right.get(6));

        float[] k = {d_2_6,d_4_8,k_6_4,k_4_2,k_2_8,k_8_6};
        return get_eyes_Pic(k,false);
    }


    public int get_eyes_Pic(float[] k,boolean is_l){
        float r = k[0]/k[1];
        if (is_l){
            if (r > rate[4]){
                if (r>rate[6]){
                    if (r>rate[9]){
                        if (FaceModel.sex){
                            return eye_l_picres_b[7];
                        }else {
                            return eye_l_picres_g[7];
                        }

                    }
                    if (eyeBrowsPic_left == R.drawable.eyebrows_l_2_g||eyeBrowsPic_left == R.drawable.eyebrows_happy_l_b||k[2]<-0.16f){
                        if (FaceModel.sex){
                            return eye_l_picres_b[5];
                        }else {
                            return eye_l_picres_g[5];
                        }
                    }
                    if (FaceModel.sex){
                        return eye_l_picres_b[8];
                    }else {
                        return eye_l_picres_g[8];
                    }

                }else {
                    if (eyeBrowsPic_left == R.drawable.eyebrows_l_1_g||eyeBrowsPic_left == R.drawable.eyebrows_angry_l_b){
                        if (FaceModel.sex){
                            return eye_l_picres_b[1];
                        }else {
                            return eye_l_picres_g[1];
                        }
                    }else if (eyeBrowsPic_left == R.drawable.eyebrows_l_3_g||eyeBrowsPic_left == R.drawable.eyebrows_sad_l_b){
                        if (FaceModel.sex){
                            return eye_l_picres_b[6];
                        }else {
                            return eye_l_picres_g[6];
                        }
                    }
                }
            }else{
                if (r<rate[3]){
                    if (FaceModel.sex){
                        return eye_l_picres_b[2];
                    }else {
                        return eye_l_picres_g[2];
                    }

                }else {
                    if (FaceModel.sex){
                        return eye_l_picres_b[4];
                    }else {
                        return eye_l_picres_g[4];
                    }

                }
            }
            if (FaceModel.sex){
                return eye_l_picres_b[0];
            }else {
                return eye_l_picres_g[0];
            }

        }else {
            if (r > rate[4]){
                if (r>rate[6]){
                    if (r>rate[9]){
                        if (FaceModel.sex){
                            return eye_r_picres_b[7];
                        }else {
                            return eye_r_picres_g[7];
                        }

                    }
                    if (eyeBrowsPic_right == R.drawable.eyebrows_r_2_g||eyeBrowsPic_right == R.drawable.eyebrows_happy_r_b||k[2]>0.16f){
                        if (FaceModel.sex){
                            return eye_r_picres_b[5];
                        }else {
                            return eye_r_picres_g[5];
                        }

                    }
                    if (FaceModel.sex){
                        return eye_r_picres_b[8];
                    }else {
                        return eye_r_picres_g[8];
                    }

                }else {
                    if (eyeBrowsPic_right == R.drawable.eyebrows_r_1_g||eyeBrowsPic_right == R.drawable.eyebrows_angry_r_b){
                        if (FaceModel.sex){
                            return eye_r_picres_b[1];
                        }else {
                            return eye_r_picres_g[1];
                        }

                    }else if (eyeBrowsPic_right == R.drawable.eyebrows_r_3_g||eyeBrowsPic_right == R.drawable.eyebrows_sad_r_b){
                        if (FaceModel.sex){
                            return eye_r_picres_b[6];
                        }else {
                            return eye_r_picres_g[6];
                        }

                    }
                }
            }else{
                if (r<rate[3]){
                    if (FaceModel.sex){
                        return eye_r_picres_b[2];
                    }else {
                        return eye_r_picres_g[2];
                    }

                }else {
                    if (FaceModel.sex){
                        return eye_r_picres_b[4];
                    }else {
                        return eye_r_picres_g[4];
                    }

                }
            }
            if (FaceModel.sex){
                return eye_r_picres_b[0];
            }else {
                return eye_r_picres_g[0];
            }

        }

    }


}
