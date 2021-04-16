package mm.base.common;

import net.rubyeye.xmemcached.MemcachedClient;

public class Cache {

    private static MemcachedClient client = SpringContextUtil.get(MemcachedClient.class);

    /**
     * 添加键值对缓存
     * @param key 键
     * @param value 值
     * @param exp 过期时间，单位：秒
     */
    public static void set(String key,Object value,int exp) {
        try {
            boolean bool= client.set(key,exp,value);
            System.out.println(String.format("cache %s=%s exp=%s result=%s",key,value,exp,bool));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("缓存异常",e);
        }
    }

    /**
     * 删除缓存
     * @param key 键
     */
    public static void del(String key) {
        try {
            boolean bool = client.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("缓存异常",e);
        }
    }

    public static <T> T get(String key){
        try {
            return (T)client.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("缓存异常",e);
        }
    }
}
