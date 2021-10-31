package uz.example.ecovent.screen.save

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.fragment_save.*
import kotlinx.android.synthetic.main.save_item_list.*
import uz.example.ecovent.Adapter.SaveAdapter
import uz.example.ecovent.Model.SaveModel
import uz.example.ecovent.R
import uz.example.ecovent.Save.SaveActivityViewModel
import uz.example.ecovent.screen.MainViewModel

class SaveFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = SaveFragment()
    }
    lateinit var viewModel: SaveActivityViewModel
    lateinit var adapter: SaveAdapter
    var save: SaveModel? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SaveActivityViewModel::class.java)
        adapter = SaveAdapter {
            //save = it

//            tvTitle.setText(it.title, TextView.BufferType.EDITABLE)

           
            Toast.makeText(requireActivity(), it.title, Toast.LENGTH_LONG).show()
        }
        saveRecyclerView.adapter = adapter
        subscribe()
        getAllSave()

        val viewModelSave = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        viewModelSave.put_save_text.observe(requireActivity(), Observer {
            addSave(it)
        })
    }
    fun subscribe(){
        viewModel.mainModel.observe(requireActivity(), Observer {
            val saveListRandom: List<SaveModel>

            adapter.setList(it)
        })
    }
    fun addSave(title: String){
        val save = SaveModel(System.currentTimeMillis(), title)
        viewModel.addSave(save)
    }
    fun delet(save: SaveModel){
        viewModel.deleteSave(save)
    }

    fun updateSave(save: SaveModel){
        viewModel.updateSave(save)
    }
    fun getAllSave(){
        viewModel.getAllSave()
    }
    }
