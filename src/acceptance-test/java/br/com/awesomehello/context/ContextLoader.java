package br.com.awesomehello.context;

import br.com.awesomehello.AwesomeHelloApplication;
import io.cucumber.java.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AwesomeHelloApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("acceptance-test")
public class ContextLoader {

    @Before
    public void startContext() {
    }
}
