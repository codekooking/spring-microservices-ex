#!/bin/sh

getPort() {
    echo $1 | cut -d : -f 3 | xargs basename
}

echo "********************************************************"
echo "Waiting for the Discovery server to start on port $DISCOVERYSERVER_PORT"
echo "********************************************************"
while ! `nc -z discovery-server  $DISCOVERYSERVER_PORT`; do sleep 3; done
echo "******* Discovery Server has started"


echo "********************************************************"
echo "Waiting for the Database Server to start on port $DATABASESERVER_PORT"
echo "********************************************************"
while ! `nc -z database $DATABASESERVER_PORT`; do sleep 3; done
echo "******** Database Server has started "

echo "********************************************************"
echo "Waiting for the Configuration server to start on port $CONFIGSERVER_PORT"
echo "********************************************************"
while ! `nc -z config-server $CONFIGSERVER_PORT`; do sleep 3; done
echo "*******  Configuration Server has started"

echo "********************************************************"
echo "Starting License Server with Configuration Service via Discovery endpoint : $DISCOVERYSERVER_URI" ON PORT: $SERVER_PORT;
echo "********************************************************"
java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$SERVER_PORT   \
     -Deureka.client.serviceUrl.defaultZone=$DISCOVERYSERVER_URI             \
     -Dspring.cloud.config.uri=$CONFIGSERVER_URI                          \
     -Dspring.profiles.active=$PROFILE                                   \
     -jar /usr/local/organization-service/@project.build.finalName@.jar
