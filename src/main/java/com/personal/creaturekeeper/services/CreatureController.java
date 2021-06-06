package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.responses.CreatureResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creatures")
public class CreatureController {

    private static final Logger LOG = LoggerFactory.getLogger(CreatureController.class);

    private final CreatureRequestHandler creatureRequestHandler;

    public CreatureController(CreatureRequestHandler creatureRequestHandler) {
        this.creatureRequestHandler = creatureRequestHandler;
    }

    @PostMapping
    public ResponseEntity createCreature(@RequestBody CreatureRequest creatureRequest) {
        LOG.info("Got addCreature request: {}", creatureRequest);
        CreatureResponse response = creatureRequestHandler.createCreature(creatureRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    @RequestMapping("/{creatureId}")
    public ResponseEntity getCreature(@PathVariable int creatureId) {
        LOG.info("Got getCreature request for id: {}", creatureId);
        CreatureResponse response = creatureRequestHandler.getCreature(creatureId);
        return ResponseEntity.ok().body(response);
    }

}
