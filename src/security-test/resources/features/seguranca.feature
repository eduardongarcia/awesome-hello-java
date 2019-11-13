# language: pt

Funcionalidade: Seguraça

  Cenario: Validar varredura passiva e ativa
    Dado Eu importo o contexto da especificacao da API "/v2/api-docs"
    E Eu removo os alertas
      | url                    |
      | http://.*/v2/api-docs* |
    E Eu importo as politicas de varredura
    Quando Eu executo a varredura ativa
    Entao o numero de riscos por categoria nao deve ser maior que
      | low | medium | high | informational |
      | 0   | 0      | 0    | 0             |
