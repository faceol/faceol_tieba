package top.faceol.faceol_tieba.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import top.faceol.faceol_tieba.enums.resultCode;
import top.faceol.faceol_tieba.pojo.dto.Result;
import top.faceol.faceol_tieba.pojo.dto.user.loginParam;
import top.faceol.faceol_tieba.pojo.dto.user.registerParam;
import top.faceol.faceol_tieba.pojo.po.user;
import top.faceol.faceol_tieba.service.impl.userServiceImpl;
import top.faceol.faceol_tieba.util.jwtUtil;
import top.faceol.faceol_tieba.util.userThreadLocal;

@RestController
@RequestMapping("user")
public class userController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private userServiceImpl userService;

    @PostMapping("/login")
    public Result login(@RequestBody loginParam loginParam){
        LambdaQueryWrapper<user> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(user::getUsername,loginParam.getLoginData())
                .eq(user::getPassword,loginParam.getPassword())
                .last("limit 1");
        user user = userService.getOne(userLambdaQueryWrapper);
        if (user!=null){
            System.out.println("55555555555"+user);
            System.out.println();
            redisTemplate.opsForValue().set(user.getId(),user);
            String token = jwtUtil.createToken(user);
            return Result.success(resultCode.LONGIN.getCode(),token,resultCode.LONGIN.getMsg());
        }else {
            return Result.fail(resultCode.PARAMS_ERROR.getCode(),null,resultCode.PARAMS_ERROR.getMsg());
        }
    }
    @GetMapping("/userData")
    public Result userData(){
        user user = userThreadLocal.get();
        System.out.println("userdata++++"+user.toString());
        if (user!=null)
            return Result.success(resultCode.SELECT, user);
        else
            return Result.fail(resultCode.SELECT_ERROR,null);
    }
    @GetMapping("/showData/{id}")
    public Result showData(@PathVariable("id") int id){
        LambdaQueryWrapper<user> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(user::getId,id);
        user one = userService.getOne(userLambdaQueryWrapper);
        one.setPassword(null);
        one.setPhone(null);
        one.setEmail(null);
        if (one!=null)
            return Result.success(resultCode.SELECT, one);
        else
            return Result.fail(resultCode.SELECT_ERROR,null);
    }

    @PostMapping("/register")
    public Result register(@RequestBody registerParam registerParam){
        LambdaQueryWrapper<user> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(user::getUsername,registerParam.getUsername())
                    .last("limit 1");
        user isAlive = userService.getOne(userLambdaQueryWrapper);
        if (isAlive!=null){
            return Result.fail(resultCode.ACCOUNT_EXIST.getCode(),null,resultCode.ACCOUNT_EXIST.getMsg());
        }
        user user = new user();
        BeanUtils.copyProperties(registerParam,user);
        user.setNickname(user.getUsername());
        if (userService.save(user)){
            System.out.println("========注册成功");
            return Result.success(resultCode.REGISTER.getCode(),null,resultCode.REGISTER.getMsg());
        }else {
            return Result.fail(resultCode.PARAMS_ERROR.getCode(),null,resultCode.PARAMS_ERROR.getMsg());
        }
    }

    @PostMapping("/nickNameUpdate")
    public Result updateNickName(@RequestBody String nickName){
        user user = userThreadLocal.get();
        LambdaUpdateWrapper<user> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        userLambdaUpdateWrapper.eq(top.faceol.faceol_tieba.pojo.po.user::getId,user.getId())
                .set(top.faceol.faceol_tieba.pojo.po.user::getNickname,user.getNickname());
        boolean update = userService.update(userLambdaUpdateWrapper);
        if (update){
            return Result.success(resultCode.UPDATE.getCode(), null,resultCode.UPDATE.getMsg());
        }else {
            return Result.fail(resultCode.PARAMS_ERROR.getCode(), null,resultCode.PARAMS_ERROR.getMsg());
        }
    }
    @PostMapping("/passwordUpdate")
    public Result updatePassword(@RequestBody String password){
        //user user = userThreadLocal.get();
        user user = new user();
        user.setId(1);
        user.setUsername("root");
        user.setEmail("123456");
        System.out.println("========"+password);
        LambdaUpdateWrapper<user> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        userLambdaUpdateWrapper.eq(top.faceol.faceol_tieba.pojo.po.user::getId,user.getId())
                .set(top.faceol.faceol_tieba.pojo.po.user::getPassword,password);
        boolean update = userService.update(user,userLambdaUpdateWrapper);
        if (update){
            return Result.success(resultCode.UPDATE.getCode(), null,resultCode.UPDATE.getMsg());
        }else {
            return Result.fail(resultCode.PARAMS_ERROR.getCode(), null,resultCode.PARAMS_ERROR.getMsg());
        }
    }
    @PostMapping("/emailUpdate")
    public Result updateEmail(@RequestBody String email){
        user user = userThreadLocal.get();
        LambdaUpdateWrapper<user> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        userLambdaUpdateWrapper.eq(top.faceol.faceol_tieba.pojo.po.user::getId,user.getId())
                .set(top.faceol.faceol_tieba.pojo.po.user::getEmail,user.getEmail());
        boolean update = userService.update(userLambdaUpdateWrapper);
        if (update){
            return Result.success(resultCode.UPDATE.getCode(), null,resultCode.UPDATE.getMsg());
        }else {
            return Result.fail(resultCode.PARAMS_ERROR.getCode(), null,resultCode.PARAMS_ERROR.getMsg());
        }
    }
    @PostMapping("/phoneUpdate")
    public Result updatePhone(@RequestBody String phone){
        user user = userThreadLocal.get();
        LambdaUpdateWrapper<user> userLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        userLambdaUpdateWrapper.eq(top.faceol.faceol_tieba.pojo.po.user::getId,user.getId())
                .set(top.faceol.faceol_tieba.pojo.po.user::getPhone,user.getPhone());
        boolean update = userService.update(userLambdaUpdateWrapper);
        if (update){
            return Result.success(resultCode.UPDATE.getCode(), null,resultCode.UPDATE.getMsg());
        }else {
            return Result.fail(resultCode.PARAMS_ERROR.getCode(), null,resultCode.PARAMS_ERROR.getMsg());
        }
    }

    @GetMapping("/logout")
    public Result logout(){

        return Result.success(resultCode.LOGOUT.getCode(),null,resultCode.LOGOUT.getMsg());
    }

}
