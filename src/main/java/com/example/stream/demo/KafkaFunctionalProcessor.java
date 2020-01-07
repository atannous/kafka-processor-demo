package com.example.stream.demo;

import com.example.stream.demo.avro.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Profile("function")
@Component
public class KafkaFunctionalProcessor {

    @Bean
    public Function<String, Item> process() {
        return str -> {
                Item item = new Item();
                item.setName(str);
                return item;
        };
    }


}

