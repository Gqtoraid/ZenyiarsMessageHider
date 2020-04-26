package io.github.zenyiar.messagehider;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.Property;
import club.sk1er.vigilance.data.PropertyType;

import java.io.File;

/**
 * Created by Zenyiar
 */
public class MessageHiderConfig extends Vigilant 
{
    // General
    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Use Rejoin Command",
        description = "Hide the message in chat that tells you that you can use /rejoin to rejoin the game if disconnected.",
        category = "General",
        subcategory = "General"
    )
    public static boolean hideUseRejoinCommand = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Dashes",
        description = "Hide the long dashes Hypixel sends arround every type of message.",
        category = "General",
        subcategory = "General"
    )
    public static boolean hideHypixelDashes = false;

    // Parties
    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Party Invites",
        description = "Hide the party invite messages that people send you.",
        category = "Parties",
        subcategory = "Invites"
    )
    public static boolean hidePartyInvite = false;

    // Friends
    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Friend Join Messages",
        description = "Hide the messsage in chat that shows when your friend joins on hypixel.",
        category = "Friends",
        subcategory = "Join / Leave"
    )
    public static boolean hideFriendJoin = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Friend Leave Messages",
        description = "Hide the messsage in chat that shows when your friend leaves on hypixel.",
        category = "Friends",
        subcategory = "Join / Leave"
    )
    public static boolean hideFriendLeave = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Friend Messages",
        description = "Hide messages from your friends.",
        category = "Friends",
        subcategory = "Chat"
    )
    public static boolean hideFriendMessages = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Friend Requests",
        description = "Hide friend requests that people send you!",
        category = "Friends",
        subcategory = "Chat"
    )
    public static boolean hideFriendRequests = false;

    // Guilds
    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Guild Join Messages",
        description = "Hide the messsage in chat that shows when someone in your guild joins on hypixel.",
        category = "Guilds",
        subcategory = "Join / Leave"
    )
    public static boolean hideGuildJoin = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Guild Leave Messages",
        description = "Hide the messsage in chat that shows when someone in your guild leaves on hypixel.",
        category = "Guilds",
        subcategory = "Join / Leave"
    )
    public static boolean hideGuildLeave = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Guild Messages",
        description = "Hide messages from your guild.",
        category = "Guilds",
        subcategory = "Chat"
    )
    public static boolean hideGuildMessages = false;

    // Lobbies
    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Game Starts In Counter",
        description = "Hide the message that counts down till the game starts.",
        category = "Lobbies",
        subcategory = "General"
    )
    public static boolean hideGameStartsIn = false;

    // Bedwars
    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Respawn Messages",
        description = "Hide the message in chat that tells you that you have respawned.",
        category = "Bedwars",
        subcategory = "General"
    )
    public static boolean hideBwRespawnMessage = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Not Enough Resources Messages",
        description = "Hide the message in chat when it tells you that you don't have enough to buy that thing.",
        category = "Bedwars",
        subcategory = "General"
    )
    public static boolean hideBwShopNotEnough = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Item Bought Messages",
        description = "Hide the message in chat when you buy something in the Bedwars item shop.",
        category = "Bedwars",
        subcategory = "Item Shop"
    )
    public static boolean hideBwItemShopBought = false;

    @Property(
        type = PropertyType.SWITCH,
        name = "Hide Upgrade Bought Messages",
        description = "Hide the message in chat when you or someone on your team buys something in the Bedwars upgrades shop.",
        category = "Bedwars",
        subcategory = "Upgrades Shop"
    )
    public static boolean hideBwUpgradesShopBought = false;

    // About
    @Property(
        type = PropertyType.SWITCH,
        name = "MessageHider Information",
        description = "§bAuthor: Zenyiar\n§aVersion: v" + Reference.VERSION + " - " + Reference.VERSION_RELEASE_DATE + "\n§6Credits: Sk1erLLC, for giving us the Modcore API to use.",
        category = "About",
        subcategory = "About"
    )
    public static boolean about_unused = false;

    // Initialize
    public MessageHiderConfig() {
        super(new File("./config/messagehider.toml"));
        initialize();
    }
}

