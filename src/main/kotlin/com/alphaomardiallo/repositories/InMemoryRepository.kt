package com.alphaomardiallo.repositories

import com.alphaomardiallo.model.EmojiPhrases
import java.util.concurrent.atomic.AtomicInteger
import kotlin.IllegalArgumentException

class InMemoryRepository : Repository {

    private val idCounter = AtomicInteger()
    private val phrases = ArrayList<EmojiPhrases>()

    override suspend fun add(phrase: EmojiPhrases): EmojiPhrases {
        if (phrases.contains(phrase)) {
            return phrases.find { it == phrase }!!
        }
        phrase.id = idCounter.incrementAndGet()
        phrases.add(phrase)
        return phrase
    }

    override suspend fun phrase(id: Int) = phrase(id.toString())

    override suspend fun phrase(id: String) =
        phrases.find { it.id.toString() == id } ?: throw IllegalArgumentException("No phrase found for this $id.")

    override suspend fun phrases() = phrases.toList()

    override suspend fun remove(phrase: EmojiPhrases) {
        if (!phrases.contains(phrase)) {
            throw IllegalArgumentException("No phrase found for id ${phrase.id}")
        }
        phrases.remove(phrase)
    }

    override suspend fun remove(id: Int) = phrases.remove(phrase(id))

    override suspend fun remove(id: String) = phrases.remove(phrase(id))

    override suspend fun clear() = phrases.clear()
}