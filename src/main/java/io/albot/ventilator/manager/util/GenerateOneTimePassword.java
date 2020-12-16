package io.albot.ventilator.manager.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class GenerateOneTimePassword {
    private static final Logger logger = LoggerFactory.getLogger(GenerateOneTimePassword.class);

    private static final Integer EXPIRE_MIN = 5;
    private final LoadingCache<String, Integer> otpCache;

    public GenerateOneTimePassword() {
        super();
        otpCache = CacheBuilder.newBuilder()
                .expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String s) throws Exception {
                        return 1;
                    }
                });
    }

    public Integer generateOTP(String key) {
        Random random = new Random();
        int OTP = 100000 + random.nextInt(900000);
        otpCache.put(key, OTP);
        logger.info("Added OTP into cache, The Given User {}", key);
        return OTP;
    }

    public Integer getOTPByKey(String key) {
        try {
            logger.info("Get OTP from cache, The Given User {}", key);
            return otpCache.get(key);
        } catch (ExecutionException e) {
            return -1;
        }
    }

    public void clearOTPFromCache(String key) {
        logger.info("Invalidate The Given User {}", key);
        otpCache.invalidate(key);
    }
}
