package com.github.drsmugleaf.music;

import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;

import javax.annotation.Nonnull;

/**
 * Created by DrSmugleaf on 07/09/2017.
 */
public class LoadFailedEvent extends HandlerEvent {

    private final FriendlyException EXCEPTION;

    protected LoadFailedEvent(@Nonnull AudioResultHandler handler, @Nonnull FriendlyException exception) {
        super(handler);
        EXCEPTION = exception;
    }

    public FriendlyException getException() {
        return EXCEPTION;
    }

}
