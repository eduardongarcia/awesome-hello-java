# frozen_string_literal: true

Before do |scenario|
  puts "==> Scenario '#{scenario.name}' started"
  stop_session
end

After do |scenario|
  stop_session
  puts "==> Scenario '#{scenario.name}' finished"
end
