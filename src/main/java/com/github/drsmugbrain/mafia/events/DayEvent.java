package com.github.drsmugbrain.mafia.events;

import com.github.drsmugbrain.mafia.Game;
import com.github.drsmugbrain.mafia.Phase;

/**
 * Created by DrSmugleaf on 26/08/2017.
 */
public abstract class DayEvent extends PhaseChangeEvent {

    public DayEvent(Game game) {
        super(game, Phase.DAY);
    }

}