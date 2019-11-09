package br.com.awesomehello.usecase

import spock.lang.Specification

class GetExampleSpec extends Specification {

    GetExample getExample;

    def setup() {
        getExample = new GetExample()
    }

    def "get valid data"() {
        when: "usecase is called"
        def result = getExample.execute()

        then: "get a valid response"
        result == ""

    }

}
