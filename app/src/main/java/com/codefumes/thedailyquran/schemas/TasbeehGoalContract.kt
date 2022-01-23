package com.codefumes.thedailyquran.schemas

import android.provider.BaseColumns

object TasbeehGoalContract {
    // Table contents are grouped together in an anonymous object.
    object TasbeehGoalEntry : BaseColumns {
        const val TABLE_NAME = "TasbeehGoal"
        const val COLUMN_NAME_TITLE = "title"
        const val COLUMN_NAME_DUA = "dua"
        const val COLUMN_NAME_GOAL = "goal"
        const val COLUMN_NAME_PROGRESS= "progress"
        const val COLUMN_NAME_ACTIVE= "active"
    }
}