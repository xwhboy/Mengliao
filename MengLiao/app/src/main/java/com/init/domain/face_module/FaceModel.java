package com.init.domain.face_module;

import com.init.util.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoson on 3/26/15.
 */
public class FaceModel{
    public static boolean sex = true;
    EyeModel eyeModel;
    NoseModel noseModel;
    MouthModel mouthModel;
    FeatureModel featureModel;
    FacialInfo facialInfo = null;
    String facialInfoStr;
    JsonParser js;
    public FaceModel(String faceInfo){
        this.facialInfoStr = faceInfo;
        this.facialInfoStr = faceInfo;
        js = new JsonParser(faceInfo);
    }

    public FacialInfo getFacialInfo() {
        eyeModel = this.getEyesModel();
        mouthModel = this.getMouthModel();
        facialInfo = new FacialInfo(eyeModel.getEyeBrowsPic_left(),eyeModel.getEyePic_left(),eyeModel.getEyeBrowsPic_right(),eyeModel.getEyePic_right(),mouthModel.getMouthPic());
        return facialInfo;
    }
    //test
    public EyeModel getEyesModel(){
        eyeModel = new EyeModel();
        Position pos_l = null;
        List<Position> posl_l = new ArrayList<Position>();
        for (int i = 0;i<EyeModel.eyeOfleftPoint.length;i++){
            try {
                JSONArray jsona = js.getJsonArray("result");
                JSONObject json = js.getJsonArray("result").getJSONObject(0).getJSONObject("landmark").getJSONObject(EyeModel.eyeOfleftPoint[i]);

                float x = (float)json.getDouble("x");
                float y = (float)json.getDouble("y");
                pos_l = new Position(x,y);
                posl_l.add(pos_l);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        eyeModel.setLeftPosition(posl_l);

        Position pos_r = null;
        List<Position> posl_r = new ArrayList<Position>();
        for (int i = 0;i<EyeModel.eyeOfleftPoint.length;i++){
            try {
                JSONArray jsona = js.getJsonArray("result");
                JSONObject json = js.getJsonArray("result").getJSONObject(0).getJSONObject("landmark").getJSONObject(EyeModel.eyeOfRightPoint[i]);

                float x = (float)json.getDouble("x");
                float y = (float)json.getDouble("y");
                pos_r = new Position(x,y);
                posl_r.add(pos_r);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        eyeModel.setRightPosition(posl_r);
        return eyeModel;
    }

    public MouthModel getMouthModel(){
        Position pos = null;
        List<Position> posl = new ArrayList<Position>();
        for (int i = 0;i<MouthModel.mouthPoint.length;i++){
            try {
                //System.out.println("result json:"+js.getJsonArray("result").getJSONObject(0));
                JSONArray jsona = js.getJsonArray("result");
                JSONObject json = js.getJsonArray("result").getJSONObject(0).getJSONObject("landmark").getJSONObject(MouthModel.mouthPoint[i]);
                float x = (float)json.getDouble("x");
                float y = (float)json.getDouble("y");
                pos = new Position(x,y);
                posl.add(pos);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        mouthModel = new MouthModel(posl);
        return mouthModel;
    }
    public NoseModel getNoseModel(){
        Position pos = null;
        List<Position> posl = new ArrayList<Position>();
        for (int i = 0;i<NoseModel.nosePoint.length;i++){
            try {
                //System.out.println("result json:"+js.getJsonArray("result").getJSONObject(0));
                JSONArray jsona = js.getJsonArray("result");
                JSONObject json = js.getJsonArray("result").getJSONObject(0).getJSONObject("landmark").getJSONObject(NoseModel.nosePoint[i]);

                float x = (float)json.getDouble("x");
                float y = (float)json.getDouble("y");
                pos = new Position(x,y);
                posl.add(pos);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        noseModel = new NoseModel(posl);
        return  noseModel;
    }

    public FeatureModel getFeatureModel(){
        Position pos = null;
        List<Position> posl = new ArrayList<Position>();
        for (int i = 0;i<FeatureModel.featurePoint.length;i++){
            try {
                JSONArray jsona = js.getJsonArray("result");
                JSONObject json = js.getJsonArray("result").getJSONObject(0).getJSONObject("landmark").getJSONObject(FeatureModel.featurePoint[i]);
                float x = (float)json.getDouble("x");
                float y = (float)json.getDouble("y");
                pos = new Position(x,y);
                posl.add(pos);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        featureModel = new FeatureModel(posl);
        return  featureModel;
    }

    public String getFacialInfoStr() {
        return facialInfoStr;
    }
}
