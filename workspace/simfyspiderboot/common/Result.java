package edu.cqjtu.zhang.simfyspiderboot.common;

import lombok.Data;

/**
 * @author Lewis
 */
@Data
public class Result {
    private boolean success;
    private String code;
    private String message;
    private Object data;

    public Result(){}
    public Result(boolean success){
        this.success = success;
        this.message = success?"执行成功":"执行失败";
        this.code = success?"0000":"0001";
    }
    public Result(boolean success, String code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    public Result(boolean success, String code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static Result success(){
        return success(null);
    }
    public static Result success(Object data) {
        return new Result(true,"0000","执行成功",data);
    }
    public static Result generalFail(){
        return fail("1000","未知错误");
    }
    public static Result fail(String code,String message){
        return new Result(false,code,message,null);
    }
}
