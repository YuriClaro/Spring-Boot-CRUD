FROM openjdk:21-jdk

WORKDIR /app

COPY build/libs/yuriclaro-exercicio-spring-boot-1-0.0.1-SNAPSHOT.jar /app/yuriclaro-exercicio-spring-boot-1.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "yuriclaro-exercicio-spring-boot-1.jar"]
