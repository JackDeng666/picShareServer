package edu.gq.bbpic.util;

import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ImageUtil {

    static String fileUploadPath;
    static String fileBasicUrl;
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @Value("${fileUploadPath}")
    public void setFileUploadPath(String str){
        fileUploadPath = str;
    }

    @Value("${fileBasicUrl}")
    public void setFileBasicUrl(String str){
        fileBasicUrl = str;
    }

    public static ServerResponse saveImage(MultipartFile file){
        String today = sdf.format(new Date());

        String oPath = fileUploadPath + today + "original/";
        String tPath = fileUploadPath + today + "thumbnail/";

        String[] array1 = oPath.split("/");
        String[] array2 = tPath.split("/");
        oPath = "";
        tPath = "";
        for (int i = 0; i < array1.length; i++) {
            oPath += array1[i] + File.separator;
            tPath += array2[i] + File.separator;
        }
        // 原图文件夹
        File folderOp = new File(oPath);
        // 缩略图文件夹
        File folderTp = new File(tPath);
        if (!folderOp.isDirectory()) {
            folderOp.mkdirs();
        }
        if (!folderTp.isDirectory()) {
            folderTp.mkdirs();
        }

        Map map = new HashMap();

        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
        String originalName = newName + oldName.substring(oldName.lastIndexOf("."));
        String thumbnailName = newName + ".jpg";
        try {
            // 存储原图
            File originalFile = new File(folderOp, originalName);
            file.transferTo(originalFile);
            // 存储缩略图
            generateThumbnail(originalFile, tPath + thumbnailName);

            map.put("oUrl", "images/" + today + "original/" + originalName);
            map.put("tUrl", "images/"+ today + "thumbnail/" + thumbnailName);
        } catch (IOException e) {
            e.printStackTrace();
            return new ServerResponse(Const.ResCode.FAIL, "上传失败");
        }

        return new ServerResponse(Const.ResCode.SUCCEES, "上传成功", map);
    }

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
