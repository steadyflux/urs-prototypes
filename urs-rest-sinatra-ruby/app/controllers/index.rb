require 'nokogiri'

get '/' do
  #"Hello world, it's #{Time.now} at the server!\n"
  "Hello World!"
end

get '/user' do
  builder = Nokogiri::XML::Builder.new do |xml|
    xml.user {
      xml.name {
        xml.first "Eleanor"
        xml.middle "Baynes"
        xml.last "Caltagirone"
      }
    }
  end
  builder.to_xml
end
