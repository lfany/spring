package cc.ifnot.demo.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartFile

import java.io.File
import java.io.IOException
import java.util.UUID

@Controller
@RequestMapping("/file")
class FileController {

    @RequestMapping("upload")
    @ResponseBody
    fun upload(@RequestParam("xxx") file: MultipartFile): String {
        if (file.isEmpty) {
            return "文件为空"
        }

        //        获取文件名
        var fileName = file.originalFilename
        logger.info("上传的文件名为: $fileName")
        //        获取文件的后缀名
        val suffixName = fileName.substring(fileName.lastIndexOf('.'))
        logger.info("上传文件的后缀名: $suffixName")
        //        null
        fileName = UUID.randomUUID().toString() + "-" + fileName + suffixName

        //        定义文件上传路径
        val filePath = "d:/uploads/"

        val dest = File(filePath + fileName)

        //        检查文件是否存在
        if (!dest.parentFile.exists()) {
            //ResultOfMethodCallIgnored
            dest.parentFile.mkdirs()
        }

        try {
            file.transferTo(dest)
            return "上传成功"
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return "上传失败"
    }

    companion object {

        private val logger = LoggerFactory.getLogger(FileController::class.java)
    }

}
