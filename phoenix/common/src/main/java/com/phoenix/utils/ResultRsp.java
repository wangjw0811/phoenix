package com.phoenix.utils;

/**
 * @author Jims Wang
 * @date 2019-06-29 09:16
 */
public class ResultRsp<T> {
    private static final int SUCCESS_CODE = 200;

    private static final int FAILED_CODE = 500;

    private static final String SUCCESS_MSG = "请求成功";

    private static final String FAILED_MSG = "请求失败";

    private static final String RESULT_IS_NULL = "暂无数据";

    private int resultCode;

    private String resultMsg;

    private Object resultData;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public ResultRsp(int resultCode, String resultMsg, Object resultData) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

    public static<T> ResultRsp<T> success(){
        return success(null);
    }

    public static<T> ResultRsp<T> success(Object resultData){
        if(null == resultData){
            resultData = RESULT_IS_NULL;
        }
        return success(ResultRsp.SUCCESS_CODE, resultData);
    }

    public static<T> ResultRsp<T> success(int resultCode, Object resultData){
        return success(resultCode, ResultRsp.SUCCESS_MSG, resultData);
    }

    public static<T> ResultRsp<T> success(int resultCode, String resultMsg, Object resultData){
        return new ResultRsp(resultCode, resultMsg, resultData);
    }


    public static<T> ResultRsp<T> failed(){
        return failed(ResultRsp.FAILED_CODE);
    }

    public static<T> ResultRsp<T> failed(int resultCode){
        return failed(resultCode, null);
    }

    public static<T> ResultRsp<T> failed(int resultCode, Object resultData){
        return failed(resultCode, ResultRsp.FAILED_MSG, resultData);
    }

    public static<T> ResultRsp<T> failed(int resultCode, String resultMsg, Object resultData){
        return new ResultRsp(resultCode, resultMsg, resultData);
    }
}
