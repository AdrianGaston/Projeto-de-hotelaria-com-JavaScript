
package com.api.projetohotelaria.data;

import com.api.projetohotelaria.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{ 
}
