package com.zeroten.javaless.collection;
import java.util.*;

public class QueueTest {
    // 队列Queue
        // 队列指的是一种在队尾插入元素、在队头删除元素 FIFO(先进先出)
        // 两端队列：可以在队尾/队头同时进行插入或删除
        // 队列的特点：只能对队头或队尾元素进行操作，而不能对队列中间的元素进行操作
        // 先进后出：栈
        // 队列的两个接口：Queue、Deque
        // 队列的实现类：1.LinkedList 具有队列、两端队列的功能，内部使用链表来实现
                    // 2.ArrayDeque 具有队列、两端队列的功能，内部使用循环数组来实现
                    // 3.PriorityQueue 优先级队列，它内部实现结构可以快速把所有元素中最小的元素单独放出来
                        // 最典型的应用场景：任务调度
    // 两个应用场景：任务调度、LRU
    // 两个工具:Arrays、 Collections
    public static void main(String[] args) {
        testQueue();
        testDeque();

        // 优先级队列：任务调度
        // 特点：内部使用了一种堆的数据结构，是一种自我调整的二叉树
                // 当删除/添加元素的时候，他能快速的找到队列中最小的元素
                // 并且移动到树的根部，而不用对所用元素进行排序
                // 对优先级进行遍历的时候，无序的
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("1");
        pq.add("3");
        pq.add("5");
        pq.add("7");
        pq.add("2");
        pq.add("4");
        pq.add("8");
        pq.add("6");
        System.out.println(pq);
        // 数组或者实现了Iterable接口的类可以用于for each 语法
        for (String str : pq) {
            System.out.println(">" + str);
        }
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());

        // 优先级队列如何找最小元素：构建时指定 Comparator，
        // 或者存放元素实现Comparable接口
        PriorityQueue<Task> taskList = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.priority < o2.priority) {
                    return -1;
                } else if (o1.priority == o2.priority) {
                    return 0;
                }
                return 1;
            }
        });

        for (int i = 0; i < 10; i++) {
            int priority = new Random().nextInt(10);
            taskList.add(new Task(priority, "任务：" + (i+1)));
        }
        System.out.println(taskList);
        //执行任务
        while (true) {
            if (taskList.isEmpty()) {
                System.out.println("任务执行完，退出");
                break;
            }
            Task task = taskList.remove();
            System.out.println(String.format("执行任务：%s,优先级：%d", task.name, task.priority));
        }


    }

    static class Task {
        private int priority;
        private String name;

        public Task(int priority, String name) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "priority=" + priority +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static void testQueue() {
        // 队列
        // Queue 借口的方法
        Queue<String> queue = new LinkedList();
        // 增删查改
        // add/offer
        // 在队列未满的情况下,添加元素到队列的尾部、
        // 如果队列已满：add 抛异常 IllegalStateException， offer  返回false
        queue.add("str1");
        queue.add("str2");
        queue.offer("str3");
        queue.offer("str4");

        //删
        // remove/poll
        // 如果队列不为空，删除并返回队头的元素
        // 如果队列为空：remove 抛出异常 NoSuchElementException  poll 返回 null
        // 如果使用remove来获取队尾元素时，remove前需要判断队列是否为空
        // size() isEmpty()
        // 如果使用 poll 来获取队尾元素时，获取到结果后，先判断是否为null
        System.out.println("remove:" + queue.remove());
        System.out.println("remove:" + queue.remove());
        System.out.println("remove:" + queue.remove());
        System.out.println("remove:" + queue.remove());
        System.out.println(queue);
        System.out.println(queue.isEmpty() + "===" + queue.size());
        System.out.println("poll:" + queue.poll());

        // 查
        // element/peek
        // 如果队列不为空，返回队列的头部元素，但不删除
        // 队列为空时：element 抛出异常 NoSuchElementException peek 返回 null
        queue.add("str5");
        queue.add("str6");
        queue.offer("str7");
        queue.offer("str8");
        System.out.println(queue);
        queue.clear();
        System.out.println("队头元素peek()=" + queue.peek());
//        System.out.println("队头元素element（）=" + queue.element());

        // 改 一般没有修改操作
    }

    private static void testDeque() {
        // 两端队列 Deque：增删改查
        Deque<String> deque = new LinkedList();

        //增：（queue: add/offer）
            // addFirst/addLast/offerFirst/offerLast
        deque.addFirst("str1");
        deque.addLast("str3");
        deque.addFirst("str2");
        deque.addFirst("str4");
        System.out.println(deque);
        //删： （queue: remove/poll)
            // removeFirst/removeLast/pollFirst/pollLast
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque);
        //查： （queue: element/peek）
            // getFirst/getLast/peekFirst/peekLast
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        System.out.println(deque);
    }

}
