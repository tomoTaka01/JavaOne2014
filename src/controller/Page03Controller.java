package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import transition.NodeTransitions;

public class Page03Controller implements Initializable, PageController {
    @FXML Text p1;
    @FXML Text p2;
    @FXML Text p3;
    @FXML Text p4;
    @FXML Text p5;
    @FXML ImageView p6;
    @FXML Text p7;
    
    private Node[] texts;
    private int index;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        texts = new Node[]{p1,p2,p3,p4,p5,p6,p7};
        for (Node text : texts) {
            text.setOpacity(0);
        }
    }    

    @Override
    public boolean doAction() {
        if (index < texts.length){
            NodeTransitions.fadein(texts[index]);
            index++;
            if (index == 7){
                ControllerFunction.saySomething(getClass().getResource("03.wave").toString());
            }
            return true;
        }
        return false;
    }
}