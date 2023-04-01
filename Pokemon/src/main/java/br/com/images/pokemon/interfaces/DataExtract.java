package br.com.images.pokemon.interfaces;

import java.util.Map;

public interface DataExtract {

    Map<String, String> extract(String url, String pokemoName);
}
