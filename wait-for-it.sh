#!/bin/bash
# wait-for-it.sh: Chờ MySQL container sẵn sàng trước khi bắt đầu ứng dụng Spring Boot
host="$1"
shift
until mysqladmin ping -h "$host" --silent; do
  echo "Waiting for MySQL at $host..."
  sleep 2
done
echo "MySQL is up - starting application"
exec "$@"
