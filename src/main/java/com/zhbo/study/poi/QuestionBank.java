package com.zhbo.study.poi;

import com.zhbo.study.utils.ExcelVOAttribute;
import lombok.Data;

/**
 * @author zhengbo
 * @date 2021/4/13 10:11
 */
public class QuestionBank {

    @ExcelVOAttribute(name = "问题名称", column = "A")
    private String questionName;


    @ExcelVOAttribute(name = "问题答案", column = "B")
    private String answer;


    @ExcelVOAttribute(name = "一级问题分类", column = "C")
    private String level1Problem;


    @ExcelVOAttribute(name = "二级问题分类", column = "D")
    private String level2Problem;


    @ExcelVOAttribute(name = "三级问题分类", column = "E")
    private String level3Problem;


    @ExcelVOAttribute(name = "四级问题分类", column = "F")
    private String level4Problem;


    @ExcelVOAttribute(name = "相似问法", column = "G")
    private String similarityQuestions;

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLevel1Problem() {
        return level1Problem;
    }

    public void setLevel1Problem(String level1Problem) {
        this.level1Problem = level1Problem;
    }

    public String getLevel2Problem() {
        return level2Problem;
    }

    public void setLevel2Problem(String level2Problem) {
        this.level2Problem = level2Problem;
    }

    public String getLevel3Problem() {
        return level3Problem;
    }

    public void setLevel3Problem(String level3Problem) {
        this.level3Problem = level3Problem;
    }

    public String getLevel4Problem() {
        return level4Problem;
    }

    public void setLevel4Problem(String level4Problem) {
        this.level4Problem = level4Problem;
    }

    public String getSimilarityQuestions() {
        return similarityQuestions;
    }

    public void setSimilarityQuestions(String similarityQuestions) {
        this.similarityQuestions = similarityQuestions;
    }
}
