package top.faceol.faceol_tieba.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.faceol.faceol_tieba.pojo.po.user;
import top.faceol.faceol_tieba.util.jwtUtil;
import top.faceol.faceol_tieba.util.userThreadLocal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果该handle是资源访问handle则放行，默认去static目录查询

        System.out.println("进入拦截+++++++++++++++++");
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        String userToken = request.getHeader("token");
        if (userToken==null){
            return false;
        }
        Map<String, Object> map = jwtUtil.checkToken(userToken);
        Integer id = (Integer) map.get("id");
        if (map!=null){
            user myuser =(user) redisTemplate.opsForValue().get(id);
            userThreadLocal.put(myuser);
            return true;
        }else {
            System.out.println("请求被拦截-------------");
            return false;
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        userThreadLocal.remove();
    }
}
