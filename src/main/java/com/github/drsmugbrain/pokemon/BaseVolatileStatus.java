package com.github.drsmugbrain.pokemon;

import com.github.drsmugbrain.pokemon.types.Type;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by DrSmugleaf on 18/06/2017.
 */
public enum BaseVolatileStatus implements IBattle {

    BOUND("Bound") {
        @Nullable
        @Override
        public Integer getDuration(Pokemon user, Pokemon target, Move move) {
            double random = Math.random();
            Integer duration;

            Generation generation = user.getBattle().getGeneration();
            switch (generation) {
                case I:
                case II:
                case III:
                case IV:
                    if (random < 0.375) {
                        duration = 2;
                    } else if (random < 0.75) {
                        duration = 3;
                    } else if (random < 0.875) {
                        duration = 4;
                    } else {
                        duration = 5;
                    }

                    break;
                case V:
                case VI:
                case VII:
                    if (random < 0.5) {
                        duration = 4;
                    } else {
                        duration = 5;
                    }

                    break;
                default:
                    throw new InvalidGenerationException(generation);
            }

            return duration;
        }

        @Override
        public void onTrainerTurnStart(@Nonnull Trainer trainer, @Nonnull Pokemon pokemon) {
            pokemon.getVolatileStatus(this).getAction().getAttacker().setValidMoves(BaseMove.BIND);
        }

        @Override
        public void onEnemySendBack(@Nonnull Pokemon user, @Nonnull Pokemon enemy) {
            Generation generation = user.getBattle().getGeneration();

            if (generation != Generation.I) {
                Action action = user.getVolatileStatus(this).getAction();
                Pokemon applier = action.getAttacker();
                if (applier == enemy) {
                    remove(user, enemy, action);
                }
            }
        }

        @Override
        public boolean onOwnAttemptAttack(@Nonnull Pokemon attacker, @Nonnull Pokemon defender, @Nonnull Action action) {
            Generation generation = attacker.getBattle().getGeneration();

            switch (generation) {
                case I:
                    return false;
                case II:
                case III:
                case IV:
                case V:
                case VI:
                case VII:
                    return true;
                default:
                    throw new InvalidGenerationException(generation);
            }
        }

        @Override
        public boolean canSwitch(@Nonnull Pokemon pokemon) {
            Generation generation = pokemon.getBattle().getGeneration();

            switch (generation) {
                case I:
                    return true;
                case II:
                case III:
                case IV:
                case V:
                case VI:
                case VII:
                    return false;
                default:
                    throw new InvalidGenerationException(generation);
            }
        }
    },
    CANT_ESCAPE("Can't escape"),
    CONFUSION("Confusion"),
    CURSE("Curse") {
        @Override
        public void onTurnEnd(@Nonnull Battle battle, @Nonnull Pokemon pokemon) {
            pokemon.damage(25.0);
        }
    },
    EMBARGO("Embargo"),
    ENCORE("Encore"),
    FLINCH("Flinch"),
    HEAL_BLOCK("Heal Block"),
    IDENTIFIED("Identified"),
    INFATUATION("Infatuation"),
    LEECH_SEED("Leech Seed"),
    NIGHTMARE("Nightmare"),
    PERISH_SONG("Perish Song"),
    SPOOKED("Spooked"),
    TAUNT("Taunt"),
    TELEKINESIS("Telekinesis"),
    TORMENT("Torment"),

    AQUA_RING("Aqua Ring"),
    BRACING("Bracing"),
    CENTER_OF_ATTENTION("Center of attention"),
    DEFENSE_CURL("Defense Curl"),
    GLOWING("Glowing"),
    ROOTING("Rooting"),
    MAGIC_COAT("Magic Coat") {
        @Override
        public boolean onOwnReceiveAttack(@Nonnull Pokemon attacker, @Nonnull Pokemon defender, @Nonnull Action action) {
            Generation generation = attacker.getBattle().getGeneration();

            switch (generation) {
                case I:
                    break;
                case II:
                    break;
                case III:
                    break;
                case IV:
                    break;
                case V:
                    if (action.getBaseMove() == BaseMove.DEFOG) {
                        action.reflect();
                        return false;
                    }
                    break;
                case VI:
                    break;
                case VII:
                    break;
            }

            return true;
        }
    },
    MAGNETIC_LEVITATION("Magnetic Levitation"),
    MINIMIZE("Minimize"),
    PROTECTION("Protection"),
    RECHARGING("Recharging"),
    SEMI_INVULNERABLE("Semi-invulnerable"),
    SUBSTITUTE("Substitute"),
    TAKING_AIM("Taking aim"),
    TAKING_IN_SUNLIGHT("Taking in sunlight"),
    WITHDRAWING("Withdrawing"),
    WHIPPING_UP_A_WHIRLWIND("Whipping up a whirlwind"),

