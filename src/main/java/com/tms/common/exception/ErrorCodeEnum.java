package com.tms.common.exception;

/**
 * Created by xiongzhanyuan on 2017/2/16.
 */
public enum ErrorCodeEnum {
    //通用
    SYSTEM_ERROR("100001","系统异常"),
    PARAMETERFORMATERROR("20001", "参数格式错误!"),
    PARAMETERMISSING("20002", "参数值缺失！"),
    ACCOUNTNOTEXIST("20003", "账号不存在"),
    ERRORPASSWORD("20004", "密码错误! "),
    PASSWORDNOTSAME("20005", "密码不一致! "),
    PARAMETERMISSINGByMultiDown("20006", "请选择要下线的条目！"),
    CANNOTDELETESCENIC("20007", "该景观区包含子景点，不能删除！"),
    ENDTIMEBEFORESTARTTIME("20008", "结束时间不能早于开始时间！");

    private String resultCode;
    private String resultMsg;

    private ErrorCodeEnum() {
    }

    private ErrorCodeEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }


    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public static String getValues(String resultCode){
        for(ErrorCodeEnum chronicEnum:ErrorCodeEnum.values()){
            if(chronicEnum.resultCode==resultCode){
                return chronicEnum.resultMsg;
            }
        }
        return null;
    }

    public static ErrorCodeEnum getEnumByCode(String resultCode){
        for(ErrorCodeEnum chronicEnum:ErrorCodeEnum.values()){
            if(chronicEnum.getResultCode().equals(resultCode)){
                return chronicEnum;
            }
        }
        return null;
    }

    public static ErrorCodeEnum getEnumByMsg(String resultMsg){
        for(ErrorCodeEnum chronicEnum:ErrorCodeEnum.values()){
            if(chronicEnum.getResultMsg().equals(resultMsg)){
                return chronicEnum;
            }
        }
        return null;
    }
    
}
