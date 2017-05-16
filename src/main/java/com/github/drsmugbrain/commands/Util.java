package com.github.drsmugbrain.commands;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.Image;
import sx.blah.discord.util.RequestBuffer;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.spi.ImageReaderSpi;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by DrSmugleaf on 14/05/2017.
 */
public class Util {

    public static void avatar(MessageReceivedEvent event, List<String> args) {
        try {
            URL url = new URL(args.get(0));
            URLConnection connection = url.openConnection();
            String contentType = connection.getContentType();

            String suffix = null;
            Iterator<ImageReader> readers = ImageIO.getImageReadersByMIMEType(contentType);

            while(suffix == null && readers.hasNext()) {
                ImageReaderSpi provider = readers.next().getOriginatingProvider();
                if(provider != null) {
                    String[] suffixes = provider.getFileSuffixes();
                    if(suffixes != null) {
                        suffix = suffixes[0];
                    }
                }
            }

            event.getClient().changeAvatar(Image.forUrl(suffix, args.get(0)));
        } catch(IOException e) {
            RequestBuffer.request(() -> event.getChannel().sendMessage("Invalid image URL"));
            e.printStackTrace();
        }

    }

}