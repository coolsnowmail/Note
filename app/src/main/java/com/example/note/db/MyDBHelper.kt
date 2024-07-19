package com.example.note.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) :
    SQLiteOpenHelper(context, MyBDNameClass.DATABASE_NAME, null, MyBDNameClass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyBDNameClass.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(MyBDNameClass.SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}