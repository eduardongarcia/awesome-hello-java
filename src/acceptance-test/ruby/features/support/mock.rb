# frozen_string_literal: true

require 'json'
# require 'tshield'
# require 'tshield/options'

class Mock

  def init_tshield
    # TShield::Options.init(skip_parse: true)
    # Thread.new { TShield::Server.run! }
    wait_for_tshield
    wait_for_app
  end

  def wait_for_tshield
    tries = 0
    loop do
      begin
        response = HTTParty.get $env['tshield']['sessions_url']
      rescue StandardError
        sleep 0.1
        tries += 1
      end
      break if response && response.code == 200 || tries > 5
    end
  end

  def wait_for_app
    tries = 0
    loop do
      begin
        response = HTTParty.get $env['api']['health_url']
      rescue StandardError
        sleep 3
        tries += 1
      end
      break if response && response.code == 200 || tries > 5
    end
  end
end
