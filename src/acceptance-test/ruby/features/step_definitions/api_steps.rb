# frozen_string_literal: true

Quando('é informado o valor {string} para o parametro {string}') do |value, param|
  @params ||= {}
  @params[param] = value
end

Quando('o serviço {string} é chamado') do |endpoint|
  @request_options = {}
  # @request_options[:headers] = { xxx: '123' }
  # @path = "/api/v1/servico/#{@params['param1']}/detail?filtro=#{@params['param2']}&limit=#{@params['limit']}&offset=#{@params['offset']}"
  @path = endpoint
  @response = RestClientWrapper.new('example').send('get', @path, @request_options)
end

Entao('o status da resposta é {string}') do |status|
  http_status = {
    'OK': 200,
    'Created': 201,
    'No Content': 204
  }
  expect(@response.code).to eql(http_status[status.to_sym])
end

Entao('o corpo da resposta é {string}') do |result|
  # response = JSON.load(@response.body)
  response = @response.body
  expect(response).to eql(result)
end

Entao('deve retornar o header {string} com valor {int}') do |key, value|
  expect(@response.headers[key]).to eql(value.to_s)
end
