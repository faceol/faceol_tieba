package top.faceol.faceol_tieba.util;

import top.faceol.faceol_tieba.pojo.po.user;

public class userThreadLocal {
    private userThreadLocal(){}

    private static final ThreadLocal<user> LOCAL = new ThreadLocal<>();

    public static void put(user sysUser){
        LOCAL.set(sysUser);
    }
    public static user get(){
        return LOCAL.get();
    }
    public static void remove(){
        LOCAL.remove();
    }
}
