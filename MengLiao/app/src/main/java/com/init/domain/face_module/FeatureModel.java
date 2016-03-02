package com.init.domain.face_module;

import java.util.List;

/**
 * Created by zoson on 4/8/15.
 */
public class FeatureModel {
    private final String[] featurePointOrginal = {
            "contour_left1",
            "contour_left2",
            "contour_left3",
            "contour_left4",
            "contour_left5",
            "contour_left6",
            "contour_left7",
            "contour_left8",
            "contour_left9",
            "contour_chin",
            "contour_right1",
            "contour_right2",
            "contour_right3",
            "contour_right4",
            "contour_right5",
            "contour_right6",
            "contour_right7",
            "contour_right8",
            "contour_right9"
    };
    public static final String[] featurePoint = {
            "contour_left1",
            "contour_left2",
            "contour_left3",
            "contour_left4",
            "contour_left5",
            "contour_left6",
            "contour_left7",
            "contour_left8",
            "contour_left9",
            "contour_chin",
            "contour_right9",
            "contour_right8",
            "contour_right7",
            "contour_right6",
            "contour_right5",
            "contour_right4",
            "contour_right3",
            "contour_right2",
            "contour_right1"
    };
    private List<Position> pos;

    public FeatureModel(List<Position> lis) {
        super();
        pos = lis;
    }
    public List<Position> getPos(){
        return pos;
    }
}
