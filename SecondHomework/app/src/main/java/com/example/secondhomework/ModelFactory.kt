package com.example.secondhomework

object ModelFactory {
    private val titles = listOf("Заголовок 1", "Заголовок 2", "Заголовок 3")
    private val descriptions = listOf("Описание 1", "Описание 2", "Описание 3")
    private val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3
    )

    fun generateModels(count: Int): List<ItemModel> {
        return List(count) { index ->
            ItemModel(
                id = index,
                title = titles.random(),
                description = descriptions.random(),
                imageResId = images.random()
            )
        }
    }

    fun getRandomImage(): Int = images.random()
}