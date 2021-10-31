package uz.example.ecovent.utils

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_calculator.*
import uz.example.ecovent.Model.ImageModel
import uz.example.ecovent.Model.SaveModel
import uz.example.ecovent.R
import uz.example.ecovent.Save.SaveActivity
import uz.example.ecovent.Save.SaveActivityViewModel

class CalculatorActivity : AppCompatActivity() {
lateinit var user: ImageModel
lateinit var viewModel: SaveActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        user = intent.getSerializableExtra("extra_item") as ImageModel
        val position_id = intent.getIntExtra("extra_onclick_id", 0)
        viewModel = ViewModelProvider(this).get(SaveActivityViewModel::class.java)

//        backspace_calculator_activty.setOnClickListener {
//            finish()
//        }
//        imageView.setImageResource(user.image)
//        imageName.text = user.imageName

//        if (user.edText0){// 3
//            tIn0.visibility = View.VISIBLE
//            tIn0.hint = user.edTHint[0]
//            if (user.degree)
//                radioGroup.visibility = View.VISIBLE
//
//        }
//        if (user.edText1){ // 1
//            tIn1.visibility = View.VISIBLE
//            tIn1.hint = user.edTHint[1]
//            if (user.degree)
//                radioGroup.visibility = View.VISIBLE
//        }
//        if (user.edText2){// 2
//            tIn2.visibility = View.VISIBLE
//            tIn2.hint = user.edTHint[2]
//
//        }
//        if (user.edText3){// 6
//            tIn3.visibility = View.VISIBLE
//            tIn3.hint = user.edTHint[3]
//
//        }
//        if (user.edText4){// 7
//            tIn4.visibility = View.VISIBLE
//            tIn4.hint = user.edTHint[4]
//
//        }
//        if (user.edText5){// 11
//            tIn5.visibility = View.VISIBLE
//            tIn5.hint = user.edTHint[5]
//
//        }
//
//        radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            if(checkedId == R.id.mRB1){
//                Toast.makeText(this, "${mRB1.text}", Toast.LENGTH_SHORT).show()
//                mRB1.setTextColor(Color.WHITE)
//            }else{
//                mRB1.setTextColor(Color.BLACK)
//            }
//            if(checkedId == R.id.mRB2){
//                Toast.makeText(this, "${mRB2.text}", Toast.LENGTH_SHORT).show()
//                mRB2.setTextColor(Color.WHITE)
//            }else{
//                mRB2.setTextColor(Color.BLACK)
//            }
//            if(checkedId == R.id.mRB3){
//                Toast.makeText(this, "${mRB3.text}", Toast.LENGTH_SHORT).show()
//                mRB3.setTextColor(Color.WHITE)
//            }else{
//                mRB3.setTextColor(Color.BLACK)
//            }
//            if(checkedId == R.id.mRB4){
//                Toast.makeText(this, "${mRB4.text}", Toast.LENGTH_SHORT).show()
//                mRB4.setTextColor(Color.WHITE)
//            }else{
//                mRB4.setTextColor(Color.BLACK)
//            }
//            if(checkedId == R.id.mRB5){
//                Toast.makeText(this, "${mRB5.text}", Toast.LENGTH_SHORT).show()
//                mRB5.setTextColor(Color.WHITE)
//            }else{
//                mRB5.setTextColor(Color.BLACK)
//            }
//
//        }
//        mRB2.setTextColor(Color.BLACK)
//        mRB3.setTextColor(Color.BLACK)
//        mRB4.setTextColor(Color.BLACK)
//        mRB5.setTextColor(Color.WHITE)
//
//           btCalculat.setOnClickListener {
//               for (i in 0..20)
//                   when (position_id) {
//                       i -> {
//                           result.visibility = View.VISIBLE
//                           result.setText(get_calculat1())
//
//                           Toast.makeText (this, get_calculat1(), Toast.LENGTH_LONG).show()
//                       }
//                   }
//
//        }
//
//
//        btDeleted.setOnClickListener {
//            result.setText("")
//            result.visibility = View.GONE
//            edText0.setText("")
//            edText1.setText("")
//            edText2.setText("")
//            edText3.setText("")
//            edText4.setText("")
//            edText5.setText("")
//        }

//        val save_base = edText0.text.toString().plus( edText1.text.toString())
//        val save_base2 = edText0.text.toString()
//
//        btSave.setOnClickListener {
//            addSave( edText0.text.toString().plus( edText1.text.toString()) )
//            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
//
//        }
//
//        var foo = ""
//        var bar: Int = 1
//        fun showToast(t: String) {
//            Toast.makeText(this, t, Toast.LENGTH_SHORT).show()
//        }
//
//        btUnit.setOnClickListener {
//            val listItems = arrayOf("m", "mm")
//            val mBuilder = AlertDialog.Builder(this)
//            mBuilder.setTitle("Dialog")
//            mBuilder.setSingleChoiceItems(listItems, bar, DialogInterface.OnClickListener { dialog, which ->
//                when(which){
//                    0 -> { btUnit.setText("(m)")
//                        dialog.dismiss()
//                        bar = 0}
//                    1 -> { btUnit.setText("(mm)")
//                        dialog.dismiss()
//                        bar = 1}
//                }
//                foo = listItems[which]
//                showToast(foo)
//            }).show()
//        }

    }
//
//    fun get_calculat1(): String{
//        val get_data: String = edText0.text.toString().plus("mm")
//        return get_data
//    }
//    fun addSave(title: String){
//        val save = SaveModel(System.currentTimeMillis(), title)
//        viewModel.addSave(save)
//    }
//    fun delet(save: SaveModel){
//        viewModel.deleteSave(save)
//    }


}