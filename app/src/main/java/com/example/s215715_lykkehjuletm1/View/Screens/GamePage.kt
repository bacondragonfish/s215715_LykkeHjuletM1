package com.example.s215715_lykkehjuletm1.View

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.s215715_lykkehjuletm1.View.Screens.totalViewStart
import com.example.s215715_lykkehjuletm1.View_Model.GamePage_ViewModel
import com.example.s215715_lykkehjuletm1.model.GameStates



@Composable
fun navController(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "StartScreen"){

        composable(route = "StartScreen"){
            totalViewStart(navController = navController)
        }

        composable(route = "GamePage"){
            //totalView(/*navController = navController*/)


        }
        composable(route = "WinScreen"){

        }


    }

}



@Composable
fun GamePageView(viewModel: GamePage_ViewModel){
    /* TODO Get State setup */
    val state = viewModel.state.value
    Scaffold(backgroundColor = Color.Gray,
        topBar = {topBar()},
        content = {totalView(state, viewModel)},
        bottomBar = { buttomBar()}

    )

}



@Composable
fun totalView(state: GameStates, viewModel: GamePage_ViewModel) {
    // Initial Column, that holds all the Ui elements.
    


    var dropdownEnabled by remember { mutableStateOf(true) }
    var expanded by remember { mutableStateOf(false) }



    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(30.dp))
        // This row is for the catagories, in a drop down menu.
        
        Row(){
            Text(text = "Press this for a random Category and Word:")
        }
        Row(){
            Button(onClick = {viewModel.randomCategory()}) {
                Text(text = state.categoryTitle)
                
            }

        }
        val categories = state.chooseCategory

        Spacer(modifier = Modifier.height(30.dp))

        // This row is for the spinWheelButton

        Button(
            onClick = { viewModel.pointsWheel() },
            modifier = Modifier
                .size(160.dp, 40.dp)
                .padding(),
            colors = ButtonDefaults.buttonColors(),


            ) {
            Text(text = "Spin The Wheel")



        }
        Spacer(modifier = Modifier.height(30.dp))
        // This Row is just a title.
        Row(modifier = Modifier.padding(start = 0.dp)) {
            Text(text = "Points to gain:")
        }
        //This Row is for the display of points, when the wheel is spun.
        var balance = state.playerBalance
        var pointText = "$balance"
        //Row(modifier = Modifier.padding(start = 0.dp)){
            Text(text = pointText, fontSize = 16.sp)

        
        Spacer(modifier = Modifier.height(80.dp))

        // This row is just a title.
        Row(modifier = Modifier.padding(start = 0.dp) ) {
            Text(text = "Your Word To Guess:", fontSize = 30.sp, fontStyle = FontStyle.Italic)
        }
        // This row holds the display of the guessing word.
        Row(modifier = Modifier.padding(start = 0.dp)) {
            var lettersInWord = state.guessingWord
            Text(text = lettersInWord.toString(), fontSize = 25.sp)

        }
        Spacer(modifier = Modifier.height(40.dp))
        // This Row hold the input text field to put the guessing letter.
        Row(modifier = Modifier.padding(start = 0.dp)) {
            userInput(viewModel = viewModel)
        }

    }
}

@Composable
fun spinWheelButton(modifier: Modifier = Modifier, viewModel: GamePage_ViewModel){

    Button(
        onClick = { viewModel.pointsWheel() },
        modifier = Modifier
            .size(160.dp, 40.dp)
            .padding(),
        colors = ButtonDefaults.buttonColors(),


    ) {
        Text(text = "Spin The Wheel")



    }
}



    



@Composable
fun topBar() {
    TopAppBar(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)) {
        Row(modifier = Modifier.padding(100.dp, 0.dp)) {
             Text(text = "LYKKEHJULET", fontSize = 25.sp)
            fontResource(fontFamily = FontFamily.Default)


        }
        




    }

    }

@Composable
fun userInput(viewModel: GamePage_ViewModel) {
    var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it},
            label = { Text(text = "Guess a letter")},
            placeholder = { Text(text = "Enter a single letter") }

        )

    Button(onClick = { viewModel.checkGuessInWord(text.single()) }) {
        Modifier.
        size(50.dp, 40.dp)
    }
    }


 @Composable
 fun showGuessingWord(){

     Column() {
         Text(text = "_"+"_"+"_")
         Modifier.fillMaxWidth()
     }



 }


@Composable
fun buttomBar() {

    BottomAppBar {


    }



}






/*@Preview(showBackground = true)
@Composable
fun Preview() {
//spinWheelButton()
//userInput()
    val controller = wordCategories()
    controller.initilizeData()
    val viewModel = GamePage_ViewModel(controller.wordData)
 GamePageView(viewModel = GamePage_ViewModel(controller.wordData))


        }*/

/*
Row(modifier = Modifier.padding(start = 30.dp)) {
            Text(text = "Category: $categories", fontSize = 20.sp, fontStyle = FontStyle.Normal)
            IconButton(onClick = { expanded = true
            }, enabled = true) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "",
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp)
                )

            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                list.forEach() {


                DropdownMenuItem(onClick = {

                }) {
                }

                }


            }

        }
 */




