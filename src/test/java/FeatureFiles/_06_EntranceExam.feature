Feature: Exam Functionality

  Background:
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly

    Scenario: Create and delete Exam
      And Click on the element in left nav
        | entranceExamsOne |
        | setupTwo |
        | entranceExamsTwo |

      And Click on the element in the Dialog
        | addButton |

      And User sendimg the keys in Dialog content
        | nameInput | omrexam11 |

      And User sendimg the keys in Form Content
        | academicPeriod |
        | academicPeriod1 |
        | gradeLevel |
        | gradeLevel2 |

      And Click on the element in the Dialog
        | saveButton |

      Then Success message should be displayed

      And Click on the element in left nav
        | entranceExamsOne |
        | setupTwo |
        | EntranceExamsTwo |

      And User delete item from Dialog
        | omrexam11 |

      Then Success message should be displayed