package io.github.classpvp.official.command

import io.github.classpvp.official.classes.PlayerClass
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class CommandTabComplete : TabCompleter {
    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String>? {
        when (command.name) {
            "class" -> {
                when (args.size) {
                    1 -> {
                        val list = listOf("grant", "revoke")
                        val result = mutableListOf<String>()
                        for (string in list) {
                            if (string.lowercase().startsWith(args[0].lowercase())) {
                                result.add(string)
                            }
                        }

                        return result
                    }

                    3 -> {
                        val list = PlayerClass.values().toList()
                        val result = mutableListOf<String>()
                        for (pvpClass in list) {
                            if (pvpClass.name.lowercase().startsWith(args[0].lowercase())) {
                                result.add(pvpClass.name)
                            }
                        }

                        return result
                    }
                }
            }
        }

        return null
    }
}