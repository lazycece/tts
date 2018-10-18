# Text to Speech 


## Description

This project is a tool, that converts text content into voice files in wav format. First, use the offline speech synthesis technology of IFLYTEK to transfer the text into a pcm file, and then use the algorithm to convert the pcm file into a wav format voice file.


## How to use ?

First, you should apply a APPID from IFLYTEK's open-platform, and then to coding. 
 
A example as follow:

```
String content = "hello, boy";
String fileName = "hello , boy";
String parentPath = "/home/lazycece/tts";
TextToSpeech textToSpeech = new TextToSpeech("appid");
textToSpeech.tts(parentPath, content, fileName);
```

Now, let's do some description for these parameters.

* content:  
the content text
* fileName:  
the file name after been converted
* parentPath:   
the parent path of files have been converted, follows:  
/home/lazycece/tts/pcm/hello, boy.pcm  
/home/lazycece/tts/video/hello, boy.wav



