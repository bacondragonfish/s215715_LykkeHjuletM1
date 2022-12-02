package com.example.s215715_lykkehjuletm1.model


// Determines what can go into a Word Category
data class WordCategories(
    var categoryTitle: String,
    var categoryWord: List<Word>
)
// Determines what our Words are made op of.
data class Word(
    var Word : String
)

// Determines the initial states
data class GameStates(
    var playerLives: Int = 5,
    var playerBalance: Int = 0,
    var chooseCategory: String = "Choose a Category",
    var spinReady: Boolean = false,
    var chosenWord: String = "",
    var guessingWord: MutableList<Char> = mutableListOf(),
    var categoryTitle: String = "Click for Category",
    var wheelPoints: Int = 0,
    var playerLost: Boolean = false,
    var playerWon: Boolean = false,
    var wrongGuess: Boolean = false,
    var rightGuess: Boolean = false




)

