/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kafka;

import java.io.Serializable;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 *
 * @author rafael
 */
public class Productor{
    
    
    public void producir(String msg){
    
        Properties props = new Properties();
        //props.put("zk.connect", "localhost:2181");
        props.put("zk.connect", "localhost:2181");
        props.put("serializer.class","kafka.serializer.StringEncoder");
        //props.put("metadata.broker.list", "localhost:9092");
        props.put("metadata.broker.list", "localhost:9092");
        ProducerConfig config = new ProducerConfig(props);
        
        Producer producer = new Producer(config);
    
        System.out.println(msg);
        producer.send(new KeyedMessage("test",msg));
    }
    
    
}
