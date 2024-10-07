package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.repository.EquipeRepository
import com.example.myapplication.model.Equipe


class HelmetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_helmet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nomeEquipeEditText = view.findViewById<EditText>(R.id.et_nome_equipe)
        val nomePiloto1EditText = view.findViewById<EditText>(R.id.et_nome_piloto1)
        val nomenumeroPiloto1EditText = view.findViewById<EditText>(R.id.et_nome_numeroPiloto1)
        val nomePiloto2EditText = view.findViewById<EditText>(R.id.et_nome_piloto2)
        val nomenumeroPiloto2EditText = view.findViewById<EditText>(R.id.et_nome_numeroPiloto2)

        val salvarButton = view.findViewById<Button>(R.id.btn_salvar_equipe)

        salvarButton.setOnClickListener {
            val nomeEquipe = nomeEquipeEditText.text.toString()
            val nomePiloto1 = nomePiloto1EditText.text.toString()
            val nomeNumeroPiloto1 = nomenumeroPiloto1EditText.text.toString()
            val nomePiloto2 = nomePiloto2EditText.text.toString()
            val nomeNumeroPiloto2 = nomenumeroPiloto2EditText.text.toString()

            if (nomeEquipe.isNotEmpty() && nomePiloto1.isNotEmpty() && nomePiloto2.isNotEmpty()) {
                salvarEquipe(nomeEquipe, nomePiloto1, nomeNumeroPiloto1, nomePiloto2, nomeNumeroPiloto2)
            } else {
                Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun salvarEquipe(nomeEquipe: String, nomePiloto1: String, nomeNumeroPiloto1: String, nomePiloto2: String, nomeNumeroPiloto2: String) {
        val novaEquipe = Equipe(nomeEquipe, nomePiloto1, nomeNumeroPiloto1, nomePiloto2, nomeNumeroPiloto2)
        EquipeRepository.equipes.add(novaEquipe)
        Toast.makeText(context, "Equipe $nomeEquipe salva!", Toast.LENGTH_SHORT).show()
    }
}
