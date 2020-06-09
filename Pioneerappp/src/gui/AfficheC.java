/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.Cours;
import Services.ServiceCours;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

/**
 *
 * @author FUJITSU
 */
public class AfficheC extends Form{
    
    
     public AfficheC(Form previous)  {
        setTitle("Cours");
        setLayout(BoxLayout.y());
//         SpanLabel sp = new SpanLabel();
//        sp.setText(ServiceCours.getInstance().getAllCours().toString());
//        add(sp);
       
       ArrayList<Cours>co=ServiceCours.getInstance().getAllCours();
       for (int i=0;i<co.size();i++){
 Label titre=new Label(co.get(i).getTitre());
       add(titre);
      
        
        Label tuteur=new Label(co.get(i).getTuteur());
        add(tuteur);
        
        
         Label date=new Label(co.get(i).getDate());
        add(date);


 Label livre=new Label(co.get(i).getLivre_id());
        add(livre);
//        
        
        
        //Label file=new Label(co.get(i).getFile());
        


String url="http://localhost/PioneersApp/web/uploads/brochures/"+co.get(i).getFile();
Button devGuide = new Button("ouvrie le fichier du cours");
devGuide.addActionListener(e -> {
    FileSystemStorage fs = FileSystemStorage.getInstance();
    String fileName = url;
    if(!fs.exists(fileName)) {
       Util.downloadUrlToFile(url, fileName, true);
    }
    Display.getInstance().execute(fileName);
    });
add(devGuide);


 






//hi.show();
      //  file.getUnselectedStyle().setFgColor(-16777216);
        //Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
          //file.getUnselectedStyle().setFont(l1_font);
        //add(file);
        //add(livre);
      
      //  }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
        
    }
    
    
}
    
}
