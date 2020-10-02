/**
 * @author: liujian@hvgroup.com
 * @date: 2020/9/9 0:12
 */
public class ThreadTest extends Thread {

    public void run() {
        System.out.println(getName() + "正在执行！");
    }
}
