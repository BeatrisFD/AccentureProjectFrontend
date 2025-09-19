Feature: Frontend Widgets

  Scenario: Pausar a progress bar
    Given que estou no site "https://demoqa.com/"
    When escolho a opção Widgets na página inicial
    And escolho o submenu Progress bar
    And clico no botão start
    And clico no botão stop em 25%
    Then clico no botão start novamente
