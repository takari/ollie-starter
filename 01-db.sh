#!/bin/sh

DIR=`pwd`

docker run -d \
-e 'POSTGRES_PASSWORD=q1' \
-p 5432:5432 \
--name db \
library/postgres:10.4
