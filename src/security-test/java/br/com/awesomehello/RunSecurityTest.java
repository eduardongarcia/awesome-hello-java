package br.com.awesomehello;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.osvaldjr.EasyCucumberRunner;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"resources/features"},
        glue = {"br.com.awesomehello.steps", EasyCucumberRunner.GLUE_EASY_CUCUMBER},
        strict = true)
@Component
public class RunSecurityTest {
}
