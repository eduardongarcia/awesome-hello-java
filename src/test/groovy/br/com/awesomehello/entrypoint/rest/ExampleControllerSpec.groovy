package br.com.awesomehello.entrypoint.rest

import br.com.awesomehello.usecase.GetExample
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

@WebMvcTest(ExampleController.class)
class ExampleControllerSpec extends Specification {
    @Autowired
    MockMvc mvc

    @SpringBean
    GetExample getExample = Mock()

    def "request succes for /api/v1/examples"() {
        given: "usecase GetExample return valid data"
        getExample.execute() >> 'hello world'

        when: "request example api"
        def result = mvc.perform(MockMvcRequestBuilders.get("/api/v1/examples"))

        then: "usecase should called once"
        1 * getExample.execute()

        and: "response should be OK"
        result
                .andExpect(status().isOk())
                .andExpect(content().string("hello world"))
    }

}
