Feature: Frontend Interactions

  Scenario: Validar a funcionalidade do botão New Windows
    Given que estou no site "https://demoqa.com/"
    When escolho a opção Interactions na página inicial
    And escolho o submenu Sortable
    And coloco os elementos na ordem crescente
    Then verifico se os elementos estão corretos
