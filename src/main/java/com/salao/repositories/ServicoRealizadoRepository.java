package com.salao.repositories;

import com.salao.entity.ServicoRealizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRealizadoRepository extends JpaRepository<ServicoRealizado, Long> {
}
