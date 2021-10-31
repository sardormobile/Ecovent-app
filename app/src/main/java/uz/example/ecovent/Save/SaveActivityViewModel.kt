package uz.example.ecovent.Save

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.example.ecovent.Model.SaveModel
import uz.example.ecovent.data.AppDB
import java.io.FileDescriptor

class SaveActivityViewModel (application: Application): AndroidViewModel(application){
    val mainModel = MutableLiveData<List<SaveModel>>()
    val saveDao = AppDB.getInstance(application).saveDao()

    fun savModel(save: SaveModel){
        GlobalScope.launch {
            saveDao.insertSave((save))
            val newData = saveDao.getAll()
            GlobalScope.launch(Dispatchers.Main) {
                mainModel.value = newData
            }
        }
    }
    fun addSave(save: SaveModel){
        GlobalScope.launch {
            saveDao.insertSave((save))
            val newData = saveDao.getAll()
            GlobalScope.launch(Dispatchers.Main) {
                mainModel.value = newData
            }
        }
    }
    fun updateSave(save: SaveModel){
        GlobalScope.launch {
            saveDao.updateSave((save))
            val newData = saveDao.getAll()
            GlobalScope.launch(Dispatchers.Main) {
                mainModel.value = newData
            }
        }
    }
    fun deleteSave(save: SaveModel){
        GlobalScope.launch {
            saveDao.delet((save))
            val newData = saveDao.getAll()
            GlobalScope.launch(Dispatchers.Main) {
                mainModel.value = newData
            }
        }
    }
    fun getAllSave(){
        GlobalScope.launch {
            val newData = saveDao.getAll()
            GlobalScope.launch(Dispatchers.Main) {
                mainModel.value = newData
            }
        }
    }
}