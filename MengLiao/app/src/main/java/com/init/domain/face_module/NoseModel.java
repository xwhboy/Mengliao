package com.init.domain.face_module;

import java.util.List;

/**
 * Created by zoson on 3/26/15.
 */
public class NoseModel extends OrganModel {
    public static final String[] nosePoint = {
            "nose_contour_right1",
            "nose_contour_right2",
            "nose_right",
            "nose_contour_right3",
            "nose_right",
            "nose_contour_lower_middle",
            "nose_contour_left3",
            "nose_left",
            "nose_contour_left2",
            "nose_contour_left1",

            "nose_tip"
    };
    private List<Position> pos;

    public NoseModel(List<Position> lis) {
        super();
        pos = lis;
    }
    public List<Position> getPos(){
        return pos;
    }

}
