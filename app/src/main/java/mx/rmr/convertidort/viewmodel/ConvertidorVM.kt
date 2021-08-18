package mx.rmr.convertidort.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.rmr.convertidort.model.Convertidor

// ViewModel
class ConvertidorVM: ViewModel()
{
    // Modelo
    val convertidor = Convertidor()

    // Variables que representan el estado de la app
    val gradosF = MutableLiveData<Double>()

    // Funciones para cambiar el estado de la app
    fun convertir(gradosC: Int) {
        gradosF.value = convertidor.convertir(gradosC.toDouble())     // llamar al 'modelo'
    }
}