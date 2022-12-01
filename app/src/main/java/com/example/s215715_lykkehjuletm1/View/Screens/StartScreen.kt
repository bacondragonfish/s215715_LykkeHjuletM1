package com.example.s215715_lykkehjuletm1.View.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.s215715_lykkehjuletm1.View.navController


@Composable
fun totalViewStart(navController: NavController) {


    Scaffold() {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ) {
            Button(onClick = { navController.navigate(route = "StartScreen") }) {
                Text(text = "Click Here TO BEGIN")

            }

        }


    }
}



/*
@Composable
fun StartPrev() {


}

*/