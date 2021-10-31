package uz.example.ecovent.screen.calculation

object setExtra {
     var position: String = ""

    fun setExtraPosition(item: String){
        position = item
    }
    fun getExtraPosition(): String{
        return position
    }

}