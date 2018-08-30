#!/bin/sh

echo "********************************************************"
echo "Waiting for the Discovery Server to start  on port $DISCOVERYSERVER_PORT"
echo "********************************************************"
while ! `nc -z discovery-server $DISCOVERYSERVER_PORT`; do sleep 3; done
echo ">>>>>>>>>>>> Discovery Server has started"

echo "********************************************************"
echo "Starting Configuration Server with Discovery endpoint:  $DISCOVERYSERVER_URI";
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Deureka.client.serviceUrl.defaultZone=$DISCOVERYSERVER_URI -jar /usr/local/config-server/@project.build.finalName@.jar
