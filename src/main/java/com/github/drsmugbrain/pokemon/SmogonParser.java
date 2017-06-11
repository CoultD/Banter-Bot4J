package com.github.drsmugbrain.pokemon;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * Created by DrSmugleaf on 06/06/2017.
 */
public class SmogonParser {

    public static void parse() throws IOException {
        Document doc = Jsoup.connect("http://www.smogon.com/dex/sm/pokemon/").get();
        String docString = doc
                .getElementsByTag("script")
                .first()
                .dataNodes()
                .get(0)
                .getWholeData()
                .replace("dexSettings = ", "");
        JSONObject obj = new JSONObject(docString).getJSONArray("injectRpcs").getJSONArray(1).getJSONObject(1);

        JSONArray pokemon = obj.getJSONArray("pokemon");
        SmogonParser.parsePokemon(pokemon);

        JSONArray moves = obj.getJSONArray("moves");
        SmogonParser.parseMoves(moves);
    }

    private static void parsePokemon(JSONArray pokemonJSONArray) {
        for (int i = 0; i < pokemonJSONArray.length(); i++) {
            JSONObject pokemon = pokemonJSONArray.getJSONObject(i);
            JSONArray alts = pokemon.getJSONArray("alts");
            JSONObject statsJSON = alts.getJSONObject(0);
            JSONArray abilitiesJSON = statsJSON.getJSONArray("abilities");
            String name = pokemon.getString("name");

            Ability[] abilities = Ability.getAbilities(abilitiesJSON);
            Type[] types = Type.getTypes(statsJSON.getJSONArray("types"));
            Map<Stat, Integer> stats = BasePokemon.parseBaseStats(statsJSON);

            new BasePokemon(name, abilities, types, stats).createBasePokemon();
        }
    }

    private static void parseMoves(JSONArray movesJSONArray) {
        for (int i = 0; i < movesJSONArray.length(); i++) {
            JSONObject move = movesJSONArray.getJSONObject(i);
            String name = move.getString("name");
            Type type = Type.getType(move.getString("type"));
            Category category = Category.getCategory(move.getString("category"));
            int power = move.getInt("power");
            int accuracy = move.getInt("accuracy");
            int pp = move.getInt("pp");

            new BaseMove(name, type, category, power, accuracy, pp).createBaseMove();
        }
    }

    private static void printAbilitiesAsEnums(JSONArray abilities) {
        for (int i = 0; i < abilities.length(); i++) {
            String name = abilities.getJSONObject(i).getString("name");

            System.out.print(name
                    .replace(" ", "_")
                    .replace("-", "_")
                    .replace("'", "")
                    .toUpperCase()
            );
            System.out.println("(\"" + name + "\"),");
        }
    }

    private static void printItemsAsEnums(JSONArray items) {
        for (int i = 0; i < items.length(); i++) {
            String name = items.getJSONObject(i).getString("name");

            System.out.print(name
                    .replace(" ", "_")
                    .replace("-", "_")
                    .replace("'", "")
                    .toUpperCase()
            );
            System.out.println("(\"" + name + "\"),");
        }
    }

}
