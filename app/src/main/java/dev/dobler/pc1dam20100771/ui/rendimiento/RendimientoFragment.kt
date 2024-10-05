package dev.dobler.pc1dam20100771.ui.rendimiento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.dobler.pc1dam20100771.R
import dev.dobler.pc1dam20100771.databinding.FragmentRendimientoBinding

class RendimientoFragment : Fragment() {

    private var _binding: FragmentRendimientoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_rendimiento, container, false)
        val etKilometros: EditText = view.findViewById(R.id.etKm)
        val etMinutos: EditText = view.findViewById(R.id.etMin)
        val btnCalcular: Button = view.findViewById(R.id.btnCalcular)
        val resultado: TextView = view.findViewById(R.id.txtRespuesta)
        btnCalcular.setOnClickListener {
            val km: String = etKilometros.text.trim().toString()
            val min: String = etMinutos.text.trim().toString()

            try{
                val num1: Double = km.toDouble()
                val num2: Double = min.toDouble()

                val respuesta = num1/num2

                resultado.text = "$respuesta"

            }catch (e: NumberFormatException){
                e.printStackTrace()
                resultado.text = "Error en los nunmeros ingresados"
            }

        }
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}