package m3_publishsubscribe;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author Yuanzhibx
 * @Date 2020-08-06
 */
public class Producer {

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

        // 向交换机发送数据
        while (true) {
            System.out.println("输入消息: ");
            String msg = new Scanner(System.in).nextLine();
            c.basicPublish("logs", "", null, msg.getBytes());
        }
    }
}
