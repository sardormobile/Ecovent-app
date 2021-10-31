package uz.example.ecovent.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_calculator.view.*
import kotlinx.android.synthetic.main.save_item_list.view.*
import uz.example.ecovent.Model.SaveModel
import uz.example.ecovent.R

class SaveAdapter(val onClick: (save: SaveModel)-> Unit): RecyclerView.Adapter<SaveAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(save: SaveModel){
            itemView.tvTitle.text = save.title
            itemView.setOnClickListener {
                onClick(save)
                //notifyDataSetChanged()

            }
        }
    }

    val list = mutableListOf<SaveModel>()
    fun setList(newList: List<SaveModel>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.save_item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
//        holder.itemView.btSave.setOnClickListener {
//            notifyDataSetChanged()
//        }


    }

    override fun getItemCount() = list.size

}