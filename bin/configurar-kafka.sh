#################################################################################################
#	Descripcion: Configura el kafka								#
#################################################################################################
##-------------------- CREACION DEL TOPICO TEST
sudo sh kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
##--------------------CREACION DEL TOPICO TEST2
sudo sh kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test2
