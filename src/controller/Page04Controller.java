package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import transition.NodeTransitions;

/**
 * FXML Controller class
 *
 * @author tomo
 */
public class Page04Controller implements Initializable, PageController{
    @FXML Text p1;
    @FXML Text p2;
    @FXML Text p3;
    @FXML ImageView p11;
    @FXML ImageView p12;

    private Node[] texts;
    private int index;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ControllerFunction.setInnerShadowEffect(p1);
        texts = new Node[]{p2,p3, p11, p12};
        for (Node text : texts) {
            text.setOpacity(0);
        }
    }    

    @Override
    public boolean doAction() {
        if (index < texts.length){
            NodeTransitions.fadein(texts[index]);
            index++;
            if (index == 2){
                NodeTransitions.fadein(texts[index]);
                index++;
                NodeTransitions.fadein(texts[index]);
                index++;
            }
            return true;
        }
        return false;
    }
    
}
