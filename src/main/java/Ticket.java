/**
 * @author: liujian@hvgroup.com
 * @date: 2020/9/9 1:03
 */
public class Ticket implements Runnable {

    private int num;
    private int init = 1;
    private String lock;

    public Ticket(int num,String lock){
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (init > num) {
                    System.out.println("已经卖完了");
                    return;
                }
                try {
//                    Thread.sleep(300);
                    lock.wait(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (init > num) {
                    System.out.println("已经卖完了");
                    return;
                }
                System.out.println(Thread.currentThread().getName() +"卖出第" + num-- + "张票");
            }
        }
    }
}
