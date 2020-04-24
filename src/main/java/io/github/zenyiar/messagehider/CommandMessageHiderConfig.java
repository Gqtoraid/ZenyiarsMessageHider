package io.github.zenyiar.messagehider;

import club.sk1er.mods.core.ModCore;
import club.sk1er.mods.core.command.ModCoreCommand;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import java.util.Collections;
import java.util.List;

/**
 * Created by Zenyiar
 */
public class CommandMessageHiderConfig extends ModCoreCommand {
    @Override
    public String getCommandName() {
        return "messagehiderconfig";
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("mhc");
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        ModCore.getInstance().getGuiHandler().open(ZenyiarsMessageHider.messageHiderConfig.gui());
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }
}
