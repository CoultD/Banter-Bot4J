package com.github.drsmugleaf.pokemon.events;

import com.github.drsmugleaf.pokemon.battle.Battle;

import org.jetbrains.annotations.NotNull;

/**
 * Created by DrSmugleaf on 19/07/2017.
 */
public class BattleTurnStartEvent extends Event {

    public BattleTurnStartEvent(@NotNull Battle battle) {
        super(battle);
    }

}