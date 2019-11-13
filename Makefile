.PHONY: deps-up
deps-up : ; docker-compose -f dependencies/docker-compose.yml up -d --build --force-recreate mysql

.PHONY: deps-down
deps-down : ; docker-compose -f dependencies/docker-compose.yml down

.PHONY: reportportal-up
reportportal-up : ; docker-compose -p reportportal -f dependencies/reportportal/docker-compose.yml up -d --force-recreate

.PHONY: reportportal-down
reportportal-down : ; docker-compose -p reportportal -f dependencies/reportportal/docker-compose.yml down

.PHONY: run
run : ; ./mvnw clean spring-boot:run

.PHONY: run-jar
run-jar: install; cd target; java -jar awesome-hello.jar & echo $$! > ../java-run.PID

.PHONY: install
install : ; ./mvnw clean install

.PHONY: mutation
mutation : ; ./mvnw org.pitest:pitest-maven:mutationCoverage

.PHONY: acceptance-test-java
acceptance-test-java : ; ./mvnw clean verify -Dtest=RunAcceptanceTest

.PHONY: acceptance-test-ruby
acceptance-test-ruby: deps-up run-jar; \
    cd src/acceptance-test/ruby; \
    tshield & echo $$! > tshield-run.PID; \
    cucumber -f pretty -f html -o reports.html -f ReportPortal::Cucumber::Formatter -o report_portal; \
    kill -TERM $$(cat tshield-run.PID) || true; \
    cd ../../../; \
    kill -TERM $$(cat java-run.PID) || true; \
    $(MAKE) deps-down;

.PHONY: security-test
security-test : ; cd src/security-test; mvn clean verify -Dtest=RunSecurityTest

# .PHONY: performance-test
# performance-test : ; cd src/performance-test; ./mvnw clean verify
