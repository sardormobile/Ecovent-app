package uz.example.ecovent.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.example.ecovent.Model.SaveModel

@Database(entities = arrayOf(SaveModel::class), version = 1)
abstract class AppDB: RoomDatabase(){
    abstract fun saveDao(): DataServic

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null

        fun getInstance(context: Context): AppDB{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        "save_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
                }
            }
        }


}