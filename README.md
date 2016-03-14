# Demo application for Sezame Java SDK

This demo application is based on Spring Boot and comes with its own embedded Tomcat application server. Thus the demo is executable as a standalone version and does not need to be deployed.

## Prerequisites

Ensure Java 8 JDK and Maven 3.x are installed and added to the environment path.

## Install Sezame Java SDK in your local Maven repository

    git clone git@github.com:finpin/sezame-sdk-java.git
    mvn clean install # sezame sdk root directory

## Build the demo

    git clone git@github.com:finpin/sezame-sdk-java-demo.git
    mvn clean install # execute in demo app's root directory

## Run demo

    java -jar target\sezame-java-demo-app-0.0.1-SNAPSHOT.jar
