package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import transition.NodeTransitions;

/**
 * FXML Controller class
 *
 * @author tomo
 */
public class Page09Controller implements Initializable, PageController{
    @FXML Text p1;
    @FXML Text p2;
    @FXML ImageView p3;
    @FXML Text p4;
    @FXML Text p5;
    @FXML ImageView p6;
    @FXML Text p7;

    private Node[] texts;
    private int index;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ControllerFunction.setInnerShadowEffect(p1);
        texts = new Node[]{p2,p3,p4,p5,p6,p7};
        for (Node text : texts) {
            text.setOpacity(0);
        }
        addEffect();
    }    

    @Override
    public boolean doAction() {
        if (index < texts.length){
            NodeTransitions.fadein(texts[index]);
            index++;
            if (index == 1){
                NodeTransitions.fadein(texts[index]);
                index++;
            }
            if (index == 3){
                NodeTransitions.fadein(texts[index]);
                index++;
                NodeTransitions.fadein(texts[index]);
                index++;
            }
            return true;
        }
        return false;
    }
    
    private void addEffect(){
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.AQUA);
        shadow.setOffsetX(10.0);
        shadow.setOffsetY(10.0);
        p7.setFill(Color.BLUE);
        Reflection reflection = new Reflection();
        reflection.setFraction(1.2);
        reflection.setInput(shadow);
        p7.setEffect(reflection);
    }
}
