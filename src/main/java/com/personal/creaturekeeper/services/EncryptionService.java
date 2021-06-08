package com.personal.creaturekeeper.services;

import com.personal.creaturekeeper.requests.CreatureRequest;
import com.personal.creaturekeeper.requests.ImmutableCreatureRequest;
import com.personal.creaturekeeper.responses.CreaturePayload;
import com.personal.creaturekeeper.responses.ImmutableCreaturePayload;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    private StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

    public EncryptionService(@Value("${encryption.key}") String key) {
        encryptor.setPassword(key);
    }

    public CreatureRequest encryptRequest(CreatureRequest creatureRequest) {
        return ImmutableCreatureRequest.builder()
                .from(creatureRequest)
                .species(this.encryptString(creatureRequest.getSpecies()))
                .build();
    }

    public CreaturePayload decryptPayload(CreaturePayload creaturePayload) {
        return ImmutableCreaturePayload.builder()
                .from(creaturePayload)
                .species(this.decryptString(creaturePayload.getSpecies()))
                .build();
    }

    public String encryptString(String str) {
        return encryptor.encrypt(str);
    }

    public String decryptString(String str) {
        return encryptor.decrypt(str);
    }

}
