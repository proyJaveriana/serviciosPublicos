/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kafka;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 *
 * @author rafael
 */
public class Consumer {
    
    
    public String consumirMsg(){
    
        boolean continuar=true;
        String mensaje="";
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

       ///ConsumerConfig conConfig = new ConsumerConfig(props);
      
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
        
           consumer.subscribe(Arrays.asList("test"));
          while(continuar){  
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records){
                System.out.println(record.offset() + ": " + record.value());
                mensaje=record.value();
                continuar=false;
            }
          }
        }
        
        
        
    return mensaje;
    }
    
}
