/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.WebBrowser;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author FUJITSU
 */
public class Jeux2 extends Form {
      public Jeux2(Form previous) {
       setTitle("Jeux");
        setLayout(BoxLayout.y());
        setToolbar(new Toolbar());
        
        
        WebBrowser p = new WebBrowser();
p.setURL("http://localhost/PioneersApp/web/casse/casse.html");
add(p);


    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }
}
