# validpassword-api

Web API that validates if a password is valid

Documentation available at http://localhost:8080/swagger-valid-password-api.html

```
Mandatory password:
Nine or more characters
At least 1 digit
At least 1 lowercase letter
At least 1 capital letter
At least 1 special character !@#$%^&*()-+
Do not have repeated characters within the set
```
----
Request Examples:


```
Scenario Outline: client makes call to POST /v1/password
    When the client calls /v1/password with a "<textPassword>" valid
    Then the client receives status code of 200
    And the client receives the true
```

```json
curl -X POST "http://localhost:8080/v1/password" 
      -H  "accept: application/json" 
      -H  "Content-Type: application/json" 
      -d "{\"text\":\"AbTp9!fok\"}"
```
Response:
```
true
```

 ----
```
 Scenario Outline: client makes call to POST /v1/password invalid
      When the client calls /v1/password with a "<textPassword>" invalid
      Then the client receives status code of 400
      And the client receives the false
```
 ```json
curl -X POST "http://localhost:8080/v1/password" 
      -H  "accept: application/json" 
      -H  "Content-Type: application/json" 
      -d "{\"text\":\"AbTp9 fok\"}"
```
Response:
```
false
```
----
```
Scenario Outline: client makes call to POST /v1/password without password throw validation error
     When the client calls /v1/password with a "<textPassword>"
     Then the client receives status code of 400
     And I should see a validation error
```
 ```json
curl -X POST "http://localhost:8080/v1/password" 
      -H  "accept: application/json" 
      -H  "Content-Type: application/json" 
      -d "{}"
```
Response:
```
{
  "message": "Senha nao pode ser nula",
  "error": "NotNullPassword"
}
```
      
