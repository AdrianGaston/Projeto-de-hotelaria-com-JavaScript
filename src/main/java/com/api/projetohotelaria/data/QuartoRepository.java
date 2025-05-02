
package com.api.projetohotelaria.data;

import com.api.projetohotelaria.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
}

