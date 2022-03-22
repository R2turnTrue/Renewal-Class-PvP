package io.github.classpvp.official.listeners.utils

import io.github.asr.mafp.utils.*
import net.kyori.adventure.text.Component
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.ServerListPingEvent

class ServerMotdListener : Listener {
    @EventHandler
    fun onEvent(event: ServerListPingEvent) {
        event.motd(Component.text("${WHITE}[$YELLOW Class$RED PvP$WHITE ] Version :$GREEN 1.18.1\n" +
                "${WHITE}>>$RED 신규$WHITE 클래스 :$BLUE 마법사$WHITE |$DARK_GRAY Discord"))
    }
}