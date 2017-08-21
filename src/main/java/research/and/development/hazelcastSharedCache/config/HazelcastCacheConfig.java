package research.and.development.hazelcastSharedCache.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * Created by kkularatne on 18/08/2017.
 */
@Configuration
public class HazelcastCacheConfig {

    public static final String CACHE_NAME = "spring-boot-quote";
    public static final String CACHE_KEY = "default-key";
    public static final String KEY_GENERATOR = "keyGenerator";
    @Bean
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        return new HazelcastCacheManager(hazelcastInstance());
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return CACHE_KEY;
            }
        };
    }



    @Bean
    public HazelcastInstance hazelcastInstance() {
        //return Hazelcast.newHazelcastInstance();
        return HazelcastClient.newHazelcastClient();
    }
}
