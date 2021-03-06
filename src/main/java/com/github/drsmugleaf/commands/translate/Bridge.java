package com.github.drsmugleaf.commands.translate;

import com.github.drsmugleaf.BanterBot4J;
import com.github.drsmugleaf.commands.api.Arguments;
import com.github.drsmugleaf.commands.api.Command;
import com.github.drsmugleaf.commands.api.CommandInfo;
import com.github.drsmugleaf.commands.api.CommandReceivedEvent;
import com.github.drsmugleaf.commands.api.tags.Tags;
import com.github.drsmugleaf.database.models.BridgedChannel;
import com.github.drsmugleaf.translator.Languages;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.Permissions;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by DrSmugleaf on 10/06/2018
 */
@CommandInfo(permissions = {Permissions.MANAGE_CHANNELS}, tags = {Tags.GUILD_ONLY})
public class Bridge extends Command {

    protected Bridge(@Nonnull CommandReceivedEvent event, @Nonnull Arguments args) {
        super(event, args);
    }

    @Override
    public void run() {
        if (ARGS.isEmpty()) {
            EVENT.reply("You didn't provide any channels or languages.\n" +
                        "Usage: " + BanterBot4J.BOT_PREFIX + "bridge channel1 language1 channel2 language2");
            return;
        }

        if (ARGS.size() < 4) {
            EVENT.reply("You didn't provide enough arguments.\n" +
                        "Usage: " + BanterBot4J.BOT_PREFIX + "bridge channel1 language1 channel2 language2");
            return;
        }

        IGuild guild = EVENT.getGuild();
        List<IChannel> firstChannelList = guild.getChannelsByName(ARGS.get(0));
        if (firstChannelList.isEmpty()) {
            EVENT.reply("Couldn't find any channels with name " + ARGS.get(0));
            return;
        }

        IChannel firstChannel = firstChannelList.get(0);

        Languages firstLanguage = Languages.getLanguage(ARGS.get(1));
        if (firstLanguage == null) {
            EVENT.reply("Couldn't find any languages with name " + ARGS.get(1));
            return;
        }

        List<IChannel> secondChannelList = guild.getChannelsByName(ARGS.get(2));
        if (secondChannelList.isEmpty()) {
            EVENT.reply("Couldn't find any channels with name " + ARGS.get(2));
            return;
        }

        IChannel secondChannel = secondChannelList.get(0);

        Languages secondLanguage = Languages.getLanguage(ARGS.get(3));
        if (secondLanguage == null) {
            EVENT.reply("Couldn't find any languages with name " + ARGS.get(3));
            return;
        }

        BridgedChannel firstBridgedChannel = new BridgedChannel(firstChannel.getLongID(), secondChannel.getLongID());
        BridgedChannel secondBridgedChannel = new BridgedChannel(secondChannel.getLongID(), firstChannel.getLongID());

        firstBridgedChannel.channelLanguage = firstLanguage;
        firstBridgedChannel.bridgedLanguage = secondLanguage;

        secondBridgedChannel.channelLanguage = secondLanguage;
        secondBridgedChannel.bridgedLanguage = firstLanguage;

        firstBridgedChannel.save();
        secondBridgedChannel.save();

        EVENT.reply(
                "Bridged together channels " + firstChannel.getName() +
                " with language " + firstLanguage.getName() +
                " and " + secondChannel.getName() +
                " with language " + secondLanguage.getName()
        );
    }

}
