/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 *
 * @author rafael
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public int procesar(String msg) {
        
        Properties props = new Properties();
        props.put("zk.connect", "localhost:2181");
        props.put("serializer.class","kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "localhost:9092");
        ProducerConfig config = new ProducerConfig(props);
        
        Producer producer = new Producer(config);
        //String msg = "wellcome";        
        System.out.println(msg);
        producer.send(new KeyedMessage("demo",msg));
        return 200;
    }
    
}
