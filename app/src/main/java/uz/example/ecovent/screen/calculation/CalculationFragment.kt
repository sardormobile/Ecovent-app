package uz.example.ecovent.screen.calculation

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_calculation.*
import kotlinx.android.synthetic.main.fragment_calculation.btCalculat
import kotlinx.android.synthetic.main.fragment_calculation.btDeleted
import kotlinx.android.synthetic.main.fragment_calculation.edText0
import kotlinx.android.synthetic.main.fragment_calculation.edText1
import kotlinx.android.synthetic.main.fragment_calculation.edText2
import kotlinx.android.synthetic.main.fragment_calculation.edText3
import kotlinx.android.synthetic.main.fragment_calculation.edText4
import kotlinx.android.synthetic.main.fragment_calculation.edText5
import kotlinx.android.synthetic.main.fragment_calculation.imageName
import kotlinx.android.synthetic.main.fragment_calculation.imageView
import kotlinx.android.synthetic.main.fragment_calculation.mRB1
import kotlinx.android.synthetic.main.fragment_calculation.mRB2
import kotlinx.android.synthetic.main.fragment_calculation.mRB3
import kotlinx.android.synthetic.main.fragment_calculation.mRB4
import kotlinx.android.synthetic.main.fragment_calculation.mRB5
import kotlinx.android.synthetic.main.fragment_calculation.radioGroup
import kotlinx.android.synthetic.main.fragment_calculation.result
import kotlinx.android.synthetic.main.fragment_calculation.tIn0
import kotlinx.android.synthetic.main.fragment_calculation.tIn1
import kotlinx.android.synthetic.main.fragment_calculation.tIn2
import kotlinx.android.synthetic.main.fragment_calculation.tIn3
import kotlinx.android.synthetic.main.fragment_calculation.tIn4
import kotlinx.android.synthetic.main.fragment_calculation.tIn5
import uz.example.ecovent.Adapter.SaveAdapter
import uz.example.ecovent.Model.ImageModel
import uz.example.ecovent.R
import uz.example.ecovent.Save.SaveActivityViewModel
import uz.example.ecovent.screen.MainViewModel


class CalculationFragment : Fragment(){

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculation, container, false)
    }

    lateinit var saveViewModel: SaveActivityViewModel
    lateinit var saveAdapter: SaveAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)


        // hom fragmentdan data uzatadi

        viewModel.put_image_model.observe(requireActivity(), Observer {
//
                getImageModelPosition(it)

        })

        // hom fragmentdan data uzatiw tugadi

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.mRB1){
                Toast.makeText(requireActivity(), "${mRB1.text}", Toast.LENGTH_SHORT).show()
                mRB1.setTextColor(Color.WHITE)
            }else{
                mRB1.setTextColor(Color.BLACK)
            }
            if(checkedId == R.id.mRB2){
                Toast.makeText(requireActivity(), "${mRB2.text}", Toast.LENGTH_SHORT).show()
                mRB2.setTextColor(Color.WHITE)
            }else{
                mRB2.setTextColor(Color.BLACK)
            }
            if(checkedId == R.id.mRB3){
                Toast.makeText(requireActivity(), "${mRB3.text}", Toast.LENGTH_SHORT).show()
                mRB3.setTextColor(Color.WHITE)
            }else{
                mRB3.setTextColor(Color.BLACK)
            }
            if(checkedId == R.id.mRB4){
                Toast.makeText(requireActivity(), "${mRB4.text}", Toast.LENGTH_SHORT).show()
                mRB4.setTextColor(Color.WHITE)
            }else{
                mRB4.setTextColor(Color.BLACK)
            }
            if(checkedId == R.id.mRB5){
                Toast.makeText(requireActivity(), "${mRB5.text}", Toast.LENGTH_SHORT).show()
                mRB5.setTextColor(Color.WHITE)
            }else{
                mRB5.setTextColor(Color.BLACK)
            }

        }
        mRB2.setTextColor(Color.BLACK)
        mRB3.setTextColor(Color.BLACK)
        mRB4.setTextColor(Color.BLACK)
        mRB5.setTextColor(Color.WHITE)

        btCalculat.setOnClickListener {
            result.setText(edText0.text.toString())
            result.visibility = View.VISIBLE
            btSave.visibility = View.VISIBLE
        }


        btDeleted.setOnClickListener {
            result.setText("")
            result.visibility = View.GONE
            btSave.visibility = View.GONE
            edText0.setText("")
            edText1.setText("")
            edText2.setText("")
            edText3.setText("")
            edText4.setText("")
            edText5.setText("")
        }


        saveAdapter = SaveAdapter {
            Toast.makeText(requireActivity(), it.title, Toast.LENGTH_SHORT).show()
        }

        btSave.setOnClickListener {
            val view = View.inflate(requireActivity(), R.layout.fragment_save_dialog, null)
            val builder = AlertDialog.Builder(requireActivity())
            builder.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)



