package m2_work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者
 *
 * @author Yuanzhibx
 * @Date 2020-08-05
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 连接
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.201.132");
        f.setPort(5672);
        f.setUsername("admin");
        f.setPassword("admin");
        Channel c = f.newConnection().createChannel();

        // 定义队列
        c.queueDeclare("task_queue", true, false, false, null);

        // 处理消息
        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody());
                System.out.println("收到: " + msg);
                for (int i = 0; i < msg.length(); i++) {
                    if (msg.charAt(i) == '.') {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                c.basicAck(message.getEnvelope().getDeliveryTag(), false);
                System.out.println("消息处理完成\n");
            }
        };

        CancelCallback cancelCallback = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {

            }
        };

        //QOS(Quality of Service): 每次抓取的消息数量(设置为 1, 每次只抓取一条信息), 在手动 ACK 模式下才有效
        c.basicQos(1);

        // 消费消息
        c.basicConsume("task_queue", false, deliverCallback, cancelCallback);
        System.out.println("开始消费数据");
    }

}
