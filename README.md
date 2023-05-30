# Event-Driven-Microservices-Spring-Boot-Kafka-and-Elastic
docker-compose -f common.yml -f kafka_cluster.yml up


docker-compose -f common.yml -f kafka_cluster.yml -f services.yml up
docker ps

 docker run -it --network host confluentinc/cp-kafkacat kafkacat -b localhost:19092 -L
 
 docker run -it --network host confluentinc/cp-kafkacat kafkacat -b localhost:19092 -C -t twitter-topic
 
 docker logs e7a6b764a13a
 
 docker logs e7a6b764a13a -f
 