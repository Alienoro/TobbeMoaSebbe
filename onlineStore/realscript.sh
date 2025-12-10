#!/bin/bash

echo "Nu kommer skriptet köras med vår onlinestore"
mvn clean package
cd target/
echo "Running application..."
java -jar ./*.jar
echo "Tack för oss"
