package com.uselesscodeworks.cardify.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "vocabulary_table")
data class Vocabulary(
    var sourceVocabulary: String,
    var targetVocabulary: String,
    @ColumnInfo(name = "box_vocabel_id", index = true)
    val boxId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0
}