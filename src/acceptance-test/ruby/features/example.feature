# language: pt

Funcionalidade: Funcionalidade de exemplo

  Cenario: requisição GET ao serviço /api/v1/examples
    Quando o serviço "/api/v1/examples" é chamado
    Entao o status da resposta é "OK"
    E o corpo da resposta é "hello"
