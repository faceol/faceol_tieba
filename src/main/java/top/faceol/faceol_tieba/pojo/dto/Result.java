package top.faceol.faceol_tieba.pojo.dto;

import top.faceol.faceol_tieba.enums.resultCode;

public class Result {



    private boolean success;
    private int status;
    private Object data;
    private String massage;

    public static Result success(int status,Object data,String massage){
        return new Result(true,status,data,massage);
    }
    public static Result fail(int status,Object data,String massage){
        return new Result(false,status,data,massage);
    }

    public static Result success(resultCode resultCode, Object data){
        return new Result(true,resultCode.getCode(),data,resultCode.getMsg());
    }
    public static Result fail(resultCode resultCode,Object data){
        return new Result(false,resultCode.getCode(),data,resultCode.getMsg());
    }
    private Result(boolean success, int status, Object data, String massage) {
        this.success = success;
        this.status = status;
        this.data = data;
        this.massage = massage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
