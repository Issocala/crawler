package cn.cyzone.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolFactory {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6379;
    private static final int TIMEOUT = 10;
    private static final String PASSWORD = "123456";
    private static final int POOL_MAX_TOTAL = 1000;
    private static final int POOL_MAX_IDLE = 500;
    private static final int POOL_MAX_WAIT = 500;
    private RedisPoolFactory(){}
    static class GetRedisPool{
        static JedisPool jedisPool = null;
        static{
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            poolConfig.setMaxIdle(POOL_MAX_IDLE);
            poolConfig.setMaxTotal(POOL_MAX_TOTAL);
            poolConfig.setMaxWaitMillis((POOL_MAX_WAIT) * 1000);
            jedisPool = new JedisPool(poolConfig, HOST, PORT, TIMEOUT*1000, PASSWORD, 0);
        }
    }
    public static JedisPool getRedisPool(){
        return GetRedisPool.jedisPool;
    }
}
