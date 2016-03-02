package com.init.domain.face_module;

/**
 * Created by zoson on 3/26/15.
 */
public abstract class OrganModel {

    public OrganModel() {

    }

    public float getK(Position p1,Position p2){
        float x_cha = p1.getX() - p2.getX();
        if (x_cha == 0){
            return  10.0f;
        }
        float y_cha = p1.getY() - p2.getY();
        float k = y_cha/x_cha;
        return k;
    }
    public float getD(Position p1,Position p2){
        float x_cha = p1.getX() - p2.getX();
        float y_cha = p1.getY() - p2.getY();
        double distance_2 = Math.pow(y_cha,2.0)+ Math.pow(x_cha,2.0);
        float distance = (float)Math.pow(distance_2,0.5);
        return distance;
    }


}
