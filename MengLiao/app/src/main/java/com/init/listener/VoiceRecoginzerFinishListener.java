package com.init.listener;

/**
 * Created by zoson on 4/18/15.
 */
public interface VoiceRecoginzerFinishListener {
    public void voiceRecognizerFinish(String content);
    public void voiceRecognizerStart();
    public void voiceRecognizerCancel();
}
