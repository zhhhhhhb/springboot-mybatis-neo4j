package com.zhbo.study.controller;

import com.zhbo.study.poi.QuestionBank;
import com.zhbo.study.result.ResultVo;
import com.zhbo.study.utils.ExcelUtil;
import com.zhbo.study.utils.Html2Text;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author zhengbo
 * @date 2021/4/13 10:16
 */

@RestController
@RequestMapping("/answer")
@Slf4j
public class AnswerController extends BaseController {

    @PostMapping(value = "/html2Text")
    public void importPerson(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        InputStream fis;
        try {
            fis = file.getInputStream();
            // 创建excel工具类
            ExcelUtil<QuestionBank> util = new ExcelUtil<>(QuestionBank.class);
            // 导入
            List<QuestionBank> list = util.importExcel2007("问题库", fis);
            list.forEach(questionBank -> {
                String answer = questionBank.getAnswer();
                answer = Html2Text.getContent(answer);
                questionBank.setAnswer(answer);
            });

            String fileName = "问题库";
            //设置Content-Disposition
            OutputStream fos = response.getOutputStream();
            //设置Content-Disposition
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");

            util.exportExcel2007(list, "问题库", fos);
            fos.close();
        } catch (Exception e) {
            log.error("报错:",e);
        }
    }
}
