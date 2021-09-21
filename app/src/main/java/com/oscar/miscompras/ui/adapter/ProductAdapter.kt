package com.oscar.miscompras.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.databinding.ProductoItemLayoutBinding
import com.oscar.miscompras.utils.OtherFunctions
import com.squareup.picasso.Picasso
import kotlin.properties.Delegates

class ProductoAdapter(

    private var productoClickedListener: (ProductModel) -> Unit
) : RecyclerView.Adapter<ProductoAdapter.ProductoVH>() {

    var producto: List<ProductModel> by Delegates.observable(emptyList()) { _, old, new ->
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = old.size

            override fun getNewListSize(): Int = new.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = old[oldItemPosition]
                val newItem = new[newItemPosition]
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                old[oldItemPosition] == new[newItemPosition]

        }).dispatchUpdatesTo(this)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoVH {
        val binding = ProductoItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductoVH(binding)
    }

    override fun onBindViewHolder(holder: ProductoVH, position: Int) {
        val producto = producto[position]
        holder.bind(producto)
        holder.itemView.setOnClickListener { productoClickedListener(producto) }
    }

    override fun getItemCount() = this.producto.size

    class ProductoVH(private val binding: ProductoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(producto: ProductModel) {
            binding.itemTitle.text = producto.title

            putImage(producto,binding)

            binding.itemAtibute.text = buildSpannedString {

                bold { append("Cantidad disponible: ") }
                if(producto.available_quantity!=null)
                    appendLine(producto.available_quantity.toString())

                bold { append("Acepta Mercadopago: ") }
                if( producto.accepts_mercadopago!=null)
                    appendLine(producto.accepts_mercadopago?.toString())
            }

            if(producto.price != null)binding.itemPrice.text = "Precio $${producto.price.toString()} "

            if(producto.condition != null)binding.itemCondition.text = " ${producto.condition} "

        }


    }

}

private fun putImage(producto: ProductModel, binding: ProductoItemLayoutBinding){
    var linkImage = producto.thumbnail
    /**cambiamos a protocolo https, para poder ver las imagenes**/
    if (linkImage != null) {
        linkImage = OtherFunctions.getThumbLink(linkImage)
    } else {
        Log.d("ProductoAdapter", "El Campo Thumbnail es null")
    }
    Picasso.get()
        .load(linkImage)
        .resize(280, 260)
        .centerInside()
        .into(binding.itemImage)
}

