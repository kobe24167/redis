package com.rabbit.callback;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class RabbitConfig {
    
    @Value("${spring.rabbitmq.host}")
    private String addresses;
    
    @Value("${spring.rabbitmq.port}")
    private String port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;
    
    @Bean
    public ConnectionFactory connectionFactory() {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses+":"+port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        /** ���Ҫ������Ϣ�ص������������Ҫ����Ϊtrue */
        connectionFactory.setPublisherConfirms(publisherConfirms);
        return connectionFactory;
    }
    
    @Bean
    /** ��ΪҪ���ûص��࣬����Ӧ��prototype���ͣ������singleton���ͣ���ص���Ϊ���һ������ */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplatenew() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }

}