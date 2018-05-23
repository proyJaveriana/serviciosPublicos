###############################################################################################
#	Activa Docker para Servicios Publicos						      #
#	Descripcion: Activa el docker de los servicios publicos sobre el puerto local 6060    #
###############################################################################################	


sudo docker build -t kafka .
sleep 1
sudo docker run -d  kafka

