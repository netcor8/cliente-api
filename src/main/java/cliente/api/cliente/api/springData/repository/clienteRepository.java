package cliente.api.cliente.api.springData.repository;

import cliente.api.cliente.api.springData.model.cliente;


import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface clienteRepository extends JpaRepository<cliente, Integer>, JpaSpecificationExecutor<cliente> {

  //  List<cliente> findByCedula(String cedula);

    cliente findClientesByEstado(int id);




}
