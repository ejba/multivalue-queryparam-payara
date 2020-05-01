## Description

Since `payara-micro:5.192`, a behaviour change has been noticed when send an HTTP Request passing multiple values to 
the same query parameter using Microprofile Rest Client. This behaviour change prevents an HTTP server (even the payara 
itself) to parse query parameters as usual. 

## Expected Outcome
```
client.callService(Arrays.asList("1", "2"))
// >> http://server:8080/server/example?q=1&q=2
```

## Current Outcome

```
client.callService(Arrays.asList("1", "2"))
// >> http://server:8080/server/example?q=%5B1%2C%202%5D
```

## Steps to reproduce (Only for bug reports) 

1. Launch infrastructure

    ```./buildAndRun.sh```

2. Send HTTP Request to the payara-micro:191 server, passing multiple values to the parameter "q" 
    
    ```curl "http://localhost:8081/client/example?q=1&q=2"```

2. Send HTTP Request to the payara-micro:192 server, passing multiple values to the parameter "q"
    
    ```curl "http://localhost:8082/client/example?q=1&q=2"```

3. Send HTTP Request to the payara-micro:201 server, passing multiple values to the parameter "q" 
    
    ```curl "http://localhost:8083/client/example?q=1&q=2"```

### Samples

[repository](https://github.com/ejba/multivalue-queryparam-payara)

## Context (Optional)

A payara-micro server that invokes an HTTP service (from other payara-micro) passing multiple values to a single 
parameter by using the Microprofile Rest Client.

## Environment ##

- **Payara Version**: 5.1.9.1, 5.1.9.2, 5.2.0.1
- **Edition**: Micro
- **JDK Version**: 8 - OpenJDK
- **Operating System**: Mac, Linux

