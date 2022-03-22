package io.github.classpvp.official.command

import io.github.asr.mafp.utils.RED
import io.github.classpvp.official.classes.PlayerClass
import io.github.classpvp.official.utils.grantClass
import io.github.classpvp.official.utils.revokeClass
import net.kyori.adventure.text.Component
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ClassPvPCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        when (command.name) {
            "class" -> {
                if (args.size != 3) {
                    sender.sendMessage(Component.text("${RED}인수가 부족합니다!"))
                    return false
                }

                when (args[0]) {
                    "grant" -> {
                        val player = sender.server.getPlayer(args[1])!!
                        if (args[2] == "ALL") {
                            PlayerClass.values().forEach {
                                player.grantClass(it)
                            }
                            return false
                        }
                        val pvpClass = PlayerClass.valueOf(args[2])
                        player.grantClass(pvpClass)
                    }

                    "revoke" -> {
                        val player = sender.server.getPlayer(args[1])!!
                        if (args[2] == "ALL") {
                            PlayerClass.values().forEach {
                                player.revokeClass(it)
                            }
                            return false
                        }
                        val pvpClass = PlayerClass.valueOf(args[2])
                        player.revokeClass(pvpClass)
                    }
                }
            }
        }

        return false
    }
}