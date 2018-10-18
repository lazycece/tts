package com.lazycece.tts.helper;

import java.io.*;

public class WavHeaderHelper {

    public static void addWavHeader(RandomAccessFile randomAccessWriter,
                                    int fileLength, int channel, int sample, int bits) throws Exception {
        // 计算长度
        // 填入参数，比特率等等。这里用的是16位单声道 8000 hz
        WavHeader header = new WavHeader();
        // 长度字段 = 内容的大小（PCMSize) + 头部字段的大小(不包括前面4字节的标识符RIFF以及fileLength本身的4字节)
        header.fileLength = fileLength + (44 - 8);
        header.FmtHdrLeth = 16;
        header.BitsPerSample = (short) bits;
        header.Channels = 1;
        header.FormatTag = 0x0001;
        header.SamplesPerSec = sample;
        header.BlockAlign = (short) (header.Channels * header.BitsPerSample / 8);
        header.AvgBytesPerSec = header.BlockAlign * header.SamplesPerSec;
        header.DataHdrLeth = fileLength;
        header.wirteHeader(randomAccessWriter);
    }

    public static void convertAudioFiles(String src, String target,
                                         int samplesPerSec, int bitsPerSample) throws Exception {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(target);

        // 计算长度
        byte[] buf = new byte[1024 * 4];
        int size = fis.read(buf);
        int PCMSize = 0;
        while (size != -1) {
            PCMSize += size;
            size = fis.read(buf);
        }
        fis.close();

        // 填入参数，比特率等等。这里用的是16位单声道 8000 hz
        WavHeader header = new WavHeader();
        // 长度字段 = 内容的大小（PCMSize) + 头部字段的大小(不包括前面4字节的标识符RIFF以及fileLength本身的4字节)
        header.fileLength = PCMSize + (44 - 8);
        header.FmtHdrLeth = 16;
        header.BitsPerSample = (short) bitsPerSample;
        header.Channels = 1;
        header.FormatTag = 0x0001;
        header.SamplesPerSec = samplesPerSec;
        header.BlockAlign = (short) (header.Channels * header.BitsPerSample / 8);
        header.AvgBytesPerSec = header.BlockAlign * header.SamplesPerSec;
        header.DataHdrLeth = PCMSize;

        byte[] h = header.getHeader();

        assert h.length == 44; // WAV标准，头部应该是44字节
        // write header
        fos.write(h, 0, h.length);
        // write data stream
        fis = new FileInputStream(src);
        size = fis.read(buf);
        while (size != -1) {
            fos.write(buf, 0, size);
            size = fis.read(buf);
        }
        fis.close();
        fos.close();
        System.out.println("Convert OK!");
    }


    public static void updateHeaderDataLength(RandomAccessFile randomAccessWriter, int total) throws IOException {
        randomAccessWriter.seek(4);
        randomAccessWriter.writeInt(Integer.valueOf(total + 36));
        randomAccessWriter.seek(44);
        randomAccessWriter.writeInt(Integer.valueOf(total));
    }

    public static void pcmToWav(String src, String destination, int samplesPerSec, int bitsPerSample) throws Exception {
        File file = new File(destination);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        convertAudioFiles(src, destination, samplesPerSec, bitsPerSample);
    }
}
