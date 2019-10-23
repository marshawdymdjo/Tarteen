package com.generationgirl.kantin

import kotlin.random.Random

class CodeGenerator {

    fun generate(): String {

        val password = StringBuilder(5)
        val random = Random(System.nanoTime())

        // Collect the categories to use.
        val charCategories = ArrayList<String>(4)
        charCategories.add("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
        charCategories.add("0123456789")

        for (i in 0 until 5) {
            val charCategory = charCategories.get(random.nextInt(charCategories.size))
            val position = random.nextInt(charCategory.length)
            password.append(charCategory[position])
        }
        return String(password)
    }
}