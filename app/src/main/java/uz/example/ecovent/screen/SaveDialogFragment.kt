package uz.example.ecovent.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_save_dialog.*
import kotlinx.android.synthetic.main.show_save_dialog_layout.*
import uz.example.ecovent.Adapter.ImageAdapter
import uz.example.ecovent.Adapter.ItemAdapterListener
import uz.example.ecovent.Adapter.SaveAdapter
import uz.example.ecovent.Model.ImageModel
import uz.example.ecovent.R
import uz.example.ecovent.Save.SaveActivityViewModel

class SaveDialogFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save_dialog, container, false)
    }

    companion object {


        @JvmStatic
        fun newInstance() = SaveDialogFragment()
    }
    lateinit var saveViewModel: SaveActivityViewModel
    lateinit var saveAdapter: SaveAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_dialog_recycler_view.layoutManager = GridLayoutManager(requireActivity(), 1)

        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        saveAdapter = SaveAdapter {
            Toast.makeText(requireActivity(), it.title, Toast.LENGTH_SHORT).show()
        }


        saveViewModel.getAllSave()
        save_dialog_recycler_view.adapter = saveAdapter
        subscribe()
        getAllSave()

        saveViewModel.mainModel.observe(requireActivity(), Observer {
            saveAdapter.setList(it)
        })

                viewModel.imageModelDemo.observe(requireActivity(), Observer {
                    Toast.makeText(requireActivity(), "$$$", Toast.LENGTH_SHORT).show()
                })
    }
    fun subscribe(){
        saveViewModel.mainModel.observe(requireActivity(), Observer {

            saveAdapter.setList(it)
        })
    }
    fun getAllSave(){
        saveViewModel.getAllSave()
    }
}