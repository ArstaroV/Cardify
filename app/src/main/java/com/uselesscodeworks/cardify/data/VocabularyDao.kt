package com.uselesscodeworks.cardify.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.uselesscodeworks.cardify.models.Vocabulary

@Dao
interface VocabularyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addVocabulary(vocabulary : Vocabulary)
    @Delete
    fun deleteVocabulary(vocabulary : Vocabulary)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateVocabulary(vocabulary: Vocabulary)
    @Query("SELECT * FROM vocabulary_table ORDER BY box_vocabel_id ASC")
    fun getAllVocabels(): LiveData<List<Vocabulary>>
    @Query("SELECT * FROM vocabulary_table WHERE box_vocabel_id = :boxId")
    fun getVocabelsByBoxId(boxId : Int): LiveData<List<Vocabulary>>
}