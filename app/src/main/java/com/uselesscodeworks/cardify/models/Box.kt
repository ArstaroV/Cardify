package com.uselesscodeworks.cardify.models
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "box_table")
data class Box(val name: String) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "box_id")
    var id: Int=0
}