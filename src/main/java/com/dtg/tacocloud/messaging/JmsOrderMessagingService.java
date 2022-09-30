package com.dtg.tacocloud.messaging;

import com.dtg.tacocloud.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class JmsOrderMessagingService implements OrderMessagingService{

    private JmsTemplate jms;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms){
        this.jms = jms;
    }

    @Override
    public void sendOrder(TacoOrder order) {
        jms.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(order);
            }
        });
    }
}
