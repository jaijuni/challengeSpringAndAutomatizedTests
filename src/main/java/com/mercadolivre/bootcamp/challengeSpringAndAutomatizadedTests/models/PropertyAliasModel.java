package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.exceptions.NoAliasFoundedException;

import java.util.HashMap;

public class PropertyAliasModel {
    private HashMap<String, Double> aliases = new HashMap<>();

    public PropertyAliasModel() {
        aliases.put("Jardim Leoni", 800.0);
        aliases.put("Jardim Abacate", 400.0);
        aliases.put("Jardim Morumbi", 1000.0);
        aliases.put("Jardim Fortaleza", 900.0);
    }

    public HashMap<String, Double> getAliases() {
        return aliases;
    }

    public void setAliases(HashMap<String, Double> aliases) {
        this.aliases = aliases;
    }

    public Double getByAliasName(String name) throws NoAliasFoundedException {
        if(aliases.get(name) != null) {
            return aliases.get(name);
        }
        throw new NoAliasFoundedException();
    }
}
