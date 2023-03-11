package com.alphaomardiallo.repositories

import com.alphaomardiallo.model.EmojiPhrases

interface Repository {
    suspend fun add(phrase: EmojiPhrases): EmojiPhrases
    suspend fun phrase(id: Int) : EmojiPhrases?
    suspend fun phrase(id: String) : EmojiPhrases?
    suspend fun phrases() : List<EmojiPhrases>
    suspend fun remove(phrase: EmojiPhrases)
    suspend fun remove(id: Int): Boolean
    suspend fun remove(id: String): Boolean
    suspend fun clear()

}