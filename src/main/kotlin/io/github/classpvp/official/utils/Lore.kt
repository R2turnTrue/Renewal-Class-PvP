package io.github.classpvp.official.utils

import io.github.asr.mafp.utils.WHITE
import net.kyori.adventure.text.Component

class Lore(
    private val classDescription: List<Component>,
    private var skillDescription: List<String> = listOf("없음"),
    private var potionEffectDescription: String = "없음"
) {
    fun asComponent(): List<Component> {
        val description = classDescription.toMutableList()
        description.add(Component.text("${WHITE}능력 : ${skillDescription[0]}"))
        for (index in 1 until skillDescription.size) description.add(Component.text(skillDescription[index]))
        description.add(Component.text("${WHITE}버프 : $potionEffectDescription"))

        return description
    }
}