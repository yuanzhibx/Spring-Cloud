package m1_simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Yuanzhibx
 * @Date 2020-08-04
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 连接 Rabbitmq 服务器
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.201.132");
        f.setPort(5672);
        f.setUsername("admin");
        f.setPassword("admin");
        // 创建连接
        Connection con = f.newConnection();
        Channel c = con.createChannel();

        // 定义队列, 会通知服务器想使用一个 "Hello World!" 队列 (如果不存在, 则新建)
        c.queueDeclare("helloworld", false, false, false, null);

        // 发送消息
        c.basicPublish("", "helloworld", null, "Hello World".getBytes());

        System.out.println("消息已发送 ~ ~ ~");

        c.close();
        con.close();
    }

}
