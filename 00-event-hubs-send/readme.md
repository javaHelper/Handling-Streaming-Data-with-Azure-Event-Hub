# Send Code 

```java
package com.example.azure;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import org.json.simple.JSONObject;

public class EventHubProducer {
    private static final String connStr = "Endpoint=sb://prateek-event-hubs.servicebus.windows.net/;SharedAccessKeyName=Send;SharedAccessKey=zNcsjpTG0+aTBvvCqxSQieLWnUs8GdpQt+AEhL0scbc=;EntityPath=prateek-event-hub";
    public static final String eventHubName = "prateek-event-hub";

    public static void main(String[] args) {
        EventHubProducerClient producer = new EventHubClientBuilder()
                .connectionString(connStr, eventHubName)
                .buildProducerClient();


        EventDataBatch batch = producer.createBatch();
        batch.tryAdd(new EventData(getJsonStr(1L, "John", "Doe", "john.doe@test.com")));
        batch.tryAdd(new EventData(getJsonStr(2L,"Mike", "Doe", "mike.doe@test.com")));

        producer.send(batch);
        producer.close();
        System.out.println("Event submitted!");
    }

    private static String getJsonStr(Long id, String firstName, String lastName, String email) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("firstName", firstName);
        obj.put("lastName", lastName);
        obj.put("email", email);
        return obj.toJSONString();
    }
}
```


# Receiver Code 

```java
package com.example.azure;

import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubConsumerAsyncClient;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionContext;
import reactor.core.Disposable;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class EventHubReceiver {
    final static String connectionString = "Endpoint=sb://prateek-event-hubs.servicebus.windows.net/;SharedAccessKeyName=Listen;SharedAccessKey=StGkI800mqqWorQelu00k6M3lAvwGmsks+AEhA+kus4=;EntityPath=prateek-event-hub";
    final static String eventHubName = "prateek-event-hub";
    final static Duration OPERATION_TIMEOUT = Duration.ofSeconds(30);
    final static int NUMBER_OF_EVENTS = 10;

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(NUMBER_OF_EVENTS);

        EventHubConsumerAsyncClient consumer = new EventHubClientBuilder()
                .connectionString(connectionString, eventHubName)
                .consumerGroup(EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME)
                .buildAsyncConsumerClient();

        Disposable subscription = consumer.receiveFromPartition("0", EventPosition.latest())
                .subscribe(partitionEvent -> {
                            EventData event = partitionEvent.getData();
                            PartitionContext partitionContext = partitionEvent.getPartitionContext();

                            String contents = new String(event.getBody(), StandardCharsets.UTF_8);
                            System.out.printf("[#%s] Partition id: %s. Sequence Number: %s. Contents: '%s'%n",
                                    countDownLatch.getCount(), partitionContext.getPartitionId(), event.getSequenceNumber(),
                                    contents);

                            countDownLatch.countDown();
                        },
                        error -> {
                            System.err.println("Error occurred while consuming events: " + error);

                            while (countDownLatch.getCount() > 0) {
                                countDownLatch.countDown();
                            }
                        }, () -> {
                            System.out.println("Finished reading events.");
                        });
        try {
            boolean isSuccessful = countDownLatch.await(OPERATION_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
            if (!isSuccessful) {
                System.err.printf("Did not complete successfully. There are: %s events left.%n",
                        countDownLatch.getCount());
            }
        } finally {
            subscription.dispose();
            consumer.close();
        }
    }
}
```


<img width="790" alt="Screenshot 2024-01-16 at 10 49 55 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/75fd0124-34da-4934-8444-c4af03b4de09">
<img width="1074" alt="Screenshot 2024-01-16 at 10 50 04 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/1adf1b9f-e789-4142-8e3c-43e1d0667210">
