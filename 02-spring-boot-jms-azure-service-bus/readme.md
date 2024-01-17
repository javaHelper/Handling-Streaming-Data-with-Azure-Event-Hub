# Use JMS in Spring to access Azure Service Bus

Azure provides an asynchronous messaging platform called Azure Service Bus ("Service Bus") that is based on the Advanced Message Queueing Protocol 1.0 ("AMQP 1.0") standard. You can use Service Bus across the range of supported Azure platforms.

# Logs

```logs
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.1)

2024-01-17 15:40:23.376  INFO 45704 --- [           main] .SpringBootJmsAzureServiceBusApplication : Starting SpringBootJmsAzureServiceBusApplication using Java 11.0.13 on Prateeks-MacBook-Pro.local with PID 45704 (/Users/prats/Documents/Prateek/Handling-Streaming-Data-with-Azure-Event-Hub/02-spring-boot-jms-azure-service-bus/target/classes started by prateekashtikar in /Users/prats/Documents/Prateek/Handling-Streaming-Data-with-Azure-Event-Hub/02-spring-boot-jms-azure-service-bus)
2024-01-17 15:40:23.378  INFO 45704 --- [           main] .SpringBootJmsAzureServiceBusApplication : No active profile set, falling back to 1 default profile: "default"
2024-01-17 15:40:25.459  INFO 45704 --- [           main] AbstractAzureServiceClientBuilderFactory : Will configure the default credential of type DefaultAzureCredential for class com.azure.identity.DefaultAzureCredentialBuilder.
2024-01-17 15:40:28.409  INFO 45704 --- [windows.net:-1]] org.apache.qpid.jms.JmsConnection        : Connection ID:50ccb164-0840-4e25-b95d-e827449e7f0c:1 connected to server: amqps://prateek-service-bus.servicebus.windows.net
2024-01-17 15:40:28.444  INFO 45704 --- [           main] .SpringBootJmsAzureServiceBusApplication : Started SpringBootJmsAzureServiceBusApplication in 5.983 seconds (JVM running for 6.743)
2024-01-17 15:40:29.776  INFO 45704 --- [ntContainer#0-1] com.example.jms.consumer.BookConsumer    : Message received: {"id":1,"title":"White Noise","price":9.99,"publishDate":"2024-Jan-17"}
2024-01-17 15:40:30.398  INFO 45704 --- [ntContainer#0-1] com.example.jms.consumer.BookConsumer    : Message received: {"id":1,"title":"American Psycho","price":8.99,"publishDate":"2024-Jan-17"}
2024-01-17 15:40:30.940  INFO 45704 --- [ntContainer#0-1] com.example.jms.consumer.BookConsumer    : Message received: {"id":1,"title":"A little life","price":7.99,"publishDate":"2024-Jan-17"}

```

<img width="1499" alt="Screenshot 2024-01-17 at 3 06 14 PM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/b3fbf2b1-2fb3-4a70-81d3-ff075f54cd49">

<img width="778" alt="Screenshot 2024-01-17 at 3 06 50 PM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/f8f3642d-d388-42a0-beda-c0e737043ad6">

<img width="1496" alt="Screenshot 2024-01-17 at 3 12 16 PM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/aff1f102-6b71-4b87-85ec-183ab25067fb">

<img width="1499" alt="Screenshot 2024-01-17 at 3 13 50 PM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/9312e9f7-561d-4b78-872c-3148134a0753">

<img width="1488" alt="Screenshot 2024-01-17 at 3 14 43 PM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/fc3df522-8210-4885-a76b-a0d358a32840">

# The simillar way you need to copy 
<img width="1494" alt="Screenshot 2024-01-17 at 3 52 38 PM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/9b65fd85-3d6e-425e-910a-58bee6cbc800">


<img width="1419" alt="Screenshot 2024-01-17 at 3 42 19 PM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/1a805fea-bc23-45cf-b999-c9543099f092">


