# language: pt

Funcionalidade: Funcionalidade de exemplo

  Cenario: chamada GET a API /api/v1/examples
    Quando o cliente chama "/api/v1/examples"
    Entao o cliente recebe status "OK"
    E o cliente recebe "hello"

