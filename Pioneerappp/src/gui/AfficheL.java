/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.Livre;
import Services.ServiceLivre;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.MediaPlayer;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.components.WebBrowser;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Slider;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author FUJITSU
 */
public class AfficheL extends Form{
   
//    private Form current;
//    private Resources theme;
//    private ConnectionRequest connectionRequest;
//    private Image img;
//    private String imgPath;
    EncodedImage enc;
    
    
    
//    public void playAudio(String fileName) {
//       
//    try {
//        if (MEDIA == null) {
//            final InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
//            MEDIA = MediaManager.createMedia(is, "audio/mp3", new Runnable() {
//                @Override
//                public void run() {
//                    MEDIA = null;
//                }
//            });
//        }
//        if (MEDIA != null && MEDIA.isPlaying() == false) {
//            MEDIA.setVolume(100);
//            MEDIA.play();
//        }
//    } catch (IOException ioe) {
//    }
//}

    public AfficheL(Form previous)  {
        
         
         
         
//      Livre a = new Livre();
//        Image img = Image.createImage("file:/C:/wamp64/www/PioneersApp/web/images" + a.getNom_image()).fill(300, 300);
//         ImageViewer v = new ImageViewer(img);
//       add(img);
       setTitle("Livre");
        setLayout(BoxLayout.y());
        setToolbar(new Toolbar());
        

//         SpanLabel sp = new SpanLabel();
//         
//        sp.setText(ServiceLivre.getInstance().getAllLivre().toString());
//        add(sp);

        ArrayList<Livre>li=ServiceLivre.getInstance().getAllLivre();
        for (int i=0;i<li.size();i++){
           
      
  
        String url="http://localhost/PioneersApp/web/images/"+li.get(i).getNom_image();
            Image placeholder = Image.createImage(500,300);
           
             try {
                 enc = EncodedImage.create("/fadhel.png");
             } catch (IOException ex) {
                 
             }
             
            Image urlim = URLImage.createToStorage(enc, url,url,URLImage.RESIZE_SCALE);
            ImageViewer imgV = new ImageViewer();
            imgV.setImage(urlim);
            add(imgV);
            
             Label titrel=new Label(li.get(i).getTitrel());
       add(titrel); 
            
            
            
            
          



            
            
            
            
            
            String path="http://localhost/PioneersApp/web/livres/0dc036a10713ed393b00d4358b1edf5f.pdf";
Button pdf = new Button("lire la conte");
pdf.addActionListener(e -> {
    FileSystemStorage ls = FileSystemStorage.getInstance();
    String fileName = path;
    if(!ls.exists(fileName)) {
       Util.downloadUrlToFile(path, fileName, true);
    }
    Display.getInstance().execute(fileName);
    
    });
add(pdf);


            
            
            
          String u="http://localhost/PioneersApp/web/audio/sound/"+li.get(i).getAudio();
Button devGuide = new Button("ecouter la conte");
devGuide.addActionListener(e -> {
    
    FileSystemStorage ls = FileSystemStorage.getInstance();
    String fileName = u;
    if(!ls.exists(fileName)) {
       Util.downloadUrlToFile(u, fileName, true);
    }
    Display.getInstance().execute(fileName);
    WebBrowser p = new WebBrowser();
p.setURL(u);
add(p);
    });
add(devGuide);
    
    
    

    
     
       
     
                    
                    
                    

          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    
    
    
}}}

   

