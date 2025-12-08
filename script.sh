#!bin/bash

echo "Nu kommer skriptet köras med vår onlinestore"
cd onlineStore/src/main/java/se/yrgo
echo "Compiling... "
javac *.java
echo "Running application..."
java Main
echo "Tack för oss" 
