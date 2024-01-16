# Handling-Streaming-Data-with-Azure-Event-Hub

# Ref
- https://learn.microsoft.com/en-us/azure/event-hubs/event-hubs-java-get-started-send?tabs=passwordless%2Croles-azure-portal

# Steps to create Event Hubs Namespace

<img width="1430" alt="Screenshot 2024-01-16 at 10 31 35 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/f70ff6fc-9c2f-4bf7-96a6-d683f10ff38e">
<img width="1493" alt="Screenshot 2024-01-16 at 10 31 49 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/b6f061bf-3db3-4221-93d7-f6e66a4ba9a9">
<img width="880" alt="Screenshot 2024-01-16 at 10 32 52 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/753c384f-c4b3-4986-ba49-f4e58a0c0293">


<img width="1149" alt="Screenshot 2024-01-16 at 10 34 43 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/3f58f8ce-d69a-41dc-8a4d-8d00262a88ca">
<img width="1497" alt="Screenshot 2024-01-16 at 10 35 52 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/cc81ed9c-4d51-42c8-a117-37b06c2ee550">
<img width="783" alt="Screenshot 2024-01-16 at 10 36 19 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/9c101f0a-fe1a-4a5a-bfd1-7cc6b2ab9692">
<img width="1489" alt="Screenshot 2024-01-16 at 10 36 45 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/15b3a44f-4fe3-4e74-9912-89db79836304">

-----------

- Then click on prateek-event-hub then you should see below

<img width="1494" alt="Screenshot 2024-01-16 at 10 38 59 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/573acd61-b643-4839-a11e-9d742cf5f96c">
<img width="1406" alt="Screenshot 2024-01-16 at 10 39 20 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/4dd55dc4-02fe-4961-9319-354023981cc4">
------

- Then create "Shared Access Policies" for both send and receive. Ideally we should create separate policy for both send and receive, however you can keep one as well

<img width="1492" alt="Screenshot 2024-01-16 at 10 41 24 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/9d3c4c83-90f7-42b4-9aa7-dc8442488c6b">
<img width="1213" alt="Screenshot 2024-01-16 at 10 41 54 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/5effb845-d323-4139-8bdb-2f5880c3f969">

- Then click on Send and recieve and copy Primary ConnectionString details

<img width="1503" alt="Screenshot 2024-01-16 at 10 43 00 AM" src="https://github.com/javaHelper/Handling-Streaming-Data-with-Azure-Event-Hub/assets/54174687/a2cef57f-d827-4873-b0a7-26f2f5d6475e">
