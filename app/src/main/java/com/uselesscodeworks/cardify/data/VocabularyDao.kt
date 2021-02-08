package com.uselesscodeworks.cardify.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.uselesscodeworks.cardify.models.Vocabulary

@Dao
interface VocabularyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addVocabulary(vocabel : Vocabulary)
    @Delete
    fun deleteVocabulary(vocabel : Vocabulary)
    @Update
    fun updateVocabulary(vocabel: Vocabulary)
    @Query("SELECT * FROM vocabulary_table ORDER BY box_vocabel_id ASC")
    fun getAllVocabels(): LiveData<List<Vocabulary>>
    @Query("SELECT * FROM vocabulary_table WHERE box_vocabel_id = :boxId")
    fun getVocabelsByBoxId(boxId : Int): LiveData<List<Vocabulary>>
}