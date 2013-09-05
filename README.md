PartitionMagick
===============

Which branch and version is running on which partition, and when will this change?

![PartitionMagick](http://aldaviva.com/portfolio/artwork/partitionmagick.png)

*Dashboards for Maulik*

## Requirements

* [Mongo](http://www.mongodb.org/downloads)
* Java Servlet container with [Java API for WebSocket (JSR-356)](http://jcp.org/en/jsr/detail?id=356) support
	* [GlassFish 4](http://glassfish.java.net/download.html)
	* [Tomcat 8](http://tomcat.apache.org/download-80.cgi) *alpha RC1 as of 2013-09-04*

## Building and Deploying

You need the private key for the Google Calendar API client, which is not checked in. Once you have `calendar_key.p12`, save it in `src/main/resources/META-INF`.

	$ mvn package
	$ cp target/partitionmagick.war /path/to/webapps

## Buzzwords

* Mongo
* Java
	* Servlets
	* JSP
	* WebSockets
* Spring
	* Spring Data
	* Spring Web MVC
* Jersey
* LESS
* Google Calendar API
