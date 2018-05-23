#########################################################################################
#	DETENCION DE TODOS LOS PROCESOS DE LA SOLUCIÓN					#
#	Descripción: Detiene todos los procesos de la solución
#	Realizado por: Rafael Reyes - Juan Gonzalez - Heyyson Gutierrez			#
#########################################################################################

echo "Carga de parametros de la solución"
. ../conf/config-proy.sh

echo "deteniendo kafka"
sudo ${KAFHOME}/bin/kafka-server-stop.sh 
echo ${?}
sleep 2
echo "deteniendo zookeeper"
sudo  /home/rafael/Escritorio/BANCARIOS/zookeeper/zookeeper-3.4.12/bin/zkServer.sh stop
echo ${?}

