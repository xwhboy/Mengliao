package com.init.service;

import android.content.Context;

import com.init.listener.VoiceRecoginzerFinishListener;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;

/**
 * Created by zoson on 4/18/15.
 */
public class Ml_VoiceRecognizer implements VoiceRecognizerListener {
    private VoiceRecognizer vr;
    private Context context;
    private String key = "248b63f1ceca9158ca88516bcb338e82a482ecd802cbca12";
    private Boolean isReco = true;
    private String content;
    private VoiceRecoginzerFinishListener lis;
    public Ml_VoiceRecognizer(Context context,VoiceRecoginzerFinishListener listener){
        vr = VoiceRecognizer.shareInstance();
        lis = listener;
        vr.setSilentTime(1000);
        vr.setListener(this);
        if (vr.init(context,key) == 0){
            isReco = true;
        }
    }
    public int startRecognizer(){
        if (!isReco)return -1;
        if (0 == vr.start()){
            return 0;
        }
        return -1;
    }
    public int stopRecognizer(){
        if (isReco){
            if (vr.stop() == 0){
                return 0;
            }
            return -1;
        }
        return -1;
    }
    @Override
    public void onGetResult(VoiceRecognizerResult voiceRecognizerResult) {
        content = "";
        if (voiceRecognizerResult != null&&voiceRecognizerResult.words != null){
            int wordSize = voiceRecognizerResult.words.size();
            StringBuilder results = new StringBuilder();
            for (int i = 0;i< wordSize;i++){
                VoiceRecognizerResult.Word word = (VoiceRecognizerResult.Word)voiceRecognizerResult.words.get(i);
                if (word != null&&word.text!=null){
                    results.append("\r\n");
                    results.append(word.text.replace("",""));
                }
            }
            results.append("\r\n");
            content = results.toString();
            lis.voiceRecognizerFinish(content);
        }
    }

    @Override
    public void onGetError(int i) {

    }

    @Override
    public void onVolumeChanged(int i) {

    }

    @Override
    public void onGetVoiceRecordState(VoiceRecordState voiceRecordState) {
        if (voiceRecordState == VoiceRecordState.Start){
            lis.voiceRecognizerStart();
        }else if (voiceRecordState == VoiceRecordState.Complete){
            
        }else if (voiceRecordState == VoiceRecordState.Canceled){
            lis.voiceRecognizerCancel();
        }
    }

}
