package br.com.hidarisoft;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsSender {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("EM_TRADE.Q");
        MessageProducer producer = session.createProducer(queue);

        TextMessage message = session.createTextMessage("BUY APPL 1000 SHARES");
        producer.send(message);
        System.out.printf("message sent");
        connection.close();
    }
}
