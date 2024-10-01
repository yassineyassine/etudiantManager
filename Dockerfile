FROM prod.local:5002/amazoncorretto:17-alpine
COPY target/*.jar /opt/app/devops-project-samples.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","/opt/app/devops-project-samples.jar"]
