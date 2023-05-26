# Event-Driven-Microservices-Spring-Boot-Kafka-and-Elastic
docker-compose -f common.yml -f kafka_cluster.yml up

docker ps

 docker run -it --network host confluentinc/cp-kafkacat kafkacat -b localhost:19092 -L