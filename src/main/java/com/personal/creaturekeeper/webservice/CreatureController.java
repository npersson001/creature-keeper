package com.personal.creaturekeeper.webservice;

import com.personal.creaturekeeper.requests.CreatureRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creatures")
public class CreatureController {

    @PostMapping
    public ResponseEntity addCreature(@RequestBody CreatureRequest creatureRequest) {
        System.out.println(creatureRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getCreature() {
        return ResponseEntity.ok().build();
    }

}
