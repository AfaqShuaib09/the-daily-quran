package com.codefumes.thedailyquran.models

class TasbeehGoal constructor(var id: Int=0, var title: String, var dua: String, var goal: Int, var progress: Int=0, var active: Int=0) {
    fun getCurrProgress(): Float {
        return (progress.toFloat()/goal.toFloat())
    }
}