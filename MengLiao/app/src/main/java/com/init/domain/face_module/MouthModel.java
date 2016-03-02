package com.init.domain.face_module;

import com.init.ui.mengliao.R;

import java.util.List;

/**
 * Created by zoson on 3/26/15.
 */
public class MouthModel extends OrganModel {
    public static final String[] mouthPointOriginal = {
            "mouth_left_corner",
            "mouth_lower_lip_bottom",
            "mouth_lower_lip_left_contour1",
            "mouth_lower_lip_left_contour2",
            "mouth_lower_lip_left_contour3",

            "mouth_lower_lip_right_contour1",
            "mouth_lower_lip_right_contour2",
            "mouth_lower_lip_right_contour3",
            "mouth_lower_lip_top",
            "mouth_right_corner",

            "mouth_upper_lip_bottom",
            "mouth_upper_lip_left_contour1",
            "mouth_upper_lip_left_contour2",
            "mouth_upper_lip_left_contour3",
            "mouth_upper_lip_right_contour1",

            "mouth_upper_lip_right_contour2",
            "mouth_upper_lip_right_contour3",
            "mouth_upper_lip_top"
    };
    public static final String[] mouthPoint ={
            "mouth_left_corner",
            "mouth_upper_lip_left_contour3",
            "mouth_upper_lip_bottom",
            "mouth_upper_lip_right_contour3",
            "mouth_right_corner",
            "mouth_lower_lip_right_contour1",
            "mouth_lower_lip_top",
            "mouth_lower_lip_left_contour1",
            "mouth_left_corner",

            "mouth_lower_lip_left_contour2",
            "mouth_lower_lip_left_contour3",
            "mouth_lower_lip_bottom",
            "mouth_lower_lip_right_contour3",
            "mouth_lower_lip_right_contour2",

            "mouth_upper_lip_left_contour2",
            "mouth_upper_lip_left_contour1",
            "mouth_upper_lip_top",
            "mouth_upper_lip_right_contour1",
            "mouth_upper_lip_right_contour2",
    };
    int[] mouth_b = {
            R.drawable.mouth_0_b,
            R.drawable.mouth_angry_b,
            R.drawable.mouth_astonished_b,
            R.drawable.mouth_detest_b,
            R.drawable.mouth_frightened_b,
            R.drawable.mouth_happy_r_b,
            R.drawable.mouth_sad_b,
            R.drawable.mouth_smile_b
    };
    int[] mouth_g = {
            R.drawable.mouth_normal_g,
            R.drawable.mouth_angry_g,
            R.drawable.mouth_astonished_g,
            R.drawable.mouth_detest_g,
            R.drawable.mouth_fear_g,
            R.drawable.mouth_happy_g,
            R.drawable.mouth_sad_g,
            R.drawable.mouth_smile_g
    };
    private int mouth_pic = R.drawable.mouth_normal_g;
    private List<Position> pos;
    public MouthModel(List<Position> a){
        pos =a;
    }
    public List<Position> getPos(){
        return pos;
    }
    public int getMouthPic(){
        float k_8_2 = getK(pos.get(8),pos.get(2));
        float k_2_4 = getK(pos.get(2),pos.get(4));
        float k_4_6 = getK(pos.get(4),pos.get(6));
        float k_6_8 = getK(pos.get(6),pos.get(8));

        float d_8_4 = getD(pos.get(8),pos.get(4));
        float d_2_6 = getD(pos.get(2),pos.get(6));

        float r = d_8_4/d_2_6;
        System.out.println("r=========mouth========"+r+"=====k_8_2"+k_8_2);
        if (r>15f){
            if (k_8_2>0.1f){
                if (FaceModel.sex){
                    return R.drawable.mouth_smile_b;
                }else {
                    return mouth_pic = R.drawable.mouth_smile_g;
                }

            }else if (k_8_2<0f){
                if (FaceModel.sex){
                    return mouth_pic = R.drawable.mouth_sad_b;
                }else {
                    return mouth_pic = R.drawable.mouth_sad_g;
                }

            }
            if (!FaceModel.sex){
                return mouth_pic = R.drawable.mouth_normal_g;
            }else {
                return R.drawable.mouth_0_b;
            }

        }else {
            if (r>8f){
                if (FaceModel.sex){
                    return R.drawable.mouth_detest_b;
                }else {
                    return mouth_pic = R.drawable.mouth_detest_g;
                }

            }
            if (r>6&&r<8f){
                if (FaceModel.sex){
                    return R.drawable.mouth_happy_r_b;
                }else {
                    return mouth_pic = R.drawable.mouth_happy_g;
                }

            }else {
                if (r <6f&&r>4f){
                    if (FaceModel.sex){
                        return R.drawable.mouth_angry_b;
                    }else {
                        return mouth_pic = R.drawable.mouth_angry_g;
                    }

                }
                if (k_8_2<0f&&k_8_2>-0.5f){
                    if (FaceModel.sex){
                        return R.drawable.mouth_frightened_b;
                    }
                    return mouth_pic = R.drawable.mouth_fear_g;
                }else if (k_8_2<0&&k_8_2>-1.0){
                    if (FaceModel.sex){
                        return R.drawable.mouth_astonished_b;
                    }else {
                        return mouth_pic = R.drawable.mouth_astonished_g;
                    }

                }
                if (FaceModel.sex){
                    return R.drawable.mouth_astonished_b;
                }else {
                    return mouth_pic = R.drawable.mouth_astonished_g;
                }

            }
        }
    }


}
