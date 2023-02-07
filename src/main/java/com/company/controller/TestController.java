package com.company.controller;

import com.company.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class TestController {
    @Autowired
    private FileService fileService;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @RequestMapping(value = "/uploadTest", method = RequestMethod.GET)
    public String UploadTest(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model,
            HttpSession session
    ) throws Exception {

        return "test/uploadTest";
    }

    @RequestMapping(value = "/uploadTest2", method = RequestMethod.GET)
    public String UploadTest2(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model,
            HttpSession session
    ) throws Exception {

        return "test/uploadTest2";
    }


    @RequestMapping(value = "/register/action", method = RequestMethod.POST)
    public String fileUploadTest(
            MultipartHttpServletRequest mre, HttpServletRequest req
    )
    {
        String test = req.getParameter("test"); // jsp text name mapping
        MultipartFile mf = mre.getFile("file"); // jsp file name mapping
        String uploadPath = "";

//        String path = "D:\\"+"data\\"+"upload\\"; // 파일 업로드 경로
        String path = "D:/data/upload"; // 파일 업로드 경로

        String original = mf.getOriginalFilename(); // 업로드하는 파일 name

        System.out.println("!!!!!!!!!!"+test);        // text value
        System.out.println("!!!!!!!!!!"+original);    // file original name
        System.out.println("!!!!!!!!!!"+mf.getSize());// file size

        uploadPath = path + File.separator + original; // 파일 업로드 경로 + 파일 이름


        try {
            mf.transferTo(new File(uploadPath)); // 파일을 위에 지정 경로로 업로드
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "";

    }


    @RequestMapping(value = "/register/action2", method = RequestMethod.POST)
    public void fileUploadTest2(MultipartHttpServletRequest mre, HttpServletRequest req) {

        try {
            fileService.uploadFile(mre);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("#Exception Message : {}", e.getMessage());
            }
        }
    }

}
