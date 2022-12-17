#Senaryo
  #Daha onceki Create a Fee, Delete Fee Senaryosu
  #name,code,intCode ve priority icin 5 farkli degerler icin calistiriniz
  Feature: Fee Functionality (DataTable Scenario Outline)
    Background:
      Given Naviagate to Campus
      When Enter username and password and click Login button
      Then User should login successfuly

    Scenario Outline: Fee Functionality
      And Click on the element in left nav
        | setupOne    |
        | parameters  |
        | feesSetup   |

      And Click on the element in the Dialog
        | addButton |

      And User sendimg the keys in Dialog content
        | nameInput       | <name>          |
        | codeInput       | <code>          |
        | integrationCode | <intCode>       |
        | priorityCode    | <priority>      |

      And Click on the element in the Dialog
        | toggleBar |
        | saveButton |

      Then Success message should be displayed

      And User delete item from Dialog
        | <name> |

      Then Success message should be displayed
      Examples:
        | name  | code  | intCode     | priority  |
        | omr90 | 01992 | paypal23    | 6660      |
        | omr89 | 01991 | applePay34  | 6650      |
        | omr88 | 01989 | googlePay45 | 6640      |