cd ../../../
mvn package -Dspring.profiles.active=docker -DskipTests
docker build --tag api-service-palindromo:1.0.0 .
cd resources/scripts/app