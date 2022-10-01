#!/bin/bash

#enable permissions
#chmod u+r+x ./vuelo/compile.sh 
#chmod u+r+x deploy.sh

sudo ufw enable
#sudo ufw disable
#sudo ufw deny from 203.0.113.0/24
#Habilitar conexiones SSH
#sudo ufw allow ssh
#sudo ufw allow 22
#Habilitar conexiones remotely mongodb
sudo ufw allow 27017


sudo ufw status
