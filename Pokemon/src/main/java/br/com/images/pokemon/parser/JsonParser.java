package br.com.images.pokemon.parser;

import br.com.images.pokemon.model.PokeAPIModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    public PokeAPIModel parse(String json){

        try{
            ObjectMapper objetMapper = new ObjectMapper();

            PokeAPIModel pokeAPIModel = objetMapper.readValue(json, PokeAPIModel.class);
            return pokeAPIModel;
        }catch (JsonProcessingException exception){
            System.out.println("Nome inválido!");
            throw new RuntimeException(exception);
        }
    }
}
