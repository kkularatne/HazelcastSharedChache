package research.and.development.hazelcastSharedCache.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import research.and.development.hazelcastSharedCache.config.HazelcastCacheConfig;
import research.and.development.hazelcastSharedCache.domain.Quote;


/**
 * Created by kkularatne on 18/08/2017.
 */
@Service
public class RestClientService {
    private static Logger log = LoggerFactory.getLogger(RestClientService.class);

    @Cacheable(value = HazelcastCacheConfig.CACHE_NAME, keyGenerator = HazelcastCacheConfig.KEY_GENERATOR)
    public Quote callAPI() {
        log.info("calling /api/random");
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote;
    }

}
