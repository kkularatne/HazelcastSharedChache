package research.and.development.hazelcastSharedCache.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import research.and.development.hazelcastSharedCache.config.HazelcastCacheConfig;
import research.and.development.hazelcastSharedCache.domain.Quote;

/**
 * Created by kkularatne on 18/08/2017.
 */
@Service
public class CacheService {

    @Autowired
    private RestClientService restClientService;
    private static Logger log = LoggerFactory.getLogger(CacheService.class);


    public Quote getSpringBootQuote() {
        log.info("getSpringBootQuote called.");
        long startTime = System.nanoTime();
        Quote quote = restClientService.callAPI();
        long endTime = System.nanoTime();
        log.info("Took: {} mills", (endTime - startTime) / 1000000);
        return quote;
    }

    @CacheEvict(value = HazelcastCacheConfig.CACHE_NAME, allEntries = true)
    public void clearCache() {
        log.info("cache evicted successfully.");
    }
}
