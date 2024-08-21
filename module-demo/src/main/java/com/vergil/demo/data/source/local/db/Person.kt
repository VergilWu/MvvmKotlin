package com.vergil.demo.data.source.local.db

import androidx.room.*

@Entity
class Person(
    @field:ColumnInfo(name = "user_name") var name: String, @field:ColumnInfo(
        name = "user_age"
    ) var age: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0

}