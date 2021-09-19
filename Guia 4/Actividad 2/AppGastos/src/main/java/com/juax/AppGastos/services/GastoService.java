package com.juax.AppGastos.services;

import com.juax.AppGastos.models.GastoModel;
import com.juax.AppGastos.repositories.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GastoService {
    @Autowired
    GastoRepository gastoRepository;

    public ArrayList<GastoModel> obtenerGastos(){
        return (ArrayList<GastoModel>) gastoRepository.findAll();
    }

    public GastoModel guardarGasto(GastoModel gasto){
        return gastoRepository.save(gasto);
    }

    public Optional<GastoModel> obtenerPorId(Long id){
        return gastoRepository.findById(id);
    }

    public ArrayList<GastoModel> obtenerPorProducto(String producto){
        return gastoRepository.findByProducto(producto);
    }

    public boolean eliminarGasto(Long id){
        try {
            gastoRepository.deleteById(id);
            return true;
        }catch(Exception e){
                return false;
            }
        }
    }

