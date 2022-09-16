package fourteam.massTransit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMq {

  private IMassTransit massTransit;

  public String Host;
  private Connection connection;
  private Channel channel;

  public RabbitMq(IMassTransit massTransit) {
    this.massTransit = massTransit;
  }

  public void newConnection() throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(this.Host);
    this.connection = factory.newConnection();
    this.channel = connection.createChannel();
    System.out.println("Conexion exitosa a rabbit");
  }

  public interface ReceiveEndpoint<E> {
    void run(E endpoint);
  }

  public void ReceiveEndpoint(String QueueName, ReceiveEndpoint<EndPoint> lambda) {
    lambda.run(new EndPoint());
  }

  public Connection getConnection() {
    return connection;
  }

  public Channel getChannel() {
    return channel;
  }
}
