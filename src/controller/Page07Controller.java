package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Cylinder;
import javafx.scene.text.Text;
import javafx.util.Duration;
import transition.NodeTransitions;

/**
 * FXML Controller class
 *
 * @author tomo
 */
public class Page07Controller implements Initializable, PageController{
    @FXML Text p1;
    @FXML Text p2;
    @FXML ImageView p3;
    @FXML ImageView p4;
    @FXML ImageView p5;
    @FXML Cylinder p6;
    @FXML Text p7;
    @FXML ImageView p8;

    private Node[] texts;
    private int index;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ControllerFunction.setInnerShadowEffect(p1);
        texts = new Node[]{p2,p3,p4,p5,p6,p7,p8};
        for (Node text : texts) {
            text.setOpacity(0);
        }
    }

    @Override
    public boolean doAction() {
        if (index < texts.length) {
            NodeTransitions.fadein(texts[index]);
            index++;
            if (index == 1) {
                NodeTransitions.fadein(texts[index]);
                index++;
                NodeTransitions.fadein(texts[index]);
                index++;
                NodeTransitions.fadein(texts[index]);
                index++;
            }
            if (index == 5){
                throwTshirt();
                index++;
                index++;
            }
            return true;
        }
        return false;
    }
    private void throwTshirt(){
        TranslateTransition tran1 = new TranslateTransition(Duration.seconds(5), p6);
        tran1.setToX(-560);
        tran1.setToY(220);
        tran1.setInterpolator(Interpolator.EASE_BOTH);
        ScaleTransition tran2 = new ScaleTransition(Duration.seconds(5), p6);
        tran2.setByX(1.5f);
        tran2.setByY(1.5f);
        ParallelTransition tran3 = new ParallelTransition(tran1, tran2);
        tran3.play();
        tran3.setOnFinished(e -> {
            p6.setOpacity(0.0);
            NodeTransitions.fadein(p7);
            NodeTransitions.fadein(p8);
        });
    }

}
