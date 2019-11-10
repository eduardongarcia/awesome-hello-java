# frozen_string_literal: false

require 'httparty'
require 'rspec'

require_relative 'helpers/tshield'
require_relative 'mock'

ENVIRONMENT = ENV['ENVIRONMENT'] || 'local'

puts "# environment: #{ENVIRONMENT}"

$env = YAML.load_file('./config/environments.yml')[ENVIRONMENT]

mock = Mock.new
mock.init_tshield

module CustomWorld
  include Helpers::TShield
end

World(CustomWorld)
