package m3_publishsubscribe;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Yuanzhibx
 * @Date 2020-08-06
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
        c.exchangeDeclare("logs", BuiltinExchangeType.FANOUT);
        // 定义随机队列 (Rabbitmq 服务器来随机命名, 非持久, 独占, 自动删除)
        String queue = c.queueDeclare().getQueue();
        // 绑定到交换机 (第三个参数对 fanout 交换机无效)
        c.queueBind(queue, "logs", "");

        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                String msg = new String(message.getBody());
                System.out.println("收到: " + msg);
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
