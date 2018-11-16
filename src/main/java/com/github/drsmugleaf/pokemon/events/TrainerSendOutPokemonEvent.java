package com.github.drsmugleaf.pokemon.events;

import com.github.drsmugleaf.pokemon.pokemon.Pokemon;

import org.jetbrains.annotations.NotNull;

/**
 * Created by DrSmugleaf on 19/07/2017.
 */
public class TrainerSendOutPokemonEvent extends TrainerEvent {

    @NotNull
    public final Pokemon POKEMON;

    public TrainerSendOutPokemonEvent(@NotNull Pokemon pokemon) {
        super(pokemon.getTrainer());
        POKEMON = pokemon;
    }

    @NotNull
    public Pokemon getPokemon() {
        return POKEMON;
    }

}
