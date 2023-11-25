package com.example.despensa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.despensa.R
import com.example.despensa.Tienda

class TiendaAdapter(private val context: Context, private val tiendas: List<Tienda>) :
    RecyclerView.Adapter<TiendaAdapter.TiendaViewHolder>() {

    // ViewHolder para mantener las referencias a los elementos de la vista de cada elemento de la lista
    class TiendaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.Nombre)
        val direccionTextView: TextView = itemView.findViewById(R.id.Direccion)
        val imagenView: ImageView = itemView.findViewById(R.id.imageView)
    }

    // Infla la vista de cada elemento y devuelve su ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiendaViewHolder {
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.tienda_view, parent, false)
        return TiendaViewHolder(itemView)
    }

    // Asocia los datos a la vista de cada elemento
    override fun onBindViewHolder(holder: TiendaViewHolder, position: Int) {
        val tienda = tiendas[position]

        // Asigna los datos a los elementos de la vista
        holder.nombreTextView.text = tienda.nombre
        holder.direccionTextView.text = tienda.ubicacion
        holder.imagenView.setImageResource(tienda.imagenResId)
    }

    // Devuelve el número total de elementos en el conjunto de datos
    override fun getItemCount(): Int {
        return tiendas.size
    }
}