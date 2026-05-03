FROM openjdk:27-ea-trixie

COPY target/Loan-Management.jar app/Loan-Management.jar

ENTRYPOINT ["java", "-jar" , "/app/Loan-Management.jar"]