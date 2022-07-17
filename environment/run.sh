#!/bin/bash

ENVIRONMENT_DIR=$PWD

cd ../sources/currency-watcher/
./gradlew clean build

cd $ENVIRONMENT_DIR

docker-compose -f docker-compose.yml build
docker-compose -f docker-compose.yml up
