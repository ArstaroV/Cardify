package com.uselesscodeworks.cardify.models
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "box_table")
data class Box(
    val name: String,
    @PrimaryKey
    val id: Int=0) {
}