Feature: Customers can be validate the password

  Scenario Outline: client makes call to POST /v1/password
    When the client calls /v1/password with a "<textPassword>" valid
    Then the client receives status code of 200
    And the client receives the true

    Examples:
      | textPassword  | 
      | 'AbTp9!fok'   | 
      | 'BaTp9!kof'   | 
      | 'AbGp9!foK'   | 
      | 'ybTp9!fOA'   | 
      