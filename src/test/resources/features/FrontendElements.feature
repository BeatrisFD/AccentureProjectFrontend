Feature: Frontend Elements

  Scenario: Criar um novo registro
    Given que estou no site "https://demoqa.com/"
    When escolho a opção Elements na página inicial
    And escolho o submenu Web Tables
    And adiciono um novo registro
    Then submeto o registro

  Scenario: Editar um novo registro
    Given que estou no site "https://demoqa.com/"
    When escolho a opção Elements na página inicial
    And escolho o submenu Web Tables
    And clico no botão de editar registro
    Then altero a informação e envio

  Scenario: Deletar um novo registro
    Given que estou no site "https://demoqa.com/"
    When escolho a opção Elements na página inicial
    And escolho o submenu Web Tables
    And clico no botão de deletar registro para os 12 novos
    Then registros não devem existir mais