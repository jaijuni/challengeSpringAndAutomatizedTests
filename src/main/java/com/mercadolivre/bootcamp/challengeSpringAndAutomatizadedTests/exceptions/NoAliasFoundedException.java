package com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.exceptions;

import com.mercadolivre.bootcamp.challengeSpringAndAutomatizadedTests.models.HouseModel;

public class NoAliasFoundedException extends Exception{
    public NoAliasFoundedException() {
        super("Alias not founded on database");
    }

    public String getFieldError() {
        return "alias";
    }
}
