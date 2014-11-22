package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import transition.NodeTransitions;

/**
 * FXML Controller class
 *
 * @author tomo
 */
public class Page05Controller implements Initializable, PageController{
    @FXML Text p1;
    @FXML Text p2;
    @FXML Text p3;
    @FXML Text p4;
    @FXML ImageView p5;
    @FXML Text p6;
    @FXML ImageView p7;
    @FXML Text p8;
    @FXML Text p9;
    @FXML ImageView p10;
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
        texts = new Node[]{p2,p3,p4,p5,p6,p7, p8,p9,p10,p11,p12};
        for (Node text : texts) {
            text.setOpacity(0);
        }
        p1.setFill(Color.RED);
        Light.Distant distant = new Light.Distant();
        distant.setAzimuth(-135.0f);
        Lighting l = new Lighting();
        l.setLight(distant);
        l.setSurfaceScale(5.0f);
        p1.setEffect(l);
    }    

    @Override
    public boolean doAction() {
        if (index < texts.length){
            NodeTransitions.fadein(texts[index]);
            index++;
            if (index == 3 || index == 5){
                NodeTransitions.fadein(texts[index]);
                index++;
            }
            if (index == 8){
                for (; index < 11;index++) {
                    NodeTransitions.fadein(texts[index]);
                }
            }
            return true;
        }
        return false;
    }
}
