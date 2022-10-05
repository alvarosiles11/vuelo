#!/bin/bash
 
# 📛 Stop and remove containers, networks
sudo docker-compose down

# 🔇 Remove all unused local volumes
sudo docker volume prune -a

# 🌐 Remove all unused networks
#sudo docker network prune

# ❌📸 Remove unused images
sudo docker image prune -a

#sudo docker system prune -a