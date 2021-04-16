package mm.base.common;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取config.properties配置文件
 */
public class Config {
    private static Properties props = new Properties();
    static{
        try{
            System.out.println("开始读取配置文件:" + Config.class.getResource("/"));
            InputStream in = Config.class.getResourceAsStream("/config.properties");
            props.load(new InputStreamReader(in,"gb2312"));
            in.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static void main(String[] args){
        System.out.println(Config.get("sms.sign"));
    }
}
