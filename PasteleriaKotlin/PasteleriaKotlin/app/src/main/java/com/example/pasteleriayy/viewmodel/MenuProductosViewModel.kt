package com.example.pasteleriayy.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pasteleriayy.data.ProductosDataSource

class MenuProductosViewModel : ViewModel() {
    val productos = ProductosDataSource.getListaProductos()
}
