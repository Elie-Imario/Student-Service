package com.app.etudiantappservice.Repository;

import com.app.etudiantappservice.Beans.Etudiant;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepositoryInterface extends CrudRepository<Etudiant, Long> {
    Iterable<Etudiant> findAll(Sort etudiantId);
}
