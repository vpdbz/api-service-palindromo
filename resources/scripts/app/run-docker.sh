# stop and remove current container, if it exists
docker rm api-service-palindromo --force || true

# run detached
docker run -d \
--name api-service-palindromo \
-p 8880:8880 \
-e SERVER_PORT=8880 \
-e SERVICE_IMPLEMENTATION=PALINDROMO_SERVICE \
-e MONGODB_HOST=172.17.0.3 \
-e MONGODB_PORT=27017 \
-e MONGODB_AUTHENTICATION_DATABASE=admin \
-e MONGODB_USERNAME=productListUser \
-e MONGODB_PASSWORD=productListPassword \
-e MONGODB_DATABASE=promotions \
-e SERVICE_LOCALE=en_US \
api-service-palindromo:1.0.0