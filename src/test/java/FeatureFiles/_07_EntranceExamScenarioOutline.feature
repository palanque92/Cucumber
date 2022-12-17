Feature: Exam Functionality

  Background:
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly

  Scenario Outline: Create and delete Exam
    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the Dialog
      | addButton |

    And User sendimg the keys in Dialog content
      | nameInput | <ExamName> |

    And User sendimg the keys in Form Content
      | academicPeriod |
      | <AcademicPeriodOption> |
      | gradeLevel |
      | <GradeLevelOption> |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed
    Examples:
      | ExamName         | AcademicPeriodOption         | GradeLevelOption |
      | Math exam is1x   | academicPeriod1              | gradeLevel2      |
      | IT exam is1x     | academicPeriod1              | gradeLevel3      |
      | Oracle exam is1x | academicPeriod1              | gradeLevel4      |
      | Math exam  is1x  | academicPeriod1              | gradeLevel5      |