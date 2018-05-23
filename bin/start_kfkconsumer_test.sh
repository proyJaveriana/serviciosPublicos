#######################################################################################
#   ACTIVA CONSOLA PARA KAFKA #1						      #
#	Descripcion: Activar la consola para kafka				      #
#######################################################################################


##xterm -e  "/opt/kafka/bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic demo --from-beginning"

##/opt/kafka/bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic demo --from-beginning

sudo /opt/kafka/bin/kafka-console-consumer.sh --zookeeper localhost:2181 --from-beginning --topic test
