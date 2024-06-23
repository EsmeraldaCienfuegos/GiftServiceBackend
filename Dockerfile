FROM amazoncorretto:17-alpine-jdk
MAINTAINER grupo5
COPY target/GIFT_SERVICE-0.0.1-SNAPSHOT.jar GiftServiceBackend.jar
ENTRYPOINT ["java", "-jar","/GiftServiceBackend.jar"]
