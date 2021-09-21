package com.oscar.miscompras.ui.view

import android.content.Intent
import android.net.Uri
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

    private lateinit var binding: ActivityDetailBinding

    val SHOP_STORE_URL: String? = ProductsCarrier.oneProduct.permalink

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setTitle("Detalles de Producto")

           ProductsCarrier.oneProduct.let { producto ->

               binding.itemTitle.text = producto.title
               putImage(producto,binding)
               if(producto.price != null)binding.itemPrice.text = "Precio $${producto.price.toString()} "

               binding.itemAtibute.text = buildSpannedString {
                   bold { append("Condición del Producto: ") }
                   if(producto.condition!=null) appendLine(producto.condition)

                   bold { append("Acepta Mercadopago: ") }
                   if( producto.accepts_mercadopago!=null)
                       appendLine(producto.accepts_mercadopago?.toString())

                   bold { append("Vendedor Id: ") }
                   if(producto.seller?.id !=null)appendLine(producto.seller?.id.toString())

                   bold { append("País del Vendedor: ") }
                   if(producto.seller_address?.country?.name!=null)
                        appendLine(producto.seller_address?.country?.name.toString())

                   bold { append("Estado de País: ") }
                   if(producto.seller_address?.state?.name !=null)
                       appendLine(producto.seller_address?.state?.name.toString())

                   bold { append("Ciudad de Ubicación: ") }
                   if(producto.seller_address?.city?.name != null)
                       appendLine(producto.seller_address.city.name.toString())


                   bold { append("Fecha de Registro del Vendedor: ") }
                   if(producto.seller?.registration_date != null)
                       appendLine(producto.seller?.registration_date?.toString())

                   bold { append("Cantidades Vendidas: ") }
                   if(producto.sold_quantity!=null)appendLine(producto.sold_quantity.toString())

                   bold { append("Cantidades Disponibles: ") }
                   if(producto.available_quantity!=null)appendLine(producto.available_quantity.toString())

                   bold { append("Moneda id: ") }
                   if(producto.currency_id!=null)appendLine(producto.currency_id)

               }
           }

        binding.itemButton.setOnClickListener {

            var uri = Uri.parse(SHOP_STORE_URL)
            Log.d("Detail Acitivy","url: ${uri}")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

        }

    }

    private fun putImage(producto: ProductModel, binding: ActivityDetailBinding ){
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