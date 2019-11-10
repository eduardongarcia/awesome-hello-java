.PHONY: dependencies
dependencies : ; docker-compose -f dependencies/docker-compose.yml up -d --build --force-recreate mysql

.PHONY: run
run : ; ./mvnw clean spring-boot:run

.PHONY: install
install : ; ./mvnw clean install

.PHONY: mutation
mutation : ; ./mvnw org.pitest:pitest-maven:mutationCoverage

.PHONY: acceptance-test-java
acceptance-test-java : ; ./mvnw clean verify -Dtest=RunAcceptanceTest

# .PHONY: security-test
# security-test : ; cd src/security-test; ./mvnw clean verify -Dtest=RunSecurityTest
#
# .PHONY: performance-test
# performance-test : ; cd src/performance-test; ./mvnw clean verify
