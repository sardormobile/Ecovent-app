package uz.example.ecovent.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_valyuta_calculation.*
import uz.example.ecovent.Adapter.ImageAdapter
import uz.example.ecovent.Adapter.ItemAdapterListener
import uz.example.ecovent.Model.ImageModel
import uz.example.ecovent.R

class ValyutaCalculationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_valyuta_calculation)

        btn_valyuta_calculation_activity_back.setOnClickListener {
            finish()
        }
        val arrayHint1 = listOf("Диаметр D", "Длина L")
        val arrayHint2 = listOf("Ширина A", "Высота B", "Длина L")
        val imaList = arrayOf(
                ImageModel(R.drawable.s1, "Воздуховод круглый", arrayHint1,false,true, true, false, false,false,false),
                ImageModel(R.drawable.s2,"Воздуховод прямоугольный", arrayHint2,false,true, true, true, false,false,false),
                ImageModel(R.drawable.s1, "Воздуховод круглый", arrayHint1,false,true, true, false, false,false,false),
                ImageModel(R.drawable.s2,"Воздуховод прямоугольный", arrayHint2,false,true, true, true, false,false,false),
                ImageModel(R.drawable.s1, "Воздуховод круглый", arrayHint1,false,true, true, false, false,false,false),
                ImageModel(R.drawable.s2,"Воздуховод прямоугольный", arrayHint2,false,true, true, true, false,false,false),
        )
                recycler_demo.adapter = ImageAdapter(imaList, object : ItemAdapterListener {
                    override fun onClick(item: ImageModel, onclic_id: ImageModel) {
                        Toast.makeText(this@ValyutaCalculationActivity, item.imageName, Toast.LENGTH_SHORT).show()
                    }
                })
    }
}