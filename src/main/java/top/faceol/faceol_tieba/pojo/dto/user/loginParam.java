package top.faceol.faceol_tieba.pojo.dto.user;

public class loginParam {
    private String loginData;
    private String password;

    public loginParam(String loginData, String password) {
        this.loginData = loginData;
        this.password = password;
    }

    public String getLoginData() {
        return loginData;
    }

    public void setLoginData(String loginData) {
        this.loginData = loginData;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
