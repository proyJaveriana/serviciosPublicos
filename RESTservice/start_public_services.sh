###############################################################################################
#	Activa Docker para Servicios Publicos						      #
#	Descripcion: Activa el docker de los servicios publicos sobre el puerto local 6060    #
###############################################################################################	

sudo docker run --rm --name kafkamq -d spotify/kafka
docker exec kafka /opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test



sudo docker build -t serviciospublicos .
sleep 1
sudo docker run --rm --name serviciospub --link kafkamq:kafka -d -p 8080:8080 serviciospublicos
sudo docker inspect -f "{{ .HostConfig.Links }}" serviciospub
##echo "URI del servicio= http://localhost:6060/servicios/v1/public/"
