package cn.cyzone.redis;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.ArrayList;
import java.util.List;

public class RedisService {
    JedisPool jedisPool = RedisPoolFactory.getRedisPool();

    public <T> T get(String key,Class<T> clazz){
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            //生成真正的key
            String  str = jedis.get(key);
            T t =  stringToBean(str, clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }



    /**
     * 设置对象
     * */
    public <T> boolean set(String key,  T value) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            String str = beanToString(value);
            if(str == null || str.length() <= 0) {
                return false;
            }
            return jedis.set(key,str) == null ? false : true;
        }finally {
            returnToPool(jedis);
        }
    }

    public <T> boolean sadd(String key,String value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            long i = jedis.sadd(key,value);
            return i == 0 ? false : true;
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     * 检查key集合中是否有value
     * @param key
     * @param value
     * @return
     */
    public boolean sismember(String key,String value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            Boolean flag = jedis.sismember(key,value);
            return flag;
        }finally{
            returnToPool(jedis);
        }
    }


    public List<String> scanKeys(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            List<String> keys = new ArrayList<String>();
            String cursor = "0";
            ScanParams sp = new ScanParams();
            sp.match("*"+key+"*");
            sp.count(100);
            do{
                ScanResult<String> ret = jedis.scan(cursor, sp);
                List<String> result = ret.getResult();
                if(result!=null && result.size() > 0){
                    keys.addAll(result);
                }
                //再处理cursor
                cursor = ret.getCursor();
            }while(!cursor.equals("0"));
            return keys;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * String装换为对象
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
    private <T> T stringToBean(String str, Class<T> clazz) {
        if(str == null || str.length() <= 0 || clazz == null){
            return null;
        }
        if(clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(str);
        }else if(clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(str);
        }else if(clazz == String.class){
            return (T)str;
        }else {
            return JSON.toJavaObject(JSON.parseObject(str),clazz);
        }
    }

    /**
     * 对象转换为String
     * @param value
     * @param <T>
     * @return
     */
    private <T> String beanToString(T value) {
        Class<?> clazz = value.getClass();
        if(value == null) {
            return null;
        }else if(clazz == int.class || clazz == Integer.class){
            return ""+value;
        }else if(clazz == long.class || clazz == Long.class){
            return ""+value;
        }else if(clazz == String.class){
            return (String) value;
        }else{
            return JSON.toJSONString(value);
        }
    }

    private void returnToPool(Jedis jedis) {
        if(jedis != null){
            jedis.close();
        }
    }

}
