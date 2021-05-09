# empik-dev-task

Budowanie projektu:
```
sudo docker-compose up --build
```

Docker-compose buduje serwisy: `eureka-service`, `gateway-service`, bazę `MongoDB` oraz 3 instancje `calculator-service`

Zapytania należy wysyłać do `gateway-service` (`localhost:8080/add`). Zapytania zostaną następnie przesłane do jednej z instancji `calculator-service`

Przykładowe zapytanie:

```
curl --location --request POST 'localhost:8080/add' \
--header 'Content-Type: application/json' \
--data-raw '{"numbers" : "1,1,1"}
'
```

UWAGA

Chwilę po zbudowaniu `gateway-service` może odpowiadać błędem:

`[503] during [POST] to [http://calculator/add] [CalculatorClient#addNumbers(Map)]: [Load balancer does not contain an instance for the service calculator]`

W takim wypadku należy poczekać kilka-kilkanaście sekund na zarejestrowanie serwisów.