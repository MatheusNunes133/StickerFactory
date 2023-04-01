package br.com.images.pokemon.extract;

import br.com.images.pokemon.Client.Client;
import br.com.images.pokemon.interfaces.DataExtract;
import br.com.images.pokemon.model.PokeAPIModel;
import br.com.images.pokemon.parser.JsonParser;

import java.util.*;

public class APIPokemonDataExtract implements DataExtract {

    public Map<String,String> extract(String url, String pokemonName){
        Client client = new Client();
        String jsonObject = client.dataFinder(url+pokemonName);
        PokeAPIModel jsonParser = new JsonParser().parse(jsonObject);
        Map<String,String> list = new HashMap<String, String>();
        list.put(jsonParser.getName(), jsonParser.getSprites().getFront_default());
        return list;
    }

}
