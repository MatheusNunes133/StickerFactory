package br.com.images.pokemon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokeAPIModel {

    private String name;
    private Sprites sprites;

    public String getName() {
        return name;
    }

    public Sprites getSprites() {
        return sprites;
    }
}
