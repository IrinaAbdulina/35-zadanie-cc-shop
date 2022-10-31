Feature: Find product

  Scenario: chose product
    Given url of shop 'https://shop.kz//'
    Then replies to messages
    Then chose product 'Монитор 21.5" HP V22v G5, Black'

  Scenario: chose absent product
    Given url of shop 'https://shop.kz//'
    Then chose product 'ddd Монитор 21.5" HP V22v G5, Black'
    And assert that user got message 'Нет результатов по вашему запросу'




