# Currency Converter

This small RESTful API allows users to convert currencies.<br/> 
Application uses current currency rates from NBP API.

## Application Building and Starting

Application requires Maven installed. To start building proccess write command: <br/>
`mvn clean install` <br/>
After that start application with the following command: <br/>
`java -jar target/*.jar`


## Requests

Users can send POST reqests to `localhost:8080/exchange` with the following JSON format request body:
```
{
  "amount": "1000",
  "sourceCurrencyCode": "EUR",
  "targetCurrencyCode": "USD"
}
```