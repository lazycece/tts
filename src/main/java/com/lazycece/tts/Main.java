package com.lazycece.tts;

public class Main {

    public static void main(String[] args){
        String content = "今天你吃饭了吗";
        String fileName = "今天你吃饭了吗";
        String parentPath = "F:\\lazycece\\tts";
        TextToSpeech textToSpeech = new TextToSpeech("5a5727bc");
        textToSpeech.tts(parentPath, content, fileName);
    }
}
