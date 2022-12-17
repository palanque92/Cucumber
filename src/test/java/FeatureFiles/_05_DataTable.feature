Feature: Datatable Functionality

  Background:
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly

    Scenario: Create Country
      And Click on the element in left nav
      | setupOne    |
      | parameters  |
      | countries   |

      And Click on the element in the Dialog
      | addButton |

      And User sendimg the keys in Dialog content
        | nameInput | omr1992 |
        | codeInput | 98761234 |

      And Click on the element in the Dialog
        | saveButton |

      And Success message should be displayed

      And User delete item from Dialog
      | omr1992 |

      Scenario: Create a Nationality
        And Click on the element in left nav
          | setupOne    |
          | parameters  |
          | nationalities |

        And Click on the element in the Dialog
          | addButton |

        And User sendimg the keys in Dialog content
          | nameInput | omr923 |

        And Click on the element in the Dialog
          | saveButton |

        And Success message should be displayed

        And User delete item from Dialog
          | omr923 |

        Scenario: Fee Functionality
          And Click on the element in left nav
            | setupOne    |
            | parameters  |
            | feesSetup   |

          And Click on the element in the Dialog
            | addButton |

          And User sendimg the keys in Dialog content
            | nameInput | omrfees1 |
            | codeInput | 13247 |
            | integrationCode | 1324 |
            | priorityCode | 13245 |

          And Click on the element in the Dialog
            | toggleBar |
            | saveButton |

          Then Success message should be displayed

          And User delete item from Dialog
            | omrfees1 |

          Then Success message should be displayed

          #Senaryo Outline da verilen degerler icin tum senaryo her satir kadar tekrar calistiriliyordu.
          #DataTable da ise sadece ilgili step icin toplu veri gonderme imkani olusuyor.

