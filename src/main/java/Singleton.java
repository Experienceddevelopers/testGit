/**
 * @author: liujian@hvgroup.com
 * @date: 2020/9/8 21:42
 */
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton () {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
