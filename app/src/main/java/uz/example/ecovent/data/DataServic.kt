package uz.example.ecovent.data

import androidx.room.*
import uz.example.ecovent.Model.SaveModel

@Dao
interface DataServic{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSave(save: SaveModel)

    @Update
    suspend fun updateSave(save: SaveModel)

    @Query("SELECT * FROM SaveModel")
    suspend fun getAll(): List<SaveModel>

    @Delete
    suspend fun delet(save: SaveModel)
}