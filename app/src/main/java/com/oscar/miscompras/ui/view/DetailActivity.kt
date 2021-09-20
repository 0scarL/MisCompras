package com.oscar.miscompras.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.example.miscompras.model.Attribute
import com.example.miscompras.model.ProductModel
import com.oscar.miscompras.databinding.ActivityDetailBinding
import com.oscar.miscompras.utils.OtherFunctions
import com.oscar.miscompras.utils.ProductsCarrier
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    companion object{

    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setTitle(ProductsCarrier.oneProduct.title)


           ProductsCarrier.oneProduct.let { producto ->

               binding.itemTitle.text = producto.title
               putImage(producto,binding)
               if(producto.price != null)binding.itemPrice.text = "Price $${producto.price.toString()} "

               binding.itemAtibute.text = buildSpannedString {
                   bold { append("Condición: ") }
                   if(producto.condition!=null) appendLine(producto.condition)

                   bold { append("Accepts Mercadopago: ") }
                   if( producto.accepts_mercadopago!=null)
                       appendLine(producto.accepts_mercadopago?.toString())

                   bold { append("Seller Country: ") }
                   if(producto.seller_address?.country?.name!=null)
                        appendLine(producto.seller_address?.country?.name.toString())

                   bold { append("Ubication State: ") }
                   if(producto.seller_address?.state?.name !=null)
                       appendLine(producto.seller_address?.state?.name.toString())


                   bold { append("Ubication City: ") }
                   if(producto.seller_address?.city?.name != null)
                       appendLine(producto.seller_address.city.name.toString())


                   bold { append("Seller Regitration Date: ") }
                   if(producto.seller?.registration_date != null)
                       appendLine(producto.seller?.registration_date?.toString())

                   bold { append("Sold quantity.: ") }
                   if(producto.sold_quantity!=null)appendLine(producto.sold_quantity.toString())

                   bold { append("Available quantity: ") }
                   if(producto.available_quantity!=null)appendLine(producto.available_quantity.toString())

                   bold { append("Currency id: ") }
                   if(producto.currency_id!=null)appendLine(producto.currency_id)

               }
           }


    }

    private fun putImage(producto: ProductModel, binding: ActivityDetailBinding, ){
        var linkImage = producto.thumbnail
        if (linkImage != null) {
            linkImage = OtherFunctions.getPicLink(linkImage)
        } else {
            Log.d("ProductoAdapter", "El Campo Thumbnail es null")
        }
        Picasso.get()
            .load(linkImage)
            .resize(360, 320)
            .centerInside()
            .into(this.binding.itemImage)
    }

}