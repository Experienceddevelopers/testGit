import java.util.concurrent.Callable;

/**
 * @author: liujian@hvgroup.com
 * @date: 2020/9/9 0:20
 */
public class CallTest implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "SUCCESS!";
    }
}
