PartitionMagick
===============

Which branch and version is running on which partition, and when will this change?

![PartitionMagick](http://aldaviva.com/portfolio/artwork/partitionmagick.png)

*Dashboards for Maulik*

## Requirements

* [Mongo](http://www.mongodb.org/downloads)
* Java Servlet container
	* Tested on [Jetty 8](http://central.maven.org/maven2/org/mortbay/jetty/dist/jetty-deb/8.1.12.v20130726/)
	* Will probably work on [Tomcat](http://tomcat.apache.org/)
	* If you want to try a J2EE application server like JBoss, GlassFish, or Geronimo, be my guest
* You need the private key for the Google Calendar API client, which is not checked in. Once you have `calendar_key.p12`, save it in `src/main/resources/META-INF`.

## Building and Deploying

#### build

	$ mvn package

#### deploy

	$ cp target/partitionmagick.war /path/to/webapps
	
Go to http://127.0.0.1:8080/partitionmagick/ or wherever you deployed to.

## Pages

**dashboard** `/partitionmagick/`

**editor** `/partitionmagick/admin`

## Known Issues

* Apache httpd does not ProxyPass websockets using default configuration

## Buzzwords

* Mongo
* Java
	* Servlets
	* JSP
* Spring
	* Spring Data
	* Spring Web MVC
* Atmosphere
* LESS
* Google Calendar API