    AURORA_VEIL("Aurora Veil", 5) {
        @Override
        protected void apply(Pokemon user, Pokemon target, Action action) {
            if (user.getBattle().getWeather() != Weather.HAIL) {
                this.fail();
                return;
            }

            super.apply(user, target, action);
        }

        @Override
        public double damageMultiplier(@Nonnull Pokemon attacker, @Nonnull Action action) {
            return 0.5;
        }
    },
    BANEFUL_BUNKER("Baneful Bunker", 1) {
        @Override
        public boolean onEnemyAttemptAttack(@Nonnull Pokemon attacker, @Nonnull Pokemon defender, @Nonnull Action action) {
            BaseMove baseMove = action.getBaseMove();

            switch (baseMove) {
                case FEINT:
                case PHANTOM_FORCE:
                case SHADOW_FORCE:
                case HYPERSPACE_HOLE:
                case HYPERSPACE_FURY:
                    this.breakStatus(defender);
                case ACUPRESSURE:
                case AROMATIC_MIST:
                case BESTOW:
                case BLOCK:
                case CONFIDE:
                case CONVERSION_2:
                case CURSE:
                case DOOM_DESIRE:
                case FUTURE_SIGHT:
                case HOLD_HANDS:
                case MEAN_LOOK:
                case PERISH_SONG:
                case PLAY_NICE:
                case PSYCH_UP:
                case ROAR:
                case ROLE_PLAY:
                case SKETCH:
                case SPIDER_WEB:
                case TEARFUL_LOOK:
                case TRANSFORM:
                case WHIRLWIND:
                    return true;
            }

            switch (baseMove.getTarget()) {
                case SELF:
                case ALL_ALLIES:
                case ALL:
                case ALL_FOES:
                    return true;
            }

            if (baseMove.physicalContact()) {
                attacker.setStatus(Status.POISON);
            }

            return false;
        }

        @Override
        public double damageMultiplier(@Nonnull Pokemon attacker, @Nonnull Action action) {
            if (action.getBaseMove().isZMove()) {
                return 0.25;
            }

            return 1.0;
        }
    },
    BEAK_BLAST("Beak Blast", 1) {
        @Override
        public boolean onOwnReceiveAttack(@Nonnull Pokemon attacker, @Nonnull Pokemon defender, @Nonnull Action action) {
            if (action.getBaseMove().physicalContact()) {
                attacker.setStatus(Status.BURN);
            }

            return true;
        }
    },
    BIDE("Bide", 2) {
        @Override
        public boolean onOwnReceiveAttack(@Nonnull Pokemon attacker, @Nonnull Pokemon defender, @Nonnull Action action) {
//            defender.addBideDamageTaken(action.getDamage());
//            defender.setBideTarget(attacker);
            // TODO: Bide damage taken processing
            return true;
        }
    },

    STOCKPILE_1("Stockpile 1"),
    STOCKPILE_2("Stockpile 2"),
    STOCKPILE_3("Stockpile 3"),
    PERISH_0("Perish 0"),
    PERISH_1("Perish 1"),
    PERISH_2("Perish 2"),
    PERISH_3("Perish 3"),

    UPROAR("Uproar"),

    BOUNCE("Bounce", 1) {
        @Override
        public void onTrainerTurnStart(@Nonnull Trainer trainer, @Nonnull Pokemon pokemon) {
            pokemon.setValidMoves(BaseMove.BOUNCE);
        }

        @Override
        protected void remove(Pokemon user, Pokemon target, Move move) {
            super.remove(user, target, move);
        }
    },

    LIGHT_SCREEN("Light Screen"),
    REFLECT("Reflect"),
    CHARGE("Charge", 2) {
        @Override
        public double damageMultiplier(@Nonnull Pokemon attacker, @Nonnull Action action) {
            Generation generation = attacker.getBattle().getGeneration();

            switch (generation) {
                case I:
                case II:
                case III:
                    if (action.getType() == Type.ELECTRIC) {
                        return 2.0;
                    }
                    return 1.0;
                case IV:
                case V:
                case VI:
                case VII:
                    return 1.0;
                default:
                    throw new InvalidGenerationException(generation);
            }
        }

        @Override
        public double powerMultiplier(@Nonnull Pokemon attacker, @Nonnull Action action) {
            Generation generation = attacker.getBattle().getGeneration();

            switch (generation) {
                case I:
                case II:
                case III:
                    return 1.0;
                case IV:
                case V:
                case VI:
                case VII:
                    if (action.getType() == Type.ELECTRIC) {
                        return 2.0;
                    }
                    return 1.0;
                default:
                    throw new InvalidGenerationException(generation);
            }
        }
    },

    CRAFTY_SHIELD("Crafty Shield", 0) {
        @Override
        public boolean onOwnReceiveAttack(@Nonnull Pokemon attacker, @Nonnull Pokemon defender, @Nonnull Action action) {
            if (
                    action.getCategory() == Category.OTHER
                    && attacker != defender
                    && action.getBaseMove() != BaseMove.PERISH_SONG
                    && action.getBaseMove().getEffect() != MoveEffect.ENTRY_HAZARD
                ) {
                return false;
            }

            return true;
        }
    },

    MIST("Mist", null),

    SAFEGUARD("Safeguard", 5);

    private final String NAME;
    private final Integer DURATION;

    BaseVolatileStatus(@Nonnull String name, @Nullable Integer duration) {
        this.NAME = name;
        this.DURATION = duration;
    }

    BaseVolatileStatus(@Nonnull String name) {
        this(name, 1); // TODO: Volatile statuses durations
    }

    @Nonnull
    public String getName() {
        return NAME;
    }

    @Nullable
    public Integer getDuration(Pokemon user, Pokemon target, Move move) {
        return DURATION;
    }

    protected void apply(Pokemon user, Pokemon target, Action action, int duration) {
        VolatileStatus volatileStatus = new VolatileStatus(this, action, duration);
        target.addVolatileStatus(volatileStatus);
    }

    protected void apply(Pokemon user, Pokemon target, Action action) {
        this.apply(user, target, action, getDuration(user, target, action));
    }

    protected void remove(Pokemon user, Pokemon target, Move move) {
        target.removeVolatileStatus(this);
    }

    protected void fail() {}

    protected void breakStatus(Pokemon target) {
        target.removeVolatileStatus(this);
    }

    protected void onTurnStart(Pokemon user, Pokemon target, Battle battle, Trainer trainer, Move move) {}

}
