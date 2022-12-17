#Senaryo
#CitizenShip sayfasina gidiniz.
#Create islemini dogrulayiiniz
#Daha sonra ayni bilgilerle tekrar . Create yapilmadigini dogrulayiniz
#Yukaridaki islemleri Parameter yontemi ile yapiniz.

Feature: CitizenShip with scenario Outline

  Background:
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly
    And Navigate to CitizenShip page

    @Regression
    Scenario Outline: CitizenShip Create
      When User a CitizenShip name as "<name>" short name as "<shorName>"
      Then Success message should be displayed

      #When User a CitizenShip name as "<name>" short name as "<shorName>"
      #Then Already exist message should be displayed

      When User delete the "<name>"
      Then Success message should be displayed

      Examples:
        | name  |  shorName |
        | omr01 |   omr01   |
        | omr02 |   omr02   |
        | omr03 |   omr03   |