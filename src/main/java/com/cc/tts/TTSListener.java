package com.cc.tts;

import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SynthesizeToUriListener;

/**
 * Create by wangchao on 2018/1/12
 */
public class TTSListener implements SynthesizeToUriListener {

    /**
     * 音频文件保存路径
     */
    private String videoPath;

    private int samplesPerSec = 16000;

    private int bitsPerSample = 16;

    public TTSListener() {
    }

    public TTSListener(String videoPath) {
        this.videoPath = videoPath;
    }

    public TTSListener(String videoPath, int samplesPerSec, int bitsPerSample) {

        this.videoPath = videoPath;
        this.samplesPerSec = samplesPerSec;
        this.bitsPerSample = bitsPerSample;
    }

    public int getSamplesPerSec() {
        return samplesPerSec;
    }

    public void setSamplesPerSec(int samplesPerSec) {
        this.samplesPerSec = samplesPerSec;
    }

    public int getBitsPerSample() {
        return bitsPerSample;
    }

    public void setBitsPerSample(int bitsPerSample) {
        this.bitsPerSample = bitsPerSample;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    //progress为合成进度0~100
    @Override
    public void onBufferProgress(int i) {

    }

    //会话合成完成回调接口
    //uri为合成保存地址，error为错误信息，为null时表示合成会话成功
    @Override
    public void onSynthesizeCompleted(String uri, SpeechError speechError) {
        try {
            if (speechError == null) {
                WavHeaderHelper.pcmToWav(uri, this.videoPath, this.samplesPerSec, this.bitsPerSample);
                System.out.println("tts successful: " + videoPath);
            } else {
                System.out.println(speechError.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEvent(int i, int i1, int i2, int i3, Object o, Object o1) {

    }
}
