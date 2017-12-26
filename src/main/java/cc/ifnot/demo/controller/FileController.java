package cc.ifnot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("xxx") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }

//        获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为: " + fileName);
//        获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf('.'));
        logger.info("上传文件的后缀名: " + suffixName);
//        null
        fileName = UUID.randomUUID() + "-" + fileName + suffixName;

//        定义文件上传路径
        String filePath = "d:/uploads/";

        File dest = new File(filePath + fileName);

//        检查文件是否存在
        if (!dest.getParentFile().exists()) {
            //ResultOfMethodCallIgnored
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "上传失败";
    }

}
