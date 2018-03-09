package www.dgl.com.androidfive;

/**
 * Created by dugaolong on 18/1/29.
 */

public class JniUtils {

    /**如果你的native方法报错，没关系，配置完成自然会编译通过
     * @return
     */
    public static native String getThreeDesKey();
    public static native String getSqlKey();

    static {
        System.loadLibrary("jni");
    }
}
