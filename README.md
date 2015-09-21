# RestBalancer
Simple rest load balancer.

BUILD:
./gradlew build

RUNSERVER:
./jetty/runserver.sh

ENDPOINTS
http://localhost:8081/group?userId=[id]

TEST PERFORMANCE:
Need locustio installed on machine. Details in 'performance' directory.
Test in browser: http://localhost:8089/

