package com.example.thedailyquran.models

class TasbeehGoal constructor(var title: String, var dua: String, var goal: Int, var progress: Int=0) {
    fun getCurrProgress(): Float {
        return (progress.toFloat()/goal.toFloat())
    }
}