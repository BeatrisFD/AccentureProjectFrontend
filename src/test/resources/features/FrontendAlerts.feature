Feature: Frontend Alerts

  Scenario: Validar a funcionalidade do botão New Windows
    Given que estou no site "https://demoqa.com/"
    When escolho a opção Alerts na página inicial
    And escolho o submenu Browser Windows
    And clico no botão new Windows
    Then verifico na janela a mensagem This is a sample page
