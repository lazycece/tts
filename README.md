# Text to Speech 


## Description

This project is a tool, that converts text content into voice files in wav format. First, use the offline transfer technology of IFLYTEK to transfer the text into a pcm file, and then use the algorithm to convert the pcm file into a wav format voice file.


## How to use ?

A example as follow:

```
String content = "今天你吃饭了吗";
String fileName = "今天你吃饭了吗";
String parentPath = "F:\\lazycece\\tts";
TextToSpeech textToSpeech = new TextToSpeech("5a5727bc");
textToSpeech.tts(parentPath, content, fileName);
```

Now, let's do some description for these parameters.

* content:  
the content text
* fileName:  
the file name after been converted
* parentPath:   
the parent path of files have been converted, follows:  
${parentPath}/pcm/${fileName}.pcm  
${parentPath}/pcm/${fileName}.wav



