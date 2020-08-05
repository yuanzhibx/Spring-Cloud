package m2_work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 *
 * @author Yuanzhibx
 * @Date 2020-08-05
 */
public class Producer {

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

        // 发送消息
        while (true) {
            System.out.println("输入消息: ");
            String msg = new Scanner(System.in).nextLine();
            c.basicPublish("", "task_queue", MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
        }
    }

}
