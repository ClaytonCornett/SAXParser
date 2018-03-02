/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cscyrdsaxparser;

import java.awt.TextArea;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author claytoncornett
 */
public class SAXParserViewController implements Initializable {

    
    Stage stage;
   
   @FXML
   public javafx.scene.control.TextArea tA;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.stage = stage;
    }    
    
    
    @FXML
    public void openXMLFile() throws Exception{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open XML File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml"));
        File file = fileChooser.showOpenDialog(stage);
        
        Node root = StackParser.parse(file);
        
        //textArea.setText("test");
        //textArea.append(root.name);
       // textArea.append(root.data);
        //textArea.append(root.attributes);
        
        tA.setText(StackParser.createText());
        
        System.out.println(root);
    }
    
}
