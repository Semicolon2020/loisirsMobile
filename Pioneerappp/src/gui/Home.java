/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 *
 * @author FUJITSU
 */
public class Home extends Form {
Form current;
    public Home()  {
        current=this;
        setTitle("Acceuil");
         setLayout(BoxLayout.yCenter());
          ImageViewer PioneerImage;
        try {
            PioneerImage = new ImageViewer(Image.createImage("/Pioneers.png"));
            add(PioneerImage);
            
        } catch (IOException ex) {
        }
        
       
        Button btnCours = new Button("Cours");
        Button btnLivre = new Button("Livre");
        Button btnTravail = new Button("Travai a faire");
         Button btnJeux1 = new Button("Jeu de memoire");
         Button btnJeux2 = new Button("Jeu casse brique");
        btnCours.addActionListener(e-> new AfficheC(current).show());
         btnLivre.addActionListener(e-> new AfficheL(current).show());
 btnTravail.addActionListener(e-> new Travai(current).show());
        btnJeux1.addActionListener(e-> new Jeux1(current).show());
        btnJeux2.addActionListener(e-> new Jeux2(current).show());
       btnLivre.getUnselectedStyle().setFgColor(5542241);
        btnCours.getUnselectedStyle().setFgColor(6622243);
          btnJeux1.getUnselectedStyle().setFgColor(7583743);
           btnJeux2.getUnselectedStyle().setFgColor(7583743);
           btnTravail.getUnselectedStyle().setFgColor(8563443);
          
         addAll(btnCours,btnLivre,btnTravail,btnJeux1,btnJeux2);
         
    }
    
    
}
