package uz.example.ecovent.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SaveModel(
       @PrimaryKey
       var id: Long,
       @ColumnInfo(name = "title")
       var title: String,
       val cheked: Boolean = false
)