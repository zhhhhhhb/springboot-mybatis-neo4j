package com.zhbo.study.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* <p>Title: ExcelVOAttribute</p>
* <p>Description: </p>
* <p>Company: 大麦物联科技有限公司</p> 
* @author xuli
* @date 2017年12月25日
*/
@Retention(RetentionPolicy.RUNTIME)  
@Target( { java.lang.annotation.ElementType.FIELD }) 
public @interface ExcelVOAttribute {
	/** 
     * 瀵煎嚭鍒癊xcel涓殑鍚嶅瓧. 
     */  
    public abstract String name();  
  
    /** 
     * 閰嶇疆鍒楃殑鍚嶇О,瀵瑰簲A,B,C,D.... 
     */  
    public abstract String column();  
  
    /** 
     * 鎻愮ず淇℃伅 
     */  
    public abstract String prompt() default "";  
  
    /** 
     * 璁剧疆鍙兘閫夋嫨涓嶈兘杈撳叆鐨勫垪鍐呭. 
     */  
    public abstract String[] combo() default {};  
  
    /** 
     * 鏄惁瀵煎嚭鏁版嵁,搴斿闇?姹?:鏈夋椂鎴戜滑闇?瑕佸鍑轰竴浠芥ā鏉?,杩欐槸鏍囬闇?瑕佷絾鍐呭闇?瑕佺敤鎴锋墜宸ュ～鍐?. 
     */  
    public abstract boolean isExport() default true;  
}
