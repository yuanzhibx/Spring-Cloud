package m5_topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * 主题模式
 * 消费者
 *
 * @author Yuanzhibx
 * @Date 2020-08-08
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.201.132");
        f.setPort(5672);
        f.setUsername("admin");
        f.setPassword("admin");
        Channel c = f.newConnection().createChannel();

        // 定义交换机
        c.exchangeDeclare("topic_logs", BuiltinExchangeType.TOPIC);
        String queue = UUID.randomUUID().toString();
        c.queueDeclare(queue, false, true, true, null);
        System.out.println("输入绑定键, 用空格隔开");
        String[] keys = new Scanner(System.in).nextLine().split("\\s+");
        for (String key : keys) {
            c.queueBind(queue, "topic_logs", key);
        }

        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody());
                String key = message.getEnvelope().getRoutingKey();
                System.out.println(key + " - " + msg);
            }
        };

        CancelCallback cancelCallback = new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {

            }
        };

        // 消费数据
        c.basicConsume(queue, true, deliverCallback, cancelCallback);
    }

}