#########################################################################################
#	ACTIVACIÓN DE TODOS LOS PROCESOS DE LA SOLUCIÓN					#
#	Descripción: Aca encontrará los parametros que recibe la solución               #
#	Realizado por: Rafael Reyes - Juan Gonzalez - Heyyson Gutierrez			#
#########################################################################################

## sudo  ./zkServer.sh start
## /home/rafael/Escritorio/CONTRATOS BANCARIOS/zookeeper/zookeeper-3.4.12/bin
## sudo /opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties
##echo ${ZOOHOME}
##echo ${KAFHOME}

echo "Carga de parametros de la solución"
. ../conf/config-proy.sh
echo ${?}
echo "Activando zookeeper"
sudo  /home/rafael/Escritorio/BANCARIOS/zookeeper/zookeeper-3.4.12/bin/zkServer.sh start >> log.txt
echo ${?}
sleep 1
echo "Activando kafka"
sudo ${KAFHOME}/bin/kafka-server-start.sh ${KAFHOME}/config/server.properties & >> log.txt
echo ${?}
echo "Fin de activacion kafka"




##sudo /opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties &
##echo ${?}


