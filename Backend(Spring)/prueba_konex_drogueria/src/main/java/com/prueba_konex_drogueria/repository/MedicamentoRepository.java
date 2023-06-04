package com.prueba_konex_drogueria.repository;

import com.prueba_konex_drogueria.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    Optional<Medicamento> findByNombreAndLaboratorio(String name, String laboratory);


}
