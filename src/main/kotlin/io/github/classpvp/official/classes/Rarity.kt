package io.github.classpvp.official.classes

import io.github.asr.mafp.utils.*
import net.kyori.adventure.text.Component

enum class Rarity(private val rarityString: String) {
    BASIC("${GRAY}BASIC"),
    UNCOMMON("${GREEN}UNCOMMON"),
    RARE("${AQUA}RARE"),
    EPIC("${DARK_PURPLE}EPIC"),
    LEGENDARY("${GOLD}LEGENDARY"),
    DARKNESS("${BLACK}DARKNESS");

    fun component() = Component.text(rarityString)
}