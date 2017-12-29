package com.github.drsmugleaf;

import com.github.drsmugleaf.commands.PokemonCommands;
import com.github.drsmugleaf.models.Guild;
import com.github.drsmugleaf.models.Member;
import com.github.drsmugleaf.models.User;
import com.github.drsmugleaf.util.Bot;
import com.github.drsmugleaf.util.Env;
import sx.blah.discord.api.IDiscordClient;

/**
 * Created by declan on 03/04/2017.
 */
public class MainRunner {

    public static void main(String[] args) {
        IDiscordClient cli = Bot.buildClient(Env.readFile().get("DISCORD_TOKEN"));

        // Register a listener via the EventSubscriber annotation which allows for organisation and delegation of events
        cli.getDispatcher().registerListener(new CommandHandler());
        cli.getDispatcher().registerListeners(Guild.class, User.class, Member.class, PokemonCommands.class);
        Env.readFile();
        new Database();

        User.createTable(Database.conn);
        Guild.createTable(Database.conn);
        Member.createTable(Database.conn);
        // Only login after all events are registered otherwise some may be missed.
        cli.login();
    }

}