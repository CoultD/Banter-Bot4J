package com.github.drsmugleaf.commands.deadbydaylight;

import com.github.drsmugleaf.BanterBot4J;
import com.github.drsmugleaf.commands.api.Arguments;
import com.github.drsmugleaf.commands.api.Command;
import com.github.drsmugleaf.commands.api.CommandReceivedEvent;
import com.github.drsmugleaf.deadbydaylight.dennisreep.*;
import sx.blah.discord.api.internal.json.objects.EmbedObject;
import sx.blah.discord.util.EmbedBuilder;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Created by DrSmugleaf on 07/11/2018
 */
public class DBDBest extends Command {

    protected DBDBest(@Nonnull CommandReceivedEvent event, @Nonnull Arguments args) {
        super(event, args);
    }

    @Nonnull
    private static String invalidArgumentsResponse() {
        return "Invalid arguments.\n" +
               "**Formats:**\n" +
               BanterBot4J.BOT_PREFIX + "dbdbest charactername\n" +
               "**Examples:**\n" +
               BanterBot4J.BOT_PREFIX + "dbdbest michael myers\n" +
               BanterBot4J.BOT_PREFIX + "dbdbest trapper\n" +
               BanterBot4J.BOT_PREFIX + "dbdbest claudette";
    }

    @Nonnull
    private static Collection<KillerPerk> getBestKillerPerks(int amount) {
        return PerksAPI.KILLER_PERKS.get().getBest(amount).values();
    }

    @Nonnull
    private static Collection<SurvivorPerk> getBestSurvivorPerks(int amount) {
        return PerksAPI.SURVIVOR_PERKS.get().getBest(amount).values();
    }

    @Nonnull
    private EmbedObject getBestPerksResponse(int amount) {
        EmbedBuilder builder = new EmbedBuilder();
        builder
                .withTitle("Best Dead By Daylight Perks")
                .withUrl(API.HOME_URL)
                .withDescription(amount + " Perks")
                .withThumbnail(API.LOGO_URL)
                .withFooterText(getDate());

        if (amount == 1) {
            builder
                    .withTitle("Best Dead by Daylight Perks")
                    .withDescription(amount + " Perk");
        }

        for (KillerPerk perk : getBestKillerPerks(amount)) {
            builder.appendField(
                    perk.NAME + " (" + perk.TIER.NAME + ")",
                    perk.RATING + "★ (" + perk.RATINGS + ")",
                    true
            );
        }

        builder.appendField("\u200b", "\u200b", false);

        for (SurvivorPerk perk : getBestSurvivorPerks(amount)) {
            builder.appendField(
                    perk.NAME + " (" + perk.TIER.NAME + ")",
                    perk.RATING + "★ (" + perk.RATINGS + ")",
                    true
            );
        }

        return builder.build();
    }

    @Override
    public void run() {
        if (ARGS.isEmpty()) {
            EmbedObject response = getBestPerksResponse(4);
            EVENT.reply(response);
        } else if (ARGS.size() == 1 && ARGS.isInteger(0)) {
            int amount = ARGS.getInteger(0);
            EmbedObject response = getBestPerksResponse(amount);
            EVENT.reply(response);
        }
    }

}
