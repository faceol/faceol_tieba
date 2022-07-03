package top.faceol.faceol_tieba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@MapperScan("top/faceol/faceol_tieba/dao")
@EnableCaching
public class FaceolTiebaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceolTiebaApplication.class, args);
    }

}
