/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;



import Entities.Livre;

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
public class ServiceLivre {
    public ArrayList<Livre> livre;
    
    public static ServiceLivre instance=null;
    public boolean resultOK;
    private ConnectionRequest req;


    public ServiceLivre() {
        req = new ConnectionRequest();
    }
    
     public static ServiceLivre getInstance() {
        if (instance == null) {
            instance = new ServiceLivre();
        }
        return instance;
    }
     
      public ArrayList<Livre> parseLivre(String jsonText){
        try {
            livre=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Livre c = new Livre();
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                c.setTitrel((obj.get("titrel").toString()));
                c.setFilel(obj.get("filel").toString());
                c.setAudio(obj.get("audio").toString());
                c.setNom_image(obj.get("nom_image").toString());
                livre.add(c);
            }
            
            
        } catch (IOException ex) {
            
        }
        return livre;
    }
    
    public ArrayList<Livre> getAllLivre(){
        String url = StaticsC.BASE_URL+"/allL";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                livre = parseLivre(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return livre;
    }
    
    
}
