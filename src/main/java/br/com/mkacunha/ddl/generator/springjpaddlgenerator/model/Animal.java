package br.com.mkacunha.ddl.generator.springjpaddlgenerator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Animal implements Serializable {

    private static final long serialVersionUID = -7512684550783523918L;

    @Id
    private UUID uuid;

    private String name;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
