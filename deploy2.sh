#!/bin/bash
#npx prettier --check .    # Ejecuto el prettier para verificar el orden del codigo
#npx prettier --write .    # Ejecuto el prettier para ordenar el codigo

#NOTA permisos file.sh
#chmod u+r+x deploy.sh
#chmod u+r+x deploy2.sh

docker-compose down
git fetch
git stash
git reset --hard origin/main
git stash pop
docker-compose up -d