//            saveAdapter = SaveAdapter {
//                Toast.makeText(requireActivity(), it.title, Toast.LENGTH_SHORT).show()
//            }
//
//
//            saveViewModel.getAllSave()
//            save_dialog_recycler_view.adapter = saveAdapter
//            subscribe()
//            getAllSave()
//
//            saveViewModel.mainModel.observe(requireActivity(), Observer {
//                saveAdapter.setList(it)
//            })

//            saveViewModel.mainModel.observe(requireActivity(), Observer {
//            saveAdapter.setList(it)
//            })
//            save_dialog_recycler_view.adapter = saveAdapter

//            viewModel.savePosition.value = true
//            viewModel.put_save_text.value = edText0.text.toString().plus( edText1.text.toString())
//
//            Toast.makeText(requireActivity(), "Save", Toast.LENGTH_SHORT).show()

        }

        var foo = ""
        var bar: Int = 1
        fun showToast(t: String) {
            Toast.makeText(requireActivity(), t, Toast.LENGTH_SHORT).show()
        }

        btUnit.setOnClickListener {
            val listItems = arrayOf("m", "mm")
            val mBuilder = AlertDialog.Builder(requireActivity())
            mBuilder.setTitle("Dialog")
            mBuilder.setSingleChoiceItems(listItems, bar, DialogInterface.OnClickListener { dialog, which ->
                when(which){
//                    0 -> { btUnit.setText("(m)")
//                        dialog.dismiss()
//                        bar = 0}
//                    1 -> { btUnit.setText("(mm)")
//                        dialog.dismiss()
//                        bar = 1}
                }
                foo = listItems[which]
                showToast(foo)
            }).show()
        }


    }
    fun subscribe(){
        saveViewModel.mainModel.observe(requireActivity(), Observer {

            saveAdapter.setList(it)
        })
    }
    fun getAllSave(){
        saveViewModel.getAllSave()
    }
    fun getImageModelPosition(it: ImageModel)
    {
        imageView.setImageResource(it.image)
        imageName.setText(it.imageName)

        tIn0.visibility = View.GONE
        tIn1.visibility = View.GONE
        tIn2.visibility = View.GONE
        tIn3.visibility = View.GONE
        tIn4.visibility = View.GONE
        tIn5.visibility = View.GONE
        linerLayoutVisblty.visibility = View.GONE
        radioGroup.visibility = View.GONE

        if (it.edText0){// 3
            tIn0.visibility = View.VISIBLE
            tIn0.hint = it.edTHint[0]
            if (it.degree)
                radioGroup.visibility = View.VISIBLE

        }
        if (it.edText1){ // 1
            tIn1.visibility = View.VISIBLE
            tIn1.hint = it.edTHint[1]
            if (it.degree)
                radioGroup.visibility = View.VISIBLE
        }
        if (it.edText2){// 2
            tIn2.visibility = View.VISIBLE
            tIn2.hint = it.edTHint[2]

        }
        if (it.edText3){// 6
            tIn3.visibility = View.VISIBLE
            tIn3.hint = it.edTHint[3]

        }
        if (it.edText4){// 7
            linerLayoutVisblty.visibility = View.VISIBLE
            tIn4.visibility = View.VISIBLE
            tIn4.hint = it.edTHint[4]

        }
        if (it.edText5){// 11
            tIn5.visibility = View.VISIBLE
            tIn5.hint = it.edTHint[5]

        }
    }
    companion object {

        @JvmStatic
        fun newInstance() = CalculationFragment()
    }
}