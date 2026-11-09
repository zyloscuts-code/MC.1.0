
package com.example.oceanraft;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class OceanRaftSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Ocean Raft Survival Enabled!");
    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {
        if (command.getName().equalsIgnoreCase("raft")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Players only!");
                return true;
            }

            Player player = (Player) sender;
            int x = player.getLocation().getBlockX();
            int y = player.getLocation().getBlockY() - 1;
            int z = player.getLocation().getBlockZ();

            int count = 0;

            for (int dx = -1; dx <= 1; dx++) {
                for (int dz = -1; dz <= 1; dz++) {
                    Block block = player.getWorld()
                            .getBlockAt(x + dx, y, z + dz);

                    if (block.isLiquid()) {
                        block.setType(Material.OAK_PLANKS);
                        count++;
                    }
                }
            }

            player.sendMessage("Raft blocks placed: " + count);
            return true;
        }

        return false;
    }
}
