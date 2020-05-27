import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.ResourceBundle;

public class JedisTest {
    private static Jedis jedis;
    private static JedisPool jedisPool;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jedispool");
        if (bundle == null) {
            System.out.println("jedis is not found");
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxTotal")));
        config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
        jedisPool = new JedisPool(config, bundle.getString("redis.ip"));
        jedis = jedisPool.getResource();
    }
    public static void main(String[] args) throws InterruptedException {
        /*Jedis jedis = new Jedis("192.168.1.36", 6379);
        System.out.println("success");
        System.out.println("服务正在运行" + jedis.ping());
        System.out.println(jedis.getClient());
        System.out.println(jedis.getDB());
        jedis.set("foo", "bar");
        jedis.set("foo1", "bar1");
        jedis.lpush("list", "run", "list", "hell");
        List<String > list = jedis.lrange("list", 0, -1);
        list.forEach(System.out::println);
        System.out.println(jedis);*/

        /*JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool pool = new JedisPool(config, "192.168.1.36");
        Jedis jedis = pool.getResource();
        String value = jedis.get("foo");
        System.out.println(value);
        jedis.close();

        Thread.sleep(1000000);*/

        System.out.println(jedis.get("foo"));


    }
}
