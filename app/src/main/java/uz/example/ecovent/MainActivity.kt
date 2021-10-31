package uz.example.ecovent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import uz.example.ecovent.screen.MainViewModel
import uz.example.ecovent.screen.ValyutaCalculationActivity
import uz.example.ecovent.screen.calculation.CalculationFragment
import uz.example.ecovent.screen.home.HomeFragment
import uz.example.ecovent.screen.satting.SettingFragment
import uz.example.ecovent.screen.save.SaveFragment

class MainActivity : AppCompatActivity(){
//    lateinit var viewModel: MainViewModel
    val homFragment = HomeFragment.newInstance()
    val calculationFragment = CalculationFragment.newInstance()
    val saveFragment = SaveFragment.newInstance()
    val settingFragment = SettingFragment.newInstance()
    var activeFragment: Fragment = homFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.flContainer, homFragment, homFragment.tag).hide(homFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer, calculationFragment, calculationFragment.tag).hide(calculationFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer, saveFragment, saveFragment.tag).hide(saveFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer, settingFragment, settingFragment.tag).hide(settingFragment).commit()
        supportFragmentManager.beginTransaction().show(activeFragment).commit()
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        bottomBar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.actionHome -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(homFragment).commit()
                    activeFragment = homFragment
                    getTitleFragmentText("1$ = 10 534.20 UZS", true)

                }
                R.id.actionCalculation -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(calculationFragment).commit()
                    activeFragment = calculationFragment
                    getTitleFragmentText("Calculation", false)
                }
                R.id.actionSave -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(saveFragment).commit()
                    activeFragment = saveFragment
                    getTitleFragmentText(getString(R.string.obiekt), false)
                }
                R.id.actionSetting -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(settingFragment).commit()
                    activeFragment =  settingFragment
                    getTitleFragmentText("Setting", false)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        // Hom fragmentdan Calculation fragment ochilishi
        viewModel.calculationPosition.observe(this, Observer {

            bottomBar.selectedItemId = R.id.actionCalculation


        })
        viewModel.savePosition.observe(this, Observer {

                bottomBar.selectedItemId = R.id.actionSave
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()

        })
        card_fragment_and_data_table_text_onclick.setOnClickListener {
            if (tv_vlyuta_data.visibility == View.VISIBLE){
                startActivity(Intent(this, ValyutaCalculationActivity::class.java))
            }
        }

    }
    fun getTitleFragmentText(title: String, valyuta_data_visblity: Boolean){
        tv_valyuta_and_fragment_name.setText(title)

        if (valyuta_data_visblity){
            tv_vlyuta_data.visibility = View.VISIBLE
            tv_vlyuta_data.setText("11.08.2021  8:50")
        }else{
            tv_vlyuta_data.visibility = View.GONE
        }
    }


}


//, RecyclerView.VERTICAL, false).apply {
//    recyclerView.layoutManager = this
//}