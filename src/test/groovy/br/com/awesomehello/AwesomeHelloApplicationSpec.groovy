package br.com.awesomehello

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class AwesomeHelloApplicationSpec extends Specification {

    def "context loads"() {
        expect:
        1 == 1
    }
}
