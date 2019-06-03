package com.example.mygames

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterPartidos internal constructor(context:Context) :
    RecyclerView.Adapter<AdapterPartidos.PartidoViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var partidos = emptyList<Partido>()

    inner class PartidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ViewNameEquipo1: TextView = itemView.findViewById(R.id.EquipoName1) as TextView
        val ViewNameEquipo2: TextView = itemView.findViewById(R.id.EquipoName2) as TextView
        val p3_1: TextView = itemView.findViewById(R.id.puntos_tres_equipo1) as TextView
        val p3_2: TextView = itemView.findViewById(R.id.puntos_tres_equipo2) as TextView
        val p2_1: TextView = itemView.findViewById(R.id.puntos_dos_equipo1) as TextView
        val p2_2: TextView = itemView.findViewById(R.id.puntos_dos_equipo1) as TextView
        val p1_1: TextView = itemView.findViewById(R.id.puntos_uno_equipo1) as TextView
        val p1_2: TextView = itemView.findViewById(R.id.puntos_uno_equipo2) as TextView
        val fecha: TextView = itemView.findViewById(R.id.fechagame) as TextView
        val total1: TextView = itemView.findViewById(R.id.totalEquipo1) as TextView
        val total2: TextView = itemView.findViewById(R.id.totalEquipo2) as TextView
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview, parent, false)
        return PartidoViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        val current = partidos[position]
        holder.ViewNameEquipo1.text = current.nameEquipo1;
        holder.ViewNameEquipo2.text = current.nameEquipo2;
        holder.fecha.text = current.fecha.toString();
        holder.p1_1.text = current.puntos_uno_equipo1.toString();
        holder.p1_2.text = current.puntos_uno_equipo2.toString();
        holder.p2_1.text = current.puntos_dos_equipo1.toString()
        holder.p2_2.text = current.puntos_dos_equipo2.toString()
        holder.p3_1.text = current.puntos_tres_equipo1.toString()
        holder.p3_2.text = current.puntos_tres_equipo2.toString()
        holder.total1.text = current.total_equipo1().toString()
        holder.total2.text = current.total_equipo2().toString()
    }

    internal fun setPartidos(partidos: List<Partido>){
        this.partidos = partidos;
        notifyDataSetChanged();
    }

    override fun getItemCount(): Int {
        return partidos.size;
    }



}