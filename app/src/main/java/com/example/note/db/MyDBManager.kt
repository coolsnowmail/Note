package com.example.note.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDBManager(context: Context) {
    val myDBHelper = MyDBHelper(context)
    var db: SQLiteDatabase? = null
    fun openDB() {
        db = myDBHelper.writableDatabase
    }

    fun insertToDB(title: String, content: String) {
        val values = ContentValues().apply {
            put(MyBDNameClass.COLUMN_NAME_TITLE, title)
            put(MyBDNameClass.COLUMN_NAME_CONTENT, content)
        }
        db?.insert(MyBDNameClass.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDBData(): ArrayList<String> {
        val dataList = ArrayList<String>()
        val cursor = db?.query(MyBDNameClass.TABLE_NAME, null, null, null, null, null, null)

        while (cursor?.moveToNext()!!) {
            val dataText =cursor.getString(cursor.getColumnIndex(MyBDNameClass.COLUMN_NAME_TITLE))
            dataList.add(dataText.toString())
        }

        cursor.close()
        return dataList
    }

    fun closeDB() {
        myDBHelper.close()
    }
}