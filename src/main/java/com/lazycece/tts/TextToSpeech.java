package com.lazycece.tts;

import com.iflytek.cloud.speech.*;

/**
 * 用于中文文本转标准普通话语音
 */
public class TextToSpeech {

    /**
     * 讯飞云平台在线语音合成项目APPID
     */
    private String appId;

    /**
     * 发音人(xiaoyan xiaoyu vixy --更多发音人请查看官方文档)
     */
    private String voiceName = "xiaoyan";

    /**
     * 语速 0~100
     */
    private String speed = "50";

    /**
     * 语调 0~100
     */
    private String pitch = "50";

    /**
     * 音量 0~100
     */
    private String volume = "50";

    public TextToSpeech(String appId) {
        this.appId = appId;
    }

    public TextToSpeech(String appId, String voiceName, String speed, String pitch, String volume) {
        this.appId = appId;
        this.voiceName = voiceName;
        this.speed = speed;
        this.pitch = pitch;
        this.volume = volume;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getVoiceName() {
        return voiceName;
    }

    public void setVoiceName(String voiceName) {
        this.voiceName = voiceName;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @param parent   文件保存的父目录
     * @param text     文本信息
     * @param fileName 所要保存的文件命名
     */
    public void tts(String parent, String text, String fileName) {
        //初始化
        SpeechUtility.createUtility(SpeechConstant.APPID + "=" + this.appId);
        //创建SpeechSynthesizer对象
        SpeechSynthesizer mTts = SpeechSynthesizer.createSynthesizer();
        //合成参数设置
        mTts.setParameter(SpeechConstant.VOICE_NAME, this.voiceName);
        mTts.setParameter(SpeechConstant.SPEED, this.speed);
        mTts.setParameter(SpeechConstant.PITCH, this.pitch);
        mTts.setParameter(SpeechConstant.VOLUME, this.volume);
        //开始合成
        String pcmPath = parent + "/pcm/" + fileName + ".pcm";
        String wavPath = parent + "/video/" + fileName + ".wav";
        TTSListener listener = new TTSListener(wavPath);
        mTts.synthesizeToUri(text, pcmPath, listener);
    }
}
