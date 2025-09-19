Feature: Frontend Forms

  Scenario: Registrar dados e submeter o Forms
    Given que estou no site "https://demoqa.com/"
    When escolho a opção Forms na página inicial
    And preencho o formulário em Practice Form
    Then submeto o formulário
    And fecho o pop-up

