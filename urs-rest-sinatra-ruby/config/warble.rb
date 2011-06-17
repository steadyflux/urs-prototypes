# Warbler web application assembly configuration file
Warbler::Config.new do |config|
  
  config.dirs = %w(app config views)
  config.includes = FileList["init.rb"]
  config.gems += ["sinatra"]
  config.gems -= ["rails"]
  config.gem_dependencies = true
  config.webxml.jruby.min.runtimes = 1
  config.webxml.jruby.max.runtimes = 1
  
end