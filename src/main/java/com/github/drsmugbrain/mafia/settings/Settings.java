package com.github.drsmugbrain.mafia.settings;

import javax.annotation.Nonnull;

/**
 * Created by DrSmugleaf on 25/08/2017.
 */
public class Settings {

    private int DAY_LENGTH;
    private int NIGHT_LENGTH;
    private int DISCUSSION_TIME;
    private int TRIAL_LENGTH;
    private DayType DAY_TYPE;
    private boolean LAST_WILL_ALLOWED;
    private GameStart GAME_START;
    private NightTimeActions NIGHT_TIME_ACTIONS;
    private boolean PM_ALLOWED;
    private boolean DISCUSSION_PHASE;
    private boolean TRIAL_PAUSES_DAY;
    private boolean TRIAL_DEFENSE;
    private boolean CHOOSE_NAMES;

    public Settings() {}

    @Nonnull
    public static Settings getDefault() {
        Settings settings = new Settings();

        settings
                .setDayLength(120)
                .setNightLength(60)
                .setDiscussionTime(60)
                .setTrialLength(60)
                .setDayType(DayType.TRIAL)
                .setLastWillAllowed(true)
                .setGameStart(GameStart.NIGHT)
                .setNightTimeActions(NightTimeActions.NIGHT_SEQUENCE)
                .setPmAllowed(true)
                .setDiscussionPhase(true)
                .setTrialPausesDay(true)
                .setTrialDefense(true)
                .setChooseNames(false);

        return settings;
    }

    public int getDayLength() {
        return DAY_LENGTH;
    }

    @Nonnull
    public Settings setDayLength(int length) {
        this.DAY_LENGTH = length;
        return this;
    }

    public int getNightLength() {
        return NIGHT_LENGTH;
    }

    @Nonnull
    public Settings setNightLength(int length) {
        this.NIGHT_LENGTH = length;
        return this;
    }

    public int getDiscussionTime() {
        return DISCUSSION_TIME;
    }

    @Nonnull
    public Settings setDiscussionTime(int time) {
        this.DISCUSSION_TIME = time;
        return this;
    }

    public int getTrialLength() {
        return TRIAL_LENGTH;
    }

    @Nonnull
    public Settings setTrialLength(int length) {
        this.TRIAL_LENGTH = length;
        return this;
    }

    @Nonnull
    public DayType getDayType() {
        return DAY_TYPE;
    }

    @Nonnull
    public Settings setDayType(@Nonnull DayType type) {
        this.DAY_TYPE = type;
        return this;
    }

    public boolean isLastWillAllowed() {
        return LAST_WILL_ALLOWED;
    }

    @Nonnull
    public Settings setLastWillAllowed(boolean bool) {
        this.LAST_WILL_ALLOWED = bool;
        return this;
    }

    @Nonnull
    public GameStart getGameStart() {
        return GAME_START;
    }

    @Nonnull
    public Settings setGameStart(@Nonnull GameStart startAt) {
        this.GAME_START = startAt;
        return this;
    }

    @Nonnull
    public NightTimeActions getNightTimeActions() {
        return NIGHT_TIME_ACTIONS;
    }

    @Nonnull
    public Settings setNightTimeActions(@Nonnull NightTimeActions actions) {
        this.NIGHT_TIME_ACTIONS = actions;
        return this;
    }

    public boolean isPmAllowed() {
        return PM_ALLOWED;
    }

    @Nonnull
    public Settings setPmAllowed(boolean bool) {
        this.PM_ALLOWED = bool;
        return this;
    }

    public boolean hasDiscussionPhase() {
        return DISCUSSION_PHASE;
    }

    @Nonnull
    public Settings setDiscussionPhase(boolean bool) {
        this.DISCUSSION_PHASE = bool;
        return this;
    }

    public boolean doesTrialPauseDay() {
        return TRIAL_PAUSES_DAY;
    }

    @Nonnull
    public Settings setTrialPausesDay(boolean bool) {
        this.TRIAL_PAUSES_DAY = bool;
        return this;
    }

    public boolean hasTrialDefense() {
        return TRIAL_DEFENSE;
    }

    @Nonnull
    public Settings setTrialDefense(boolean bool) {
        this.TRIAL_DEFENSE = bool;
        return this;
    }

    public boolean canChooseNames() {
        return CHOOSE_NAMES;
    }

    @Nonnull
    public Settings setChooseNames(boolean bool) {
        this.CHOOSE_NAMES = bool;
        return this;
    }

}
