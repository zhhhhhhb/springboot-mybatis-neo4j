package com.zhbo.study.controller;

import com.zhbo.study.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基础Controller
 */
@Controller
@Slf4j
public class BaseController {

	/**
	 * 得到request对象
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public static HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	public static ResultVo writeToSuccess(Object object){
		ResultVo resultVo = new ResultVo();
		resultVo.setRetCode("1");
		resultVo.setMsg("success");
		resultVo.setData(object);
		log.info(resultVo.toString());
		return resultVo;
	}
	
	public static ResultVo writeToSuccess(){
		return writeToSuccess(null);
	}
	
	public static ResultVo writeToFail(Object object){
		HttpServletResponse response = getResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		
		ResultVo resultVo = new ResultVo();
		resultVo.setRetCode("0");
		resultVo.setMsg("fail");
		resultVo.setData(object);
		log.info(resultVo.toString());
		return resultVo;
	}
	
	public static ResultVo writeToFail(){
		HttpServletResponse response = getResponse();
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return writeToFail(null);
	}

}
