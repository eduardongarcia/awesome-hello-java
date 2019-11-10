package br.com.awesomehello;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/jsonReports/cucumber.json"},
        features = {"src/acceptance-test/resources/features"},
        glue = "br.com.awesomehello.steps",
        tags = {"not @wip"})
public class RunAcceptanceTest {
}
