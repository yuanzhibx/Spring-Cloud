package m1_simple;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 消费者
 *
 * @author Yuanzhibx
 * @Date 2020-08-05
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        // 连接
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.201.132");
        f.setUsername("admin");
        f.setPassword("admin");
        Channel c = f.newConnection().createChannel();

        //1. 定义队列
        c.queueDeclare("helloworld", false, false, false, null);

        //3. 回调对象
        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String s, Delivery delivery) throws IOException {
                byte[] body = delivery.getBody();
                String msg = new String(body);
                System.out.println("收到: " + msg);
            }
        };
        //4. 回调对象
        CancelCallback cancelCallback = new CancelCallback() {
            @Override
            public void handle(String s) throws IOException {

            }
        };

        //2. 从 helloworld 队列 接收消息, 消费消息
        c.basicConsume("helloworld", true, deliverCallback, cancelCallback);
    }

}
