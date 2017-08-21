package research.and.development.hazelcastSharedCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import research.and.development.hazelcastSharedCache.domain.Quote;
import research.and.development.hazelcastSharedCache.services.CacheService;

@SpringBootApplication
@EnableCaching

public class HazelcastSharedCacheApplication implements CommandLineRunner {

    @Autowired
    private CacheService service;

    private static Logger log = LoggerFactory.getLogger(HazelcastSharedCacheApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HazelcastSharedCacheApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Quote quote = service.getSpringBootQuote();
        log.info(quote.getValue().getQuote());
        quote = service.getSpringBootQuote();
        log.info(quote.getValue().getQuote());

//        service.clearCache();
//
//        quote = service.getSpringBootQuote();
//        log.info(quote.getValue().getQuote());
//        quote = service.getSpringBootQuote();
//        log.info(quote.getValue().getQuote());
    }
}
