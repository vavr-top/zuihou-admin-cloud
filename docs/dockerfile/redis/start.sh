#!/bin/bash

docker stop zuihou_redis
docker rm zuihou_redis
docker run -idt -p 36379:6379 --name zuihou_redis --restart=always \
    -v `pwd`/redis.conf:/etc/redis/redis_default.conf \
    -v /data/docker-data/redis-data/:/data \
    -e TZ="Asia/Shanghai" \
    redis:4.0.12 redis-server /etc/redis/redis_default.conf --appendonly yes

