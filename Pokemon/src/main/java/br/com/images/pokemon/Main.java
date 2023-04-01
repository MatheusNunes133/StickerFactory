package br.com.images.pokemon;

import br.com.images.pokemon.extract.APIPokemonDataExtract;
import br.com.images.pokemon.sticker.StickerFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String url = "https://pokeapi.co/api/v2/pokemon/";
        String pokemonName = getPokemonName();
        // DataExtract dados = new APIPokemonDataExtract();
        var dataExtract = new APIPokemonDataExtract().extract(url,pokemonName);

        new StickerFactory().generateSticker(dataExtract.get(pokemonName), pokemonName);

    }

    public static String getPokemonName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o nome do Pokemon:");
        String pokemonName = scan.nextLine();
        return pokemonName.toLowerCase();
    }
}