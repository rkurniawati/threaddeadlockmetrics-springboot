# Spring Boot Application with Thread Deadlock Metrics

This is an example Spring Boot application that demonstrates how to expose thread deadlock metrics using Micrometer. More information can be found in this [article](https://medium.com/@ruth.kurniawati/detecting-deadlock-with-micrometer-metrics-a8b71ad63cb3).

To run the application, use the following command:

```bash
./gradlew bootRun
```

To query the deadlock metrics exposed by the application along with their values, you can use the following command:

```bash
# query the number of deadlocked threads
curl -s  localhost:8080/actuator/metrics/jvm.threads.deadlocked | jq .

# query the number of deadlocked threads that are waiting on object monitors
curl -s  localhost:8080/actuator/metrics/jvm.threads.deadlocked.monitor | jq .
```

