package uz.example.ecovent.screen

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.example.ecovent.Model.ImageModel
import uz.example.ecovent.repository.EcovenRepository
import uz.example.ecovent.screen.home.HomeFragment

class MainViewModel: ViewModel(){

//    val list = MutableLiveData<Array<ImageModel>>()
    val calculationPosition = MutableLiveData<Boolean>()
    val imageModelDemo = MutableLiveData<Array<ImageModel>>()
    val put_image_model = MutableLiveData<ImageModel>()
    val put_save_text = MutableLiveData<String>()

    val savePosition = MutableLiveData<Boolean>()

}