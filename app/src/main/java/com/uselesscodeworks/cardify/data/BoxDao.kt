package com.uselesscodeworks.cardify.data
import androidx.lifecycle.LiveData
import androidx.room.*
import com.uselesscodeworks.cardify.models.Box

@Dao
interface BoxDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBox(Box: Box)

    @Delete
    fun deleteBox(Box: Box)

    @Query("SELECT * FROM box_table ORDER BY id ASC")
    fun getAllBoxes(): LiveData<List<Box>>
}