package io.github.classpvp.official.utils

import net.kyori.adventure.text.Component

class Lore(
    private val classDescription: List<Component>,
    private var skillDescription: List<String> = listOf("없음"),
    private var potionEffectDescription: String = "없음"
) {
    fun asComponent(): List<Component> {
        val description = classDescription.toMutableList()
        description.add(Component.text("능력 : ${skillDescription[0]}"))
        for (index in 1 until skillDescription.size) description.add(Component.text(skillDescription[index]))
        description.add(Component.text("버프 : $potionEffectDescription"))

        return description
    }
}