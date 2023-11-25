package com.example.despensa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.despensa.R

class TarjetaAdapter(private val tarjetas: List<Tarjeta>) :
    RecyclerView.Adapter<TarjetaAdapter.TarjetaViewHolder>() {

    class TarjetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        val numeroTextView: TextView = itemView.findViewById(R.id.numeroTextView)
        val bancoTextView: TextView = itemView.findViewById(R.id.bancoTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjetaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarjeta, parent, false)
        return TarjetaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TarjetaViewHolder, position: Int) {
        val tarjeta = tarjetas[position]
        holder.nombreTextView.text = "Nombre: ${tarjeta.nombre}"
        holder.numeroTextView.text = "Número: ${tarjeta.numero}"
        holder.bancoTextView.text = "Banco: ${tarjeta.banco}"
    }

    override fun getItemCount(): Int {
        return tarjetas.size
    }
}
