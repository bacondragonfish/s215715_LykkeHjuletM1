package com.example.s215715_lykkehjuletm1.model

class CategoryController {
    var wordData = Data()

    fun initilizeData(){
        categoryValues()
    }


    // Our Word Categories, with their words in them. Feel free to add more categories and words!
    fun categoryValues() {
        val cakes = WordCategories("Cakes", listOf(Word("Cookie"), Word("Brownie"), Word("Pancake")))
        val sports = WordCategories("Sport", listOf(Word("Football"), Word("Handball"), Word("Basketball")))
        val trees = WordCategories("Trees", listOf(Word("Oak"), Word("Pine"), Word("Maple")))
        val carbrands = WordCategories("Car Brands", listOf(Word("Audi"), Word("Lamborghini"), Word("Toyota")))
        val countries = WordCategories("Countries", listOf(Word("France"), Word("Mauritius"), Word("Germany"), Word("Colombia")))

        val wordcategories = listOf(cakes, sports, trees, carbrands, countries)

        for (category in wordcategories) {
            wordData.wordCategories.add(category)


        }
    }
}