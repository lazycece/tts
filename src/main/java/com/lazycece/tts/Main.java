package com.lazycece.tts;

public class Main {

    public static void main(String[] args){
        String content = "hello , boy";
        String fileName = "hello , boy";
        String parentPath = "/home/lazycece/tts";
        TextToSpeech textToSpeech = new TextToSpeech("5a5727bc");
        textToSpeech.tts(parentPath, content, fileName);
    }
}
