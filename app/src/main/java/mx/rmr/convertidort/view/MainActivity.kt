package mx.rmr.convertidort.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import mx.rmr.convertidort.databinding.ActivityMainBinding
import mx.rmr.convertidort.viewmodel.ConvertidorVM

// Controller
class MainActivity : AppCompatActivity()
{
    // Declarar una variable (var), constante (val)
    private lateinit var binding: ActivityMainBinding

    private val convertidorVM: ConvertidorVM by viewModels()

    // referencia al MODELO, YA NO EXISTE ESTA COMUNICACIÓN
    //private val convertidor = Convertidor()

    // El objeto está creado y requiere definir la Vista
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crea los objetos de la GUI
        // Inicializar binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val vista = binding.root
        setContentView(vista)

        configurarEventos()
        // Suscribir
        registrarObservadores()
    }

    private fun registrarObservadores() {
        convertidorVM.gradosF.observe(this, { nuevoValor ->
            binding.etFahrenheit.setText("%.2f".format(nuevoValor))
        })
    }

    private fun configurarEventos() {
        binding.btnConvertir.setOnClickListener {
            val etCelsius = binding.etCelsius
            if (etCelsius.text.toString().isNotEmpty()) {
                val gradosC = etCelsius.text.toString().toInt()
                convertidorVM.convertir(gradosC)
            } else {
                // Avisar
                Toast.makeText(this, "Teclea un valor", Toast.LENGTH_SHORT).show()
                binding.etCelsius.setError("Error!!")

            }
        }
    }
}