package io.github.zenyiar.messagehider;

import io.github.zenyiar.messagehider.modcore.ModCoreInstaller;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.regex.Pattern;

/**
 * Created by Zenyiar
 */
@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class ZenyiarsMessageHider 
{
    public static MessageHiderConfig messageHiderConfig;

    // General
    private final Pattern useRejoinCommand = Pattern.compile("If you get disconnected use /rejoin to join back in the game.");

    // Friends
    private final Pattern friendJoin = Pattern.compile("Friend > \\w{1,16} joined.");
    private final Pattern friendLeave = Pattern.compile("Friend > \\w{1,16} left.");
    private final Pattern friendMessages = Pattern.compile("From \\w{1,16} \\w{1,16}: [\\w\\s]+ ");

    // Guilds
    private final Pattern guildJoin = Pattern.compile("Guild > \\w{1,16} joined.");
    private final Pattern guildLeave = Pattern.compile("Guild > \\w{1,16} left.");
    private final Pattern guildMessages = Pattern.compile("Guild > \\w{1,6} \\w{1,16}: [\\w\\s]+ ");

    // Lobbies
    private final Pattern gameStartsIn = Pattern.compile("The game starts in (\\d+) seconds?!");

    // Bedwars
    private final Pattern bwShopNotEnough = Pattern.compile("You don't have enough [\\w\\s]+! Need (\\d+) more!");
    private final Pattern bwItemShopBought = Pattern.compile("You purchased [\\w\\s]+");
    private final Pattern bwUpgradesShopBought = Pattern.compile("\\w{1,16} purchased [\\w\\s]+");
    private final Pattern bwRespawnMessage = Pattern.compile("You have respawned!");

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);

        messageHiderConfig = new MessageHiderConfig();
        messageHiderConfig.preload();

        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new CommandMessageHiderConfig());
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String chat = event.message.getUnformattedText();
        if (!event.isCanceled()) {
            event.setCanceled(
                // General
                MessageHiderConfig.hideUseRejoinCommand && useRejoinCommand.matcher(chat).matches() ||

                // Friends
                MessageHiderConfig.hideFriendJoin && friendJoin.matcher(chat).matches() ||
                MessageHiderConfig.hideFriendLeave && friendLeave.matcher(chat).matches() ||
                MessageHiderConfig.hideFriendMessages && friendMessages.matcher(chat).matches() ||

                // Guilds
                MessageHiderConfig.hideGuildJoin && guildJoin.matcher(chat).matches() ||
                MessageHiderConfig.hideGuildLeave && guildLeave.matcher(chat).matches() ||
                MessageHiderConfig.hideGuildMessages && guildMessages.matcher(chat).matches() ||

                // Lobbies
                MessageHiderConfig.hideGameStartsIn && gameStartsIn.matcher(chat).matches() ||

                // Bedwars
                MessageHiderConfig.hideBwShopNotEnough && bwShopNotEnough.matcher(chat).matches() ||
                MessageHiderConfig.hideBwItemShopBought && bwItemShopBought.matcher(chat).matches() ||
                MessageHiderConfig.hideBwUpgradesShopBought && bwUpgradesShopBought.matcher(chat).matches() ||
                MessageHiderConfig.hideBwRespawnMessage && bwRespawnMessage.matcher(chat).matches()
            );
        }

    }
}
