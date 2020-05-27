import redis.clients.jedis.Jedis;
import redis.clients.jedis.ListPosition;

import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
    public String sayHello() {
        return "Hello World!";
    }

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("192.168.1.36");
        System.out.println(jedis.zadd("zdd-key", 10, "v1"));
        System.out.println(jedis.zadd("zdd-key", 15, "v2"));
        System.out.println(jedis.zscore("zdd-key", "v1"));
        System.out.println(jedis.zincrby("zdd-key", 10, "v1"));
        System.out.println(jedis.zscore("zdd-key", "v1"));
        System.out.println(jedis.zcard("zdd-key"));
        System.out.println(jedis.zcount("zdd-key", 0, 30));
        System.out.println(jedis.zrange("zdd-key", 0, 30));
        System.out.println(jedis.zrevrange("zdd-key", 0, 30));
        System.out.println(jedis.zrangeByScore("zdd-key", 0, 15));
        System.out.println(jedis.zrank("zdd-key", "v1"));
        System.out.println(jedis.zrank("zdd-key", "v2"));
        System.out.println(jedis.zrevrank("zdd-key", "v2"));
        System.out.println(jedis.zrem("zdd-key", "v2"));
        System.out.println(jedis.zcard("zdd-key"));
        System.out.println(jedis.zremrangeByRank("zdd-key", 0, 1));
        System.out.println(jedis.zrangeByLex("zdd-key", "-", "-"));
        System.out.println(jedis.zrange("zdd-key", 0, 1));
        System.out.println(jedis.zcard("zdd-key"));
















    }
}
