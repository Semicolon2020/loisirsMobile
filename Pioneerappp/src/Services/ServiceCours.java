/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Cours;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;


import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import utils.StaticsC;

/**
 *
 * @author FUJITSU
 */
public class ServiceCours {
 public ArrayList<Cours> cours;
    
    public static ServiceCours instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceCours() {
        req = new ConnectionRequest();
    }
     public static ServiceCours getInstance() {
        if (instance == null) {
            instance = new ServiceCours();
        }
        return instance;
    }
     
      public ArrayList<Cours> parseCours(String jsonText){
        try {
            cours=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Cours c = new Cours();
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                c.setLivre_id((obj.get("livre_id").toString()));
                c.setTuteur(obj.get("tuteur").toString());
                c.setFile(obj.get("file").toString());
                c.setTitre(obj.get("titre").toString());
                c.setDate(obj.get("date").toString());
                cours.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return cours;
    }
    
    public ArrayList<Cours> getAllCours(){
        String url = StaticsC.BASE_URL+"/allC";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cours = parseCours(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cours;
    }
    


}