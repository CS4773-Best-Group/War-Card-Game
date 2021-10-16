#!/bin/bash

if [ $# -eq 0 ] 
  then
    echo "ERROR: No arguments supplied"
    exit 1
elif [ $# -ge 3 ] 
  then
    echo "ERROR: Too many arguments supplied"
    exit 1
fi

for i in $@ ; do 
  if ! [[ "$i" =~ ^-?[0-9]+$ ]] ; then
    echo "Invalid input: integers only."
    exit 1
  fi
done

if [ $1 -eq 1 ] 
  then
  if [ -z "$2" ]
    then
      echo "ERROR: Number of max rounds not specified"
      exit 1
  else
    echo "GAME VARIATION $1"
    java -cp hw2.jar:classes main.Main $1 $2
  fi
elif [ $1 -eq 2 ]
  then
  if [ $# -ge 2 ]
    then
      echo "ERROR: Too many arguments supplied"
      exit 1
  else
    echo "GAME VARIATION $1"
    java -cp hw2.jar:classes main.Main $1
  fi
else
  echo "Enter 1 and number of max rounds or 2"
fi