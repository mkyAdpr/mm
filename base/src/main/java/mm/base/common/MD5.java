package mm.base.common;
import java.security.MessageDigest;

public class MD5 {

    /**
     * MD5加密
     * @param bytes
     * @return MD5加密后的字符串
     */
    public static String encrypt(byte[] bytes)
    {
        try
        {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(bytes);
            byte[] byteArray = m.digest();
            StringBuffer md5StrBuff = new StringBuffer();
            for (int i = 0; i < byteArray.length; i++) {
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
                }
                else {
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                }
            }
            return md5StrBuff.toString();
        }
        catch(Exception e) {
            throw new RuntimeException("");
        }
    }

    /**
     * 对字符串进行MD5加密
     * @param str
     * @return MD5加密后的字符串
     */
    public static String encrypt(String str){
        try {
            return encrypt(str.getBytes("utf-8"));
        }
        catch(Exception e) {
            throw new RuntimeException("");
        }
    }
}
