#!/bin/sh
mvn clean package && docker build -t com.jdd/jdd .
docker rm -f jdd || true && docker run -d -p 8080:8080 -p 4848:4848 --name jdd com.jdd/jdd 
