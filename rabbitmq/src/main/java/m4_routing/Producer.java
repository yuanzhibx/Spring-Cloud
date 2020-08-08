package m4_routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * 路由模式
 * 生产者
 *
 * @author Yuanzhibx
 * @Date 2020-08-08
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

        // 定义 direct 类型交换机: direct_logs
        c.exchangeDeclare("direct_logs", BuiltinExchangeType.DIRECT);

        // 发送消息, 消息上携带路由键关键字
        while (true) {
            System.out.println("输入消息:  ");
            String msg = new Scanner(System.in).nextLine();
            System.out.println("输入路由键:  ");
            String key = new Scanner(System.in).nextLine();

            /*
                简单模式和路由模式
                    第二个参数是队列名
                    c.basicPublish("", "helloworld"...)
                发布订阅模式
                    第二个参数无效
                    c.basicPublish("logs", ""...)
                路由模式
                    第二个参数为路由键, 通过键的匹配确定向哪个队列发送
             */
            c.basicPublish("direct_logs", key, null, msg.getBytes());
        }
    }

}