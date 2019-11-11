package br.com.awesomehello.entrypoint.rest

import br.com.awesomehello.usecase.GetExample
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ExampleController.class)
class ExampleControllerITSpec extends Specification {
    @Autowired
    MockMvc mvc

    @SpringBean
    GetExample getExample = Mock()

//    Mocking and stubbing of the same method call has to happen in the same interaction.
//    http://spockframework.org/spock/docs/1.3/all_in_one.html#_combining_mocking_and_stubbing
    def "request success for /api/v1/examples"() {
        given: "usecase GetExample return valid data"
        getExample.execute() >> 'hello world'

        when: "request example api"
        def result = mvc.perform(MockMvcRequestBuilders.get("/api/v1/examples"))

        then: "response should be OK"
        result
                .andExpect(status().isOk())
                .andExpect(content().string("hello world"))

//        and: "usecase should called once"
//        1 * getExample.execute()
    }

    def "request for /api/v1/examples should call usecase propertily"() {
        when: "request example api"
        def result = mvc.perform(MockMvcRequestBuilders.get("/api/v1/examples"))

        then: "response should be OK"
        1 * getExample.execute()
    }

}
