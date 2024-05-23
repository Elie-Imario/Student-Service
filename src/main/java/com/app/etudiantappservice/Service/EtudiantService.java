package com.app.etudiantappservice.Service;

import com.app.etudiantappservice.Beans.Etudiant;
import com.app.etudiantappservice.Repository.EtudiantRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EtudiantService {
    @Autowired
    EtudiantRepositoryInterface etudiantRepository;

    public Iterable<Etudiant> findAllEtudiant(){
        return etudiantRepository.findAll();
    }

    public Etudiant findEtudiantById(Long id){
        return etudiantRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Etudiant addEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }
    public void deleteEtudiantById(Long etudiantId){
        etudiantRepository.deleteById(etudiantId);
    }
}
