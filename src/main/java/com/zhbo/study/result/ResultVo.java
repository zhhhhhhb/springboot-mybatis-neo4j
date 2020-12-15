package com.zhbo.study.result;

/**
 * @author zhengbo
 * @date 2020/10/15 14:10
 */
public class ResultVo {

    private String msg;

    private String retCode;

    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultVo(String msg, String retCode, Object data) {
        this.msg = msg;
        this.retCode = retCode;
        this.data = data;
    }

    public ResultVo success(Object data) {
        return new ResultVo("success", "200", data);
    }

    public ResultVo success() {
        return new ResultVo("success", "200", "");
    }

    public ResultVo fail() {
        return new ResultVo("fail", "400", "");
    }

    public ResultVo fail(Object data) {
        return new ResultVo("fail", "400", data);
    }
}
