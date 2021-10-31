package uz.example.ecovent.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.image_item_layout.view.*
import uz.example.ecovent.Model.ImageModel
import uz.example.ecovent.R
import uz.example.ecovent.screen.calculation.setExtra

interface ItemAdapterListener{
    fun onClick(item: ImageModel, onclic_id: ImageModel)
}
var canculat_onclic_position: Boolean = false
class ImageAdapter(val items:Array<ImageModel>, val itemAdapterListemer: ItemAdapterListener): RecyclerView.Adapter<ImageAdapter.ItemHolder>(){
    inner class ItemHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.imageView.setImageResource(item.image)
        holder.itemView.setOnClickListener {
            itemAdapterListemer.onClick(item, items[0])
            notifyDataSetChanged()


        }
    }



    override fun getItemCount(): Int {
        return items.count()
    }
}