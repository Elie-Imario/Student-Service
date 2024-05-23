package com.app.etudiantappservice.Beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "Etudiant")
@Getter @Setter @NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_etudiant_key_generator")
    @TableGenerator(name = "id_etudiant_key_generator",
            table = "pk_etudiant",
            pkColumnName = "name",
            valueColumnName = "value",
            allocationSize = 1)
    @Column(name = "etudiant_id")
    private Long etudiantId;
    private String matricule;
    private String nom;
    private String cin;
    private Timestamp dateNaiss;
    private String sexe;
    private String nationnalite;

    public Etudiant(String matricule, String nom, String cin, Timestamp dateNaiss, String sexe, String nationnalite) {
        this.matricule = matricule;
        this.nom = nom;
        this.cin = cin;
        this.dateNaiss = dateNaiss;
        this.sexe = sexe;
        this.nationnalite = nationnalite;
    }
}
