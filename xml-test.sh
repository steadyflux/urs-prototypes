for i in {1..5}
do
  /Users/kbaynes/work/apache-tomcat-7.0.14/bin/startup.sh
  sleep 45
  ab -n 2 http://127.0.0.1:8080/urs-rest-sinatra-ruby/user
  sleep 10
  echo "Sinatra Test $i"
  ab -n $1 -c $2 http://127.0.0.1:8080/urs-rest-sinatra-ruby/user > sinatra-jruby-$i
  echo "Done Sinatra Test $i"
  /Users/kbaynes/work/apache-tomcat-7.0.14/bin/shutdown.sh
  zip -r /Users/kbaynes/work/sinatra-jruby-logs-$i.zip /Users/kbaynes/work/apache-tomcat-7.0.14/logs 
  rm -rf apache-tomcat-7.0.14/logs/*
  sleep 30
  /Users/kbaynes/work/apache-tomcat-7.0.14/bin/startup.sh
  sleep 45
  ab -n 2 http://127.0.0.1:8080/urs-rest-jersey-java/user
  sleep 10
  echo "Jersey Test $i"
  ab -n $1 -c $2 http://127.0.0.1:8080/urs-rest-jersey-java/user > jersey-java-$i
  echo "Done Jersey Test $i"
  /Users/kbaynes/work/apache-tomcat-7.0.14/bin/shutdown.sh
  zip -r /Users/kbaynes/work/jersey-java-logs-$i.zip /Users/kbaynes/work/apache-tomcat-7.0.14/logs 
  rm -rf apache-tomcat-7.0.14/logs/*
  folder=`date +%F_%H%M%S`
  mkdir $folder
  mv sinatra-jruby* jersey-java* $folder
  echo "Done iteration $i."
  sleep 30
done

