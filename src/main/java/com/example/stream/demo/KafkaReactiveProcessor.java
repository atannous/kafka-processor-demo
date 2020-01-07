package com.example.stream.demo;

import com.example.stream.demo.avro.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Profile("reactive")
@Component
public class KafkaReactiveProcessor {

    @Bean
    public Function<Flux<String>, Flux<Item>> process() {
        return s -> s.map(str -> {
                Item item = new Item();
                item.setName(str);
                return item;
        });
    }


}

