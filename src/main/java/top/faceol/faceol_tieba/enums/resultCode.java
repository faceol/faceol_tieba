package top.faceol.faceol_tieba.enums;

public enum resultCode {

    REGISTER(200,"注册成功"),
    LONGIN(200,"已登录"),
    LOGOUT(4000,"登录退出"),
    UPDATE_ERROR(4001,"更新失败"),
    SELECT_ERROR(4002,"查询失败"),
    INSERT_ERROR(4003,"插入失败"),
    UPDATE(6000,"更新成功"),
    SELECT(6001,"查询成功"),
    INSERT(6002,"插入成功"),
    PARAMS_ERROR(10001,"参数有误"),
    ACCOUNT_PWD_NOT_EXIST(10002,"用户名或密码不存在"),
    TOKEN_ERROR(10003,"token不合法"),
    ACCOUNT_EXIST(10004,"账号已存在"),
    NO_PERMISSION(70001,"无访问权限"),
    SESSION_TIME_OUT(90001,"会话超时"),
    NO_LOGIN(90002,"未登录"),;

    private int code;
    private String msg;

    resultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}