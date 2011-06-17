require 'rubygems'
require 'sinatra'
require 'nokogiri'
require 'weakling'

configure do
  root = File.expand_path(File.dirname(__FILE__))
end

not_found do
  status 404
end

Dir["app/controllers/*.rb"].each { |file| load file }
Dir["views/*.builder"].each { |file| load file }