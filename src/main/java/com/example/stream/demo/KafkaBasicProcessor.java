package com.example.stream.demo;

import com.example.stream.demo.avro.Item;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Profile("basic")
@Component
@EnableBinding(KafkaBasicProcessor.Processor.class)
public class KafkaBasicProcessor {


    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Item process(String str) {
        Item item = new Item();
        item.setName(str);
        return item;
    }

    public interface Processor {

        String INPUT = "process-in-0";
        String OUTPUT = "process-out-0";

        @Input(INPUT)
        SubscribableChannel input();

        @Output(OUTPUT)
        MessageChannel output();
    }


}

