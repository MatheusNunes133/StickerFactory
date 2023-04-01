package br.com.images.pokemon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sprites {

    private String front_default;

    public String getFront_default() {
        return front_default;
    }
}
