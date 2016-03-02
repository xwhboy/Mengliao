package com.init.listener;

import com.init.domain.face_module.FaceModel;
import com.init.domain.face_module.FacialInfo;

/**
 * Created by zoson on 3/26/15.
 */
public interface FaceChangeListener {
    public void faceChange(FacialInfo faceInfo,FaceModel faceModel);
}
