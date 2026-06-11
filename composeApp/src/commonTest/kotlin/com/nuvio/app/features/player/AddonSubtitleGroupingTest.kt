package com.nuvio.app.features.player

import kotlin.test.Test
import kotlin.test.assertEquals

class AddonSubtitleGroupingTest {
    @Test
    fun `groups language aliases and places unknown last`() {
        val groups = groupAddonSubtitlesByLanguage(
            listOf(
                subtitle(id = "en-1", language = "English"),
                subtitle(id = "unknown", language = "mystery"),
                subtitle(id = "pt", language = "pt-BR"),
                subtitle(id = "en-2", language = "eng"),
            ),
        )

        assertEquals(listOf("en", "pt-br", "unknown"), groups.map { it.language })
        assertEquals(listOf("en-1", "en-2"), groups.first().subtitles.map { it.id })
    }

    private fun subtitle(id: String, language: String) = AddonSubtitle(
        id = id,
        url = "https://example.com/$id.srt",
        language = language,
        display = id,
    )
}
