#!/bin/bash

echo "Will try to connect at : $MONGO_HOST"
sleep 5

java -jar ./build/libs/ordering-*.jar
