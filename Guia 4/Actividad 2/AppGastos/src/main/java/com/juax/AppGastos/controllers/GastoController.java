package com.juax.AppGastos.controllers;

import com.juax.AppGastos.models.GastoModel;
import com.juax.AppGastos.services.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/gastos")
public class GastoController {
    @Autowired
    GastoService gastoService;

    @GetMapping()
    public ArrayList<GastoModel> obtenerGastos(){
        return gastoService.obtenerGastos();
    }

    @PostMapping()
    public GastoModel guardarUsuario(@RequestBody GastoModel gasto){
        return this.gastoService.guardarGasto(gasto);
    }

    @GetMapping(path = "/{id}")
    public Optional<GastoModel> obtenerProductoPorId(@PathVariable("id") Long id){
        return this.gastoService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<GastoModel> obtenerProducto(@RequestParam("producto") String producto){
        return this.gastoService.obtenerPorProducto(producto);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.gastoService.eliminarGasto(id);
        if (ok){
            return "Se eliminó el usuario con id " +id;
        } else {
            return "No pudo eliminar el usuario con id " +id;
        }
    }
}
