package cn.cyzone.redis;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRedisService {
    Logger logger = LoggerFactory.getLogger(TestRedisService.class);
    RedisService rs = new RedisService();

    @Test
    public void testSadd(){
        boolean flag = rs.sadd("crawel","counter");
        logger.debug(""+flag);
    }
}
