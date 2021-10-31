package uz.example.ecovent.screen.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_calculation.*
import kotlinx.android.synthetic.main.fragment_home.*
import uz.example.ecovent.Adapter.ImageAdapter
import uz.example.ecovent.Adapter.ItemAdapterListener
import uz.example.ecovent.Model.ImageModel
import uz.example.ecovent.R
import uz.example.ecovent.screen.MainViewModel

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = GridLayoutManager(requireContext(),  2)




        val arrayHint1 = listOf("Диаметр D", "Длина L")
        val arrayHint2 = listOf("Ширина A", "Высота B", "Длина L")
        val arrayHint3 = listOf("Диаметр D")
        val arrayHint4 = listOf("Ширина A", "Высота B")
        val arrayHint5 = listOf("Диаметр D1", "Диаметр D2", "Длина L")
        val arrayHint6 = listOf("Ширина A", "Высота B", "Диаметр D", "Длина L")
        val arrayHint7 = listOf("Ширина A", "Высота B", "Ширина a", "Высота b", "Длина L")
        val arrayHint8 = listOf("Диаметр D1", "Длина L", "Диаметр D2", "Длина l")
        val arrayHint9 = listOf("Диаметр D", "Длина L", "Ширина A", "Высота b", "Длина l")
        val arrayHint10 = listOf("Ширина A", "Высота B", "Длина L", "Диаметр D", "Длина l")
        val arrayHint11 = listOf("Ширина A", "Высота B", "Длина L", "Ширина a", "Высота b", "Длина l")
        val arrayHint12 = listOf("Диаметр D")
        val arrayHint13 = listOf("Ширина A", "Высота B")
        val arrayHint14 = listOf("Ширина A", "Высота B", "Длина L", "Смещение h")
        val arrayHint15 = listOf("Ширина A", "Высота B", "Длина L", "Смещение h1", "Смещение h2")
        val arrayHint16 = listOf("Длина A", "Ширина B", "Длина a", "Ширина b", "Высота H")
        val arrayHint17 = listOf("Длина A", "Ширина B", "Высота H", "Полка c")
        val arrayHint18 = listOf("Диаметр D")
        val arrayHint19 = listOf("Основание A")
        val arrayHint20 = listOf("Основание a", "Основание b")
        val arrayHint21 = listOf("Диаметр d")

        val imaList = arrayOf(
                ImageModel(R.drawable.s1, "Воздуховод круглый", arrayHint1,false,true, true, false, false,false,false),
                ImageModel(R.drawable.s2,"Воздуховод прямоугольный", arrayHint2,false,true, true, true, false,false,false),
                ImageModel(R.drawable.s3,"Отвод круглый", arrayHint3,true, true, false, false, false,false,false),
                ImageModel(R.drawable.s4,"Отвод прямоугольный", arrayHint4,true, true, true, false, false,false,false),
                ImageModel(R.drawable.s5,"Переход круглый", arrayHint5,false,true, true, true, false,false,false),
                ImageModel(R.drawable.s6,"Переход прямоугольный на круглый", arrayHint6,false,true, true, true, true,false,false),
                ImageModel(R.drawable.s7,"Переход прямоугольный", arrayHint7,false,true, true, true, true, true,false),
                ImageModel(R.drawable.s8,"Тройник круглый", arrayHint8,false,true, true, true, true,false,false),
                ImageModel(R.drawable.s9,"Тройник круглый на прямоугольный", arrayHint9,false,true, true, true, true, true,false),
                ImageModel(R.drawable.s10,"Тройник прямоугольный на круглый", arrayHint10,false,true, true, true, true, true,false),
                ImageModel(R.drawable.s11,"Тройник прямоугольный", arrayHint11,false,true, true, true, true,true,true),
                ImageModel(R.drawable.s12,"Заглушка круглый", arrayHint12,false,true, false, false, false,false,false),
                ImageModel(R.drawable.s13,"Заглушка прямоугольный", arrayHint13,false,true, true, false, false,false,false),
                ImageModel(R.drawable.s14,"Утка со смещением в 1-ой плоскости", arrayHint14,false,true, true, true, true,false,false),
                ImageModel(R.drawable.s15,"Утка со смещением в 2-х плоскостях", arrayHint15,false,true, true, true, true,true,false),
                ImageModel(R.drawable.s16,"Зонт островной", arrayHint16,false,true, true, true, true,true,false),
                ImageModel(R.drawable.s17,"Зонт пристенный", arrayHint17,false,true, true, true, true,false,false),
                ImageModel(R.drawable.s18,"Зонт круглый", arrayHint18,false,true, false, false, false,false,false),
                ImageModel(R.drawable.s19,"Зонт квадратный", arrayHint19,false,true, false, false, false,false,false),
                ImageModel(R.drawable.s20,"Зонт прямоугольный", arrayHint20,false,true, true, false, false,false,false),
                ImageModel(R.drawable.s21,"Дефлектор", arrayHint21,false,true, false, false, false,false,false)
        )
        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        recyclerView.adapter = ImageAdapter(imaList, object : ItemAdapterListener {
            override fun onClick(item: ImageModel, onclic_id: ImageModel) {
                viewModel.calculationPosition.value = true
                viewModel.put_image_model.value = item

            }

        })
        viewModel.put_image_model.value = imaList[0]
        viewModel.imageModelDemo.value = imaList
    }
    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}