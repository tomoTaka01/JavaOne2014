package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.PhongMaterial;
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
//                NodeTransitions.fadeout(p6, 4);
                NodeTransitions.fadein(texts[index], 8);
                index++;
                NodeTransitions.fadein(texts[index], 8);
                index++;
            }
            return true;
        }
        return false;
    }

    private void throwTshirt(){
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResource("Tshirt.jpg").toString()));
        p6.setMaterial(material);
        p6.setRotationAxis(new Point3D(0, 1, 0));
        p6.setRotate(30);
        Timeline animation = new Timeline();
        KeyFrame frame1 = new KeyFrame(Duration.seconds(1)
                , new KeyValue(p6.layoutXProperty(), 380.0)
                , new KeyValue(p6.layoutYProperty(), 380.0)
        );
        KeyFrame frame2 = new KeyFrame(Duration.seconds(2)
                , new KeyValue(p6.layoutXProperty(), 420.0)
                , new KeyValue(p6.layoutYProperty(), 440.0)
        );
        KeyFrame frame3 = new KeyFrame(Duration.seconds(3)
                , new KeyValue(p6.layoutXProperty(), 450.0)
                , new KeyValue(p6.layoutYProperty(), 500.0)
        );
//        KeyFrame frame4 = new KeyFrame(Duration.seconds(4)
//                , new KeyValue(p6.opacityProperty(), 0.0)
//        );
        animation.getKeyFrames().addAll(frame1, frame2,frame3);
        animation.play();
    }
}
