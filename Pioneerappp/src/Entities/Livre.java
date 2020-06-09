/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author FUJITSU
 */
public class Livre {
    private int id;
    private String titrel,filel,audio,nom_image;

    public Livre(int id, String titrel, String filel, String audio, String nom_image) {
        this.id = id;
        this.titrel = titrel;
        this.filel = filel;
        this.audio = audio;
        this.nom_image = nom_image;
    }

    public Livre(String titrel, String filel, String audio, String nom_image) {
        this.titrel = titrel;
        this.filel = filel;
        this.audio = audio;
        this.nom_image = nom_image;
    }

    public Livre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitrel() {
        return titrel;
    }

    public void setTitrel(String titrel) {
        this.titrel = titrel;
    }

    public String getFilel() {
        return filel;
    }

    public void setFilel(String filel) {
        this.filel = filel;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    @Override
    public String toString() {
        return "Livre{" + "id=" + id + ", titrel=" + titrel + ", filel=" + filel + ", audio=" + audio + ", nom_image=" + nom_image + '}';
    }
    
    
    
}
