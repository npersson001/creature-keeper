package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.exceptions.CreatureNotFoundException;
import com.personal.creaturekeeper.requests.CreatureRequest;
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

    /**
     * Rest API endpoint to create a Creature.
     * @param creatureRequest - Json object representing a Creature.  Has name, species, and age.
     * @return CreatureResponse - Envelope object containing a CreaturePayload.
     */
    @PostMapping
    public ResponseEntity createCreature(@RequestBody CreatureRequest creatureRequest) {
        LOG.info("Got addCreature request: {}", creatureRequest);
        return creatureRequestHandler.createCreature(creatureRequest);
    }

    /**
     * Rest API endpoint to fetch creature using path variable creatureId.
     * @param creatureId - Path variable that uniquely identifies a Creature.
     * @return
     */
    @GetMapping
    @RequestMapping("/{creatureId}")
    public ResponseEntity getCreature(@PathVariable int creatureId) {
        LOG.info("Got getCreature request for id: {}", creatureId);
        return creatureRequestHandler.getCreature(creatureId);
    }

}
