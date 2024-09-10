Feature: Search Shirt Test
  @ExecuteTest @searchShirt
    Scenario: Search shirt teste
    Given Usuario acessa aplicacao
    When Usuario realiza pesquisa
    And Usuario confirma pesquisa
    And Usuario seleciona o produto
    And Usuario seleciona cor e tamanho L
    And Usuario adiciona produto ao carrinho
    And Usuario realiza checkout
    And Usuario informa dados
    Then Usuario finaliza pagamento

