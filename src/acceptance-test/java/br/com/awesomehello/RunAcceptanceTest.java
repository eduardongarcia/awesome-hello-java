package br.com.awesomehello;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/jsonReports/cucumber.json", "com.epam.reportportal.cucumber.ScenarioReporter"},
        features = {"src/acceptance-test/resources/features"},
        glue = {"br.com.awesomehello.steps", "br.com.awesomehello.context"},
        tags = {"not @wip"})
public class RunAcceptanceTest {
}
