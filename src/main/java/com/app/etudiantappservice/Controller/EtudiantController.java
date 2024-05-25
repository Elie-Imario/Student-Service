package com.app.etudiantappservice.Controller;

import com.app.etudiantappservice.Beans.Etudiant;
import com.app.etudiantappservice.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService;

    @GetMapping("/etudiants")
    public ResponseEntity<List<Etudiant>> getAllEtudiant(){
        try{
            List<Etudiant> etudiants = new ArrayList<Etudiant>();
            etudiantService.findAllEtudiant().forEach(etudiant -> {
                etudiants.add(etudiant);
            });
            if(etudiants.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(etudiants, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/etudiant")
    public ResponseEntity<?> createEtudiant(@RequestBody Etudiant etudiant){
        try{
            Etudiant newEtudiant = etudiantService.addEtudiant(new Etudiant(
                    etudiant.getMatricule(), etudiant.getNom(), etudiant.getCin(), etudiant.getDateNaiss(), etudiant.getNationnalite(), etudiant.getSexe()
            ));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/etudiants/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable("id") Long id){
        try{
            Etudiant etudiant = etudiantService.findEtudiantById(id);
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/etudiants/{id}")
    public ResponseEntity<?> updateEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant etudiant){
        try{
            Etudiant fetchedEtudiant = etudiantService.findEtudiantById(id);
            fetchedEtudiant.setMatricule(etudiant.getMatricule());
            fetchedEtudiant.setNom(etudiant.getNom());
            fetchedEtudiant.setSexe(etudiant.getSexe());
            fetchedEtudiant.setCin(etudiant.getCin());
            fetchedEtudiant.setNationnalite(etudiant.getNationnalite());
            fetchedEtudiant.setDateNaiss(etudiant.getDateNaiss());

            Etudiant UpdatedEtudiant = etudiantService.updateEtudiant(fetchedEtudiant);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/etudiants/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable("id") Long id){
        try {
            etudiantService.deleteEtudiantById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
