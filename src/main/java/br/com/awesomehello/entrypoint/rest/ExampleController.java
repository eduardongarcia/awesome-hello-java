package br.com.awesomehello.entrypoint.rest;

import br.com.awesomehello.usecase.GetExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class ExampleController {

    private final GetExample getExample;

    public ExampleController(final GetExample getExample) {
        this.getExample = getExample;
    }

    @GetMapping(value = "/examples", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getExample() {
        return ResponseEntity.ok(getExample.execute());
    }

}
