# ApacheKakfa
Apache Kafka producer and consumer Using Springboot

Refer Kakfa-window-config.docx for configuration

Start Zookeper-> cd C:\kafka_2.12-2.8.0

zookeeper-server-start.bat config\zookeeper.properties

Start Kafka Server - cd C:\kafka_2.12-2.8.0

kafka-server-start.bat config\server.properties

Create Topic - 

kafka-topics.bat --zookeeper localhost:2181 --topic first_topic --create --partitions 1 --replication-factor 1

kafka-topics.bat --zookeeper localhost:2181 --list 

kafka-topics.bat --zookeeper localhost:2181 --topic first_topic –describe

Start producing in command prompt ->

cd C:\kafka_2.12-2.8.0

kafka-console-producer.bat --broker-list 127.0.0.1:9092 --topic first_topic

kafka-console-producer.bat --broker-list 127.0.0.1:9092 --topic second_topic

kafka-console-producer.bat --broker-list 127.0.0.1:9092 --topic first_topic --producer-property acks=all

Start Consuming in command prompt ->

cd C:\kafka_2.12-2.8.0

kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic first_topic

kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic first_topic --from-beginning

kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic first_topic --group first-app

kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic first_topic --group first-app –from-beginning

kafka-consumer-groups.bat --bootstrap-server localhost:9092 –list
 
kafka-consumer-groups.bat --bootstrap-server localhost:9092 --describe --group first-app

kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic first_topic --group first-app

kafka-consumer-groups --bootstrap-server localhost:9092 --group first-app --reset-offsets –shift-by -2 --execute --topic first_topic

Invoke through postman - 
http://localhost:8087/kafka/produce/test1

http://localhost:8087/kafka/produceEmp/test2


