package com.uselesscodeworks.cardify.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "vocabulary_table", foreignKeys = [
    ForeignKey(entity = Box::class,
        parentColumns = ["box_id"],
        childColumns = ["vocabel_id"],
        onDelete = ForeignKey.CASCADE)])
data class Vocabulary (
    val sourceVocabulary: String,
    val targetVocabulary: String)
{
    @PrimaryKey
    @ColumnInfo(name = "vocabel_id")
    var id: Int=0
}