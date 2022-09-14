#!/bin/bash

#NOTA permisos file.sh
#chmod u+r+x deploy.sh

docker-compose down
git fetch
git stash
git reset --hard origin/main
git stash pop
docker-compose up -d
