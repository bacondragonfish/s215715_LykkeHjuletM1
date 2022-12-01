package com.example.s215715_lykkehjuletm1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.s215715_lykkehjuletm1.View.GamePageView
import com.example.s215715_lykkehjuletm1.View_Model.GamePage_ViewModel
import com.example.s215715_lykkehjuletm1.model.CategoryController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val controller = CategoryController()
            controller.initilizeData()
            val viewModel = GamePage_ViewModel(controller.wordData)
            GamePageView(viewModel)
        }
    }
}

