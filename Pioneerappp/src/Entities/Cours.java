/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author FUJITSU
 */
public class Cours {
    private int id;
    private String tuteur,file,titre,livre_id;
    private String date;

    public Cours(int id, String livre_id, String tuteur, String file, String titre, String date) {
        this.id = id;
        this.livre_id = livre_id;
        this.tuteur = tuteur;
        this.file = file;
        this.titre = titre;
        this.date = date;
    }

    public Cours(String livre_id, String tuteur, String file, String titre, String date) {
        this.livre_id = livre_id;
        this.tuteur = tuteur;
        this.file = file;
        this.titre = titre;
        this.date = date;
    }

    public Cours() {
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLivre_id() {
        return livre_id;
    }

    public void setLivre_id(String livre_id) {
        this.livre_id = livre_id;
    }

    public String getTuteur() {
        return tuteur;
    }

    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Cours{" + "id=" + id + ", tuteur=" + tuteur + ", file=" + file + ", titre=" + titre + ", livre_id=" + livre_id + ", date=" + date + '}';
    }

  

   

    
    
    
}
