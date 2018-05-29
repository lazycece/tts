package com.cc.tts;

public class Main {

    public static void main(String[] args){
        String content = "今天你吃饭了吗";
        String fileName = "今天你吃饭了吗";
        String parentPath = "/home/lazycece/Documents/tts";
        TextToSpeech textToSpeech = new TextToSpeech("5a5727bc");
        textToSpeech.tts(parentPath, content, fileName);
    }
}
