
package com.api.projetohotelaria.data;

import com.api.projetohotelaria.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Integer> {
}

