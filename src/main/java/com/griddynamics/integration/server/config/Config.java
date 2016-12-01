package com.griddynamics.integration.server.config;

import com.griddynamics.integration.server.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.*;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.ip.tcp.TcpInboundGateway;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.tcp.connection.TcpNetServerConnectionFactory;
import org.springframework.messaging.MessageChannel;

import java.util.StringTokenizer;

@EnableIntegration
@IntegrationComponentScan
@Configuration
public class Config {

    @Value("${integration.server.port}")
    private int serverPort;

    @Bean
    public TcpInboundGateway tcpInGate(AbstractServerConnectionFactory connectionFactory) {
        TcpInboundGateway inGate = new TcpInboundGateway();
        inGate.setConnectionFactory(connectionFactory);
        inGate.setRequestChannel(fromTcp());
        return inGate;
    }

    @Bean
    public MessageChannel fromTcp() {
        return new DirectChannel();
    }

    @MessageEndpoint
    public static class Echo {

        @Transformer(inputChannel = "fromTcp", outputChannel = "toEcho")
        public Message convert(byte[] bytes) {
            return new Message(new String(bytes));
        }

        @ServiceActivator(inputChannel = "toEcho")
        public String createResponse(Message message) {
            StringTokenizer st = new StringTokenizer(message.getMessage(), "\t\n\r,. ");
            if (st.countTokens() > 1) {
                return "Ho-ho-ho, happy day";
            } else {
                return "Hmmm, sorry";
            }
        }
    }

    @Bean
    public AbstractServerConnectionFactory serverCF() {
        return new TcpNetServerConnectionFactory(this.serverPort);
    }

}
