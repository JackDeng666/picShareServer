package edu.gq.bbpic.util;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageUtil {
    public static void generateThumbnail(File file, String toFilePath) throws IOException {

        /**
         * 指定大小进行缩放
         * 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变
         * 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         */
        Thumbnails.of(file)
                .size(600, 800)
                .toFile(toFilePath);
        /**
         * 按照比例进行缩放
         * scale(比例)
         * */
        /*Thumbnails.of(file)
                .scale(0.40f)
                .toFile(toFilePath);*/
        /**
         *  不按照比例，指定大小进行缩放
         *  keepAspectRatio(false) 默认是按照比例缩放的
         * */
        /*Thumbnails.of(filePath)
                .size(200, 200)
                .keepAspectRatio(false)
                .toFile(file.getAbsolutePath() + "_200x200.jpg");*/
        /**
         *  输出图片到流对象
         *
         * */
//        OutputStream os = new FileOutputStream(file.getAbsolutePath() + "_OutputStream.png");
//        Thumbnails.of(filePath)
//                .size(1280, 1024)
//                .toOutputStream(os);
        /**
         *  输出图片到BufferedImage
         * **/
//        BufferedImage thumbnail = Thumbnails.of(filePath)
//                .size(1280, 1024)
//                .asBufferedImage();
//        ImageIO.write(thumbnail, "jpg", new File(file.getAbsolutePath()+"_BufferedImage.jpg"));
    }
}
