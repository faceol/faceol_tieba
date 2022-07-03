package top.faceol.faceol_tieba.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class redisConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate RedisTemplate = new RedisTemplate();
        FastJson2JsonRedisSerializer<Object> jsonRedisSerializer = new FastJson2JsonRedisSerializer<>(Object.class);
        RedisTemplate.setConnectionFactory(redisConnectionFactory);
        RedisTemplate.setKeySerializer(jsonRedisSerializer);
        RedisTemplate.setValueSerializer(jsonRedisSerializer);

        RedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        RedisTemplate.setHashValueSerializer(new StringRedisSerializer());
        return RedisTemplate;
    }
}