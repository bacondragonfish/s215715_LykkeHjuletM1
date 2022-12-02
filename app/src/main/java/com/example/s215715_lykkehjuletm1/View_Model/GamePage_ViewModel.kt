package com.example.s215715_lykkehjuletm1.View_Model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.s215715_lykkehjuletm1.model.Data
import com.example.s215715_lykkehjuletm1.model.GameStates
import com.example.s215715_lykkehjuletm1.model.Word
import com.example.s215715_lykkehjuletm1.model.WordCategories
import kotlin.random.Random

class GamePage_ViewModel(private var data: Data) : ViewModel() {

        private val _uiState = mutableStateOf(GameStates())
        val state: State<GameStates> = _uiState

        // This function randomly picks a numberValue from our list of points, and updates the state: wheelPoints.
        // The if statements, is handling if a player gets the bankrupt option, which is the number 1 in our list.
        fun pointsWheel() {
                val listofPoints = listOf(1000, 900, 800, 700, 600, 500, 400, 300, 200, 100, 1)
                val randomIndex = Random.nextInt(listofPoints.size)
                val randomPoints = listofPoints[randomIndex]

                _uiState.value = _uiState.value.copy(wheelPoints = randomPoints)
                if (randomPoints == 1) {
                        _uiState.value = _uiState.value.copy(playerBalance = 0)
                }

        }

        // Sorts a random category from our dataclass, and puts it in the categoryTitle state.
        fun randomCategory() {
                val listofCategores = data.wordCategories
                val randomIndexCategory = Random.nextInt(listofCategores.size)
                val randomCategory = listofCategores[randomIndexCategory].categoryTitle

                _uiState.value = _uiState.value.copy(categoryTitle = randomCategory)
                getListFromCategory(randomCategory)
        }

        //This function returns the list of words inside the chosen category.
        fun getListFromCategory(title: String) {
                var wordlist = mutableListOf<Word>()

                for (category: WordCategories in data.wordCategories) {
                        if (title.equals(category.categoryTitle)) {
                                wordlist = category.categoryWord as MutableList<Word>

                        }
                }
                randomWordFromCategoryList(wordlist)

        }
        // This function takes a random word from the wordlist, and updates our chosenWord state.
        fun randomWordFromCategoryList(wordList: MutableList<Word>) {
                val randomIndexWord = Random.nextInt(wordList.size)
                val randomWordFromIndex = wordList[randomIndexWord].Word.toUpperCase()

                _uiState.value = _uiState.value.copy(chosenWord = randomWordFromIndex)
                showWordLines()
        }

        // This function updates our guessingWord state, with: '_' for each letter in our guessingword.
        fun showWordLines() {
                _uiState.value = _uiState.value.copy(guessingWord = mutableListOf())

                for (letters: Char in state.value.chosenWord) {

                        state.value.guessingWord.add('_')
                }

        }

        // This function checks if the player guess, is in our word, by creating a new list within the function, and updating our guessingWord state with that list.
        // Further when a word is guessed, the wheel points are reset.
        fun checkGuessInWord(char: Char) {
                var emptyListForGuess = mutableListOf<Char>()
                _uiState.value = _uiState.value.copy(rightGuess = false)
                _uiState.value = _uiState.value.copy(wrongGuess = false)

                for (i in 0 until state.value.chosenWord.length) {
                        emptyListForGuess.add(state.value.guessingWord[i])
                        if (state.value.chosenWord[i].equals(char.toUpperCase())) {
                                emptyListForGuess[i] = char.toUpperCase()
                                showPlayerBalance()
                                _uiState.value = _uiState.value.copy(rightGuess = true)

                        }

                }
                if (!state.value.chosenWord.contains(char.toUpperCase())) {
                        showPlayerLives()
                        _uiState.value = _uiState.value.copy(wrongGuess = true)

                }
                checkIfLost()
                checkIfWin()

                _uiState.value = _uiState.value.copy(guessingWord = emptyListForGuess)
                _uiState.value = _uiState.value.copy(wheelPoints = 0)



        }

        // This function updates our playerBalance state with our value of the wheel, if a letter is guessed.

        fun showPlayerBalance() {
                var newPlayerBalance = state.value.playerBalance


                _uiState.value =
                        _uiState.value.copy(playerBalance = newPlayerBalance + state.value.wheelPoints)


        }
        // This function updates the playerLives state, in the occurrence of a wrong guess.
        fun showPlayerLives() {
                var newPlayerLives = state.value.playerLives
                _uiState.value = _uiState.value.copy(playerLives = newPlayerLives - 1)

        }
        // This function updates our playerLost state, if the player has 0 lives left.
        fun checkIfLost() {
                if (state.value.playerLives == 0) {
                        _uiState.value = _uiState.value.copy(playerLost = true)
                }


        }
        //This function updates our playerWon state, if all the letters in a word is guessed.

        fun checkIfWin() {
                if (!state.value.guessingWord.contains('_')) {
                        _uiState.value = _uiState.value.copy(playerWon = true)

                }

        }


        // This function resets all states to default, when the player wants to play again.
        fun resetAllStates() {
                _uiState.value = _uiState.value.copy(
                        playerLives = 5,
                        playerBalance = 0,
                        chooseCategory = "Choose a Category",
                        spinReady = false,
                        chosenWord = "",
                        guessingWord = mutableListOf(),
                        categoryTitle = "Click for Category",
                        wheelPoints = 0,
                        playerLost = false,
                        playerWon = false,
                        wrongGuess = false,
                        rightGuess = false
                )

        }

}







// .copy = update Ui state.
// GameState = All initial data/logik.
// Hvis en jeg laver en funktion inde i viewModel, ender jeg ud med at sætte en ny state, som GamePage da tager ind ved recompose.










