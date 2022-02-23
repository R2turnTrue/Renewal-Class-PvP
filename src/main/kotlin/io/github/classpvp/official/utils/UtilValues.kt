package io.github.classpvp.official.utils

import io.github.classpvp.official.classes.PlayerClass
import org.bukkit.entity.Player

val playerClassMap = mutableMapOf<Player, PlayerClass?>()

val serialKillMap = mutableMapOf<Player, Int>()

val ableClassListMap = mutableMapOf<Player, MutableSet<PlayerClass>>()