package uz.example.ecovent.Save

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_save.*
import kotlinx.android.synthetic.main.fragment_save.*
import kotlinx.android.synthetic.main.save_item_list.*
import uz.example.ecovent.Adapter.SaveAdapter
import uz.example.ecovent.Model.SaveModel
import uz.example.ecovent.R

class SaveActivity : AppCompatActivity() {

    lateinit var viewModel: SaveActivityViewModel
    lateinit var adapter: SaveAdapter
    var save: SaveModel? = null
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

//     viewModel = ViewModelProvider(this).get(SaveActivityViewModel::class.java)
//     adapter = SaveAdapter {
//         save = it
//         tvTitle.setText(it.title, TextView.BufferType.EDITABLE)
//     }
//     saveRecyclerView.adapter = adapter
//     subscribe()
//     getAllSave()
//
//        // edText0.setText("", TextView.BufferType.EDITABLE)
    }
//    fun subscribe(){
//        viewModel.mainModel.observe(this, Observer {
//            adapter.setList(it)
//        })
//    }
//    fun addSave(title: String){
//        val save = SaveModel(System.currentTimeMillis(), title)
//        viewModel.addSave(save)
//    }
//    fun delet(save: SaveModel){
//        viewModel.deleteSave(save)
//    }
//
//    fun updateSave(save: SaveModel){
//        viewModel.updateSave(save)
//    }
//    fun getAllSave(){
//        viewModel.getAllSave()
//    }


}