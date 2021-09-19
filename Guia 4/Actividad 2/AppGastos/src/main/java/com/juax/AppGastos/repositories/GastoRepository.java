package com.juax.AppGastos.repositories;

import com.juax.AppGastos.models.GastoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GastoRepository extends CrudRepository<GastoModel, Long> {
    public abstract ArrayList<GastoModel> findByProducto(String producto);


}
