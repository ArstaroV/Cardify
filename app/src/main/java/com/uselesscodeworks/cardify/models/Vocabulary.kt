package com.uselesscodeworks.cardify.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "vocabulary_table", foreignKeys = [
        ForeignKey(
            entity = Box::class,
            parentColumns = ["box_id"],
            childColumns = ["box_vocabel_id"],
            onDelete = ForeignKey.CASCADE
        )]
)
data class Vocabulary(
    val sourceVocabulary: String,
    val targetVocabulary: String,
    @ColumnInfo(name = "box_vocabel_id", index = true)
    val boxId: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo()
    var id: Int=0
}