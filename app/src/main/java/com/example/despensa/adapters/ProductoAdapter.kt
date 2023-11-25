package com.example.despensa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.despensa.R
import com.example.despensa.Producto

class ProductoListAdapter(
    context: Context,
    resource: Int,
    productos: List<Producto>
) : ArrayAdapter<Producto>(context, resource, productos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val listItemView = convertView ?: inflater.inflate(R.layout.list_item_producto, null)

        // Get the patient data at the current position
        val producto = getItem(position)

        // Bind patient data to TextViews in the custom layout
        val nameTextView = listItemView.findViewById<TextView>(R.id.Nombre)
        val precioTextView = listItemView.findViewById<TextView>(R.id.Precio)
        val tiendaTextView = listItemView.findViewById<TextView>(R.id.Precio)


        // Set the patient data in the TextViews
        nameTextView.text = producto?.nombre
        precioTextView.text = producto?.tienda
        tiendaTextView.text = producto?.precio

        return listItemView
    }
}