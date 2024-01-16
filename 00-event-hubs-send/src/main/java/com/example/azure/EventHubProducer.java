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