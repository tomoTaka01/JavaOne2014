package transition;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Node Transition
 * 
 * @author tomo
 */
public class NodeTransitions {
   public static void fadein(Node node){
       fadein(node, 1);
   } 
   public static void fadein(Node node, double seconds){
       FadeTransition transition = new FadeTransition(Duration.seconds(seconds));
       transition.setNode(node);
       transition.setToValue(1.0);
       transition.play();
   }
   public static void fadeout(Node node, double seconds){
       FadeTransition transition = new FadeTransition(Duration.seconds(seconds));
       transition.setNode(node);
       transition.setToValue(0.0);
       transition.play();
   }
   public static void translate(Node node, double seconds){
       translate(node, seconds, false);
   }
   public static void translate(Node node, double seconds, boolean isIndefinite){
       TranslateTransition transition = new TranslateTransition(Duration.seconds(seconds));
       transition.setNode(node);
       transition.setFromX(800.0);
       transition.setToX(50.0);
       node.setOpacity(1.0);
       if (isIndefinite) {
           transition.setCycleCount(Animation.INDEFINITE);
       }
       transition.play();
   }
}
