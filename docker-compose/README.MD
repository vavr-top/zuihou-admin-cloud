##启动
docker-compose -f docker-compose-nacos.yml -f docker-compose-rabbitmq.yml -f docker-compose-redis.yml up -d
docker-compose -f docker-compose-nacos.yml -f docker-compose-rabbitmq.yml -f docker-compose-redis.yml stop
docker-compose -f docker-compose-sentinel-dashboard.yml up -d
docker-compose -f docker-compose-sentinel-dashboard.yml stop
docker-compose -f docker-compose-devops.yml up -d
docker-compose -f docker-compose-devops.yml stop