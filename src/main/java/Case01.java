import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class Case01 {

    private static ThreadLocal<Person> threadLocal = new ThreadLocal<Person>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executorService = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory());
//        try {
//            for (int i = 10; i > 0; i--) {
//                executorService.execute(new Task());
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            executorService.shutdown();
//        }
//        for (int i = 10; i > 0; i--) {
//            new ThreadTest().start();
//            executorService.execute(new ThreadTest());
//        }

//        FutureTask futureTask = new FutureTask(new CallTest());
//        for (int i = 10; i > 0; i--) {
//            System.out.println(Thread.currentThread().getName() + "" +i);
//            new Thread(futureTask).start();
//            System.out.println(futureTask.get() + "" + i);
//        }
//        new Thread(new Task(new Person(18, "张三"))).start();
//        new Thread(new Task(new Person(19, "李四"))).start();
//        Person person = new Person(20, "wangwu");
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (Person.class) {
//                    System.out.println(Thread.currentThread().getName() + "正在执行！");
//                    if (person.getAge() == 21) {
//
//                        person.setSex("王五你好!");
//
//                    } else {
//                        person.setSex("王五你好个锤子!!!!");
//                    }
//                    System.out.println(person);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (Person.class) {
//                    System.out.println(Thread.currentThread().getName() + "正在执行！");
//                    if (person.getAge() == 20) {
//                        person.setSex("王五!");
//                    } else {
//                        person.setSex("王五!!!!");
//                    }
//                    person.setAge(21);
//                    System.out.println(person);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        //假设多线程卖票
//        Ticket ticket = new Ticket(100, "lock");
//        new Thread(ticket, "车票口1").start();
//        new Thread(ticket, "车票口2").start();
//        new Thread(ticket, "车票口3").start();
//        new Thread(ticket, "车票口4").start();
//        executorService.execute(ticket);

//        synchronized (Person.class) {
//            if ()
//        }

//        int[] x = new int[25];
//        for (int i : x) {
//            System.out.println(i);
//        }

        Set<Short> s=new HashSet<Short>();
    for(Short i=0;i<100;i++){
    s.add(i);
    s.remove(i-1);
 }
 System.out.println(s.size());

    }

    public static Person show() {
        Person person = new Person(18, "张三");
        try {
            person.setSex("try");
            System.out.println("执行try");
            return person;
        } catch (Exception e) {

        } finally {
            System.out.println("执行finally");
            person.setSex("finally");
            person = null;
        }
        return null;
    }

    static class Task implements Runnable {
        private Person person;
        public Task(Person person) {

            this.person = person;
        }

        public void run() {
            if (threadLocal.get() == null) {

                threadLocal.set(person);
            }
            System.out.println(Thread.currentThread().getName() + "->" + threadLocal.get());
        }
    }
    static class Person {
        int age;
        String sex;

        public Person(int age, String sex) {
            this.age = age;
            this.sex = sex;
        }

        public Person() {
        }



        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "person{" +
                    "age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
}
