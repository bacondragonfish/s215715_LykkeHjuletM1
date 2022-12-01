package com.example.s215715_lykkehjuletm1.View_Model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.toUpperCase
import androidx.lifecycle.ViewModel
import com.example.s215715_lykkehjuletm1.model.Data
import com.example.s215715_lykkehjuletm1.model.GameStates
import com.example.s215715_lykkehjuletm1.model.Word
import com.example.s215715_lykkehjuletm1.model.WordCategories
import kotlin.random.Random

class GamePage_ViewModel(private var data: Data) : ViewModel() {

        private val _uiState = mutableStateOf(GameStates())
        val state: State<GameStates> = _uiState




        fun pointsWheel(){

                val listofPoints = listOf(1000, 900, 800, 700, 600, 500, 400, 300, 200, 100, 1)
                val randomIndex = Random.nextInt(listofPoints.size)
                val randomPoints = listofPoints[randomIndex]

                _uiState.value = _uiState.value.copy(playerBalance = randomPoints)
        }




        fun randomCategory(){
                val listofCategores = data.wordCategories
                val randomIndexCategory = Random.nextInt(listofCategores.size)
                val randomCategory = listofCategores[randomIndexCategory].categoryTitle

                _uiState.value = _uiState.value.copy(categoryTitle = randomCategory)
                getListFromCategory(randomCategory)
        }

        fun getListFromCategory (title: String){
                var wordlist = mutableListOf<Word>()

                for (category: WordCategories in data.wordCategories){
                        if (title.equals(category.categoryTitle)){
                                wordlist = category.categoryWord as MutableList<Word>

                        }
                }
                randomWordFromCategoryList(wordlist)

        }

        fun randomWordFromCategoryList (wordList: MutableList<Word>){
                val randomIndexWord = Random.nextInt(wordList.size)
                val randomWordFromIndex = wordList[randomIndexWord].Word.toUpperCase()

                _uiState.value = _uiState.value.copy(chosenWord = randomWordFromIndex)
                showWordLines()
        }


        fun showWordLines (){
                _uiState.value = _uiState.value.copy(guessingWord = mutableListOf())

                for (letters: Char in state.value.chosenWord){

                        state.value.guessingWord.add('_')
                }

                //state.value.guessingword.add("_")
                // Iterere igennem hvert bogstav (char) i chosen wordstring fra state.
                // For hver char der er tilføjer jeg en _ eller - til min liste af chars i state, som er i sta

        }

        fun checkGuessInWord(char: Char) {
                var emptyListForGuess = mutableListOf<Char>()

                for (i in 0 until state.value.chosenWord.length) {
                        emptyListForGuess.add(state.value.guessingWord[i])
                        if (state.value.chosenWord[i].equals(char.toUpperCase())) {
                                emptyListForGuess[i] = char.toUpperCase()


                        }
                }

                _uiState.value = _uiState.value.copy(guessingWord = emptyListForGuess)


        }

        fun showPlayerBalance(){
                var playerBalance = _uiState.value.playerBalance
        }

        }




// .copy = update Ui state.
// GameState = All initial data/logik.
// Hvis en jeg laver en funktion inde i viewModel, ender jeg ud med at sætte en ny state, som GamePage da tager ind ved recompose.










