## Setup

* Run `docker-compose` with https://github.com/confluentinc/examples/tree/5.3.1-post/cp-all-in-one
* Download confluent from https://www.confluent.io/download/ to use the consule consumers.


## Running

To run the annotation-based stream processor:

```bash
SPRING_PROFILES_ACTIVE=basic ./gradlew bootrun
```

To run the function-based stream processor:

```bash
SPRING_PROFILES_ACTIVE=function ./gradlew bootrun
```


## Sending Data

1- Open producer and consumer, each in a different terminal window.

```bash
cd <confluent home>
bin/kafka-console-producer --topic topic1 --broker-list localhost:9092
```

```bash
cd <confluent home>
bin/kafka-avro-console-consumer --topic topic2 --group test1 --bootstrap-server localhost:9092```
```

2- Send data from the producer and watch the consumer output.

