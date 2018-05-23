###############################################################################################
#	Activa Docker para Servicios Publicos						      #
#	Descripcion: Activa el docker de los servicios publicos sobre el puerto local 6060    #
###############################################################################################	


sudo docker build -t servpublicos .
sleep 1
sudo docker run -d -p 6060:8080 servpublicos
echo "URI del servicio= http://localhost:6060/servicios/v1/public/"
