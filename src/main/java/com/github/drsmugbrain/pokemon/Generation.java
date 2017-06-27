package com.github.drsmugbrain.pokemon;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * Created by DrSmugleaf on 27/06/2017.
 */
public enum Generation {

    I("Generation I"),
    II("Generation II"),
    III("Generation III"),
    IV("Generation IV"),
    V("Generation V"),
    VI("Generation VI"),
    VII("Generation VII");

    static {
        I
                .setNewPokemon(151)
                .setTotalPokemon(151)
                .setCoreGames(
                        Game.RED_AND_GREEN,
                        Game.BLUE,
                        Game.RED_AND_BLUE,
                        Game.YELLOW
                );

        II
                .setNewPokemon(100)
                .setTotalPokemon(251)
                .setCoreGames(
                        Game.GOLD_AND_SILVER,
                        Game.CRYSTAL
                );

        III
                .setNewPokemon(135)
                .setTotalPokemon(386)
                .setCoreGames(
                        Game.RUBY_AND_SAPPHIRE,
                        Game.FIRERED_AND_LEAFGREEN,
                        Game.EMERALD
                );

        IV
                .setNewPokemon(107)
                .setTotalPokemon(493)
                .setCoreGames(
                        Game.DIAMOND_AND_PEARL,
                        Game.PLATINUM,
                        Game.HEARTGOLD_AND_SOULSILVER
                );

        V
                .setNewPokemon(156)
                .setTotalPokemon(649)
                .setCoreGames(
                        Game.BLACK_AND_WHITE,
                        Game.BLACK_2_AND_WHITE_2
                );

        VI
                .setNewPokemon(72)
                .setTotalPokemon(721)
                .setCoreGames(
                        Game.X_AND_Y,
                        Game.OMEGA_RUBY_AND_ALPHA_SAPPHIRE
                );

        VII
                .setNewPokemon(81)
                .setTotalPokemon(802)
                .setCoreGames(
                        Game.SUN_AND_MOON,
                        Game.ULTRA_SUN_AND_ULTRA_MOON
                );
    }

    private final String NAME;
    private final List<Game> CORE_GAMES = new ArrayList<>();
    private int NEW_POKEMON;
    private int TOTAL_POKEMON;

    Generation(@Nonnull String name) {
        this.NAME = name;
    }

    public static Generation getGeneration(@Nonnull String generation) {
        generation = generation.toLowerCase();
        if (!Holder.MAP.containsKey(generation)) {
            throw new NullPointerException("Generation " + generation + " doesn't exist");
        }

        return Holder.MAP.get(generation);
    }

    public String getName() {
        return this.NAME;
    }

    public int getNewPokemon() {
        return this.NEW_POKEMON;
    }

    private Generation setNewPokemon(int amount) {
        this.NEW_POKEMON = amount;
        return this;
    }

    public int getTotalPokemon() {
        return this.TOTAL_POKEMON;
    }

    private Generation setTotalPokemon(int amount) {
        this.TOTAL_POKEMON = amount;
        return this;
    }

    public Game[] getCoreGames() {
        return this.CORE_GAMES.toArray(new Game[]{});
    }

    private Generation setCoreGames(Game... games) {
        this.CORE_GAMES.addAll(Arrays.asList(games));
        return this;
    }

    private static class Holder {
        static Map<String, Generation> MAP = new HashMap<>();
    }

}
