package com.github.drsmugbrain.pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DrSmugleaf on 16/09/2017.
 */
public class Action extends Move {

    private final Move MOVE;
    private final Pokemon ATTACKER;
    private final Pokemon DEFENDER;
    private final Integer DAMAGE;
    private final Boolean CRITICAL;
    private final List<BaseVolatileStatus> ATTACKER_VOLATILE_STATUSES = new ArrayList<>();
    private final List<BaseVolatileStatus> DEFENDER_VOLATILE_STATUSES = new ArrayList<>();

    Action(Move move, Pokemon attacker, Pokemon defender, Integer damage, Boolean critical) {
        super(move.getBaseMove());
        this.MOVE = move;
        this.ATTACKER = attacker;
        this.DEFENDER = defender;
        this.DAMAGE = damage;
        this.CRITICAL = critical;
        for (VolatileStatus volatileStatus : attacker.getVolatileStatuses()) {
            this.ATTACKER_VOLATILE_STATUSES.add(volatileStatus.getBaseVolatileStatus());
        }
        for (VolatileStatus volatileStatus : defender.getVolatileStatuses()) {
            this.DEFENDER_VOLATILE_STATUSES.add(volatileStatus.getBaseVolatileStatus());
        }
    }

    public Move getMove() {
        return this.MOVE;
    }

    public Pokemon getAttacker() {
        return this.ATTACKER;
    }

    public Pokemon getDefender() {
        return this.DEFENDER;
    }

    public Integer getDamage() {
        return this.DAMAGE;
    }

    public List<BaseVolatileStatus> getAttackerVolatileStatuses() {
        return this.ATTACKER_VOLATILE_STATUSES;
    }

    public List<BaseVolatileStatus> getDefenderVolatileStatuses() {
        return this.DEFENDER_VOLATILE_STATUSES;
    }

}