Feature: Customers can be validate the password

  Scenario Outline: client makes call to POST /v1/password
    When the client calls /v1/password with a "<textPassword>" valid
    Then the client receives status code of 200
    And the client receives the true

    Examples:
      | textPassword | 
      | AbTp9!fok	   | 
      | BaTp9!kof	   | 
      | AbGp9!foK	   | 
      | ybTp9!fOA	   | 

   Scenario Outline: client makes call to POST /v1/password invalid
      When the client calls /v1/password with a "<textPassword>" invalid
      Then the client receives status code of 400
      And the client receives the false

      Examples:
        | textPassword |
        | aa      	   |
        | ab    	   |
        | AAAbbbCc	   |
        | AbTp9!foo	   |
        | AbTp9!foA	   |
        | AbTp9 fok	   |

   Scenario Outline: client makes call to POST /v1/password without password throw validation error
         When the client calls /v1/password with a "<textPassword>"
         Then the client receives status code of 400
         And I should see a validation error

       Examples:
         | textPassword |
         |              |