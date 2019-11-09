package br.com.awesomehello.entrypoint.rest;

import br.com.awesomehello.usecase.GetExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class ExampleController {

    private final GetExample getExample;

    public ExampleController(GetExample getExample) {
        this.getExample = getExample;
    }

    @GetMapping("/examples")
    public ResponseEntity<String> getExample() {
        return ResponseEntity.ok(getExample.execute());
    }

}
