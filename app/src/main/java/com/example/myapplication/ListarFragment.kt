package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.model.Equipe
import com.example.myapplication.repository.EquipeRepository

class ListarFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<Equipe>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listar, container, false)
        listView = view.findViewById(R.id.list_view_equipes)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = object : ArrayAdapter<Equipe>(requireContext(), R.layout.item_equipe, EquipeRepository.equipes) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_equipe, parent, false)
                val equipe = getItem(position)

                val nomeEquipeTextView = view.findViewById<TextView>(R.id.tv_nome_equipe)
                val piloto1TextView = view.findViewById<TextView>(R.id.tv_piloto1)
                val piloto2TextView = view.findViewById<TextView>(R.id.tv_piloto2)
                val editButton = view.findViewById<ImageButton>(R.id.edit_button)
                val deleteButton = view.findViewById<ImageButton>(R.id.delete_button)


                nomeEquipeTextView.text = equipe?.nomeEquipe
                piloto1TextView.text =  "${equipe?.piloto1} (#${equipe?.numeroPiloto1})" // Display pilot number
                piloto2TextView.text =  "${equipe?.piloto2} (#${equipe?.numeroPiloto2})" // Display pilot number



                deleteButton.setOnClickListener{
                    EquipeRepository.equipes.remove(equipe)
                    notifyDataSetChanged()
                }
                return view
            }
        }
        listView.adapter = adapter

    }

}