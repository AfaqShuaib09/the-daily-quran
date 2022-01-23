package com.example.thedailyquran.DBHelpers

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.thedailyquran.schemas.TasbeehGoalContract

private const val SQL_CREATE_ENTRIES =
    "CREATE TABLE ${TasbeehGoalContract.TasbeehGoalEntry.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${TasbeehGoalContract.TasbeehGoalEntry.COLUMN_NAME_TITLE} TEXT," +
            "${TasbeehGoalContract.TasbeehGoalEntry.COLUMN_NAME_DUA} TEXT, " +
            "${TasbeehGoalContract.TasbeehGoalEntry.COLUMN_NAME_GOAL} INTEGER," +
            "${TasbeehGoalContract.TasbeehGoalEntry.COLUMN_NAME_PROGRESS} INTEGER, " +
            "${TasbeehGoalContract.TasbeehGoalEntry.COLUMN_NAME_ACTIVE} INTEGER)"

private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TasbeehGoalContract.TasbeehGoalEntry.TABLE_NAME}"

class TasbeehGoalDB(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "FeedReader.db"
    }
}