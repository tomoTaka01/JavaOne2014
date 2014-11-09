package contents;

import controller.PageController;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.ParallelCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Presentation of JavaOne 2014
 * 
 * @author tomo
 */
public class JavaOne2014Presentation extends Application {
    public static final double WIDTH = 1300.0;
    public static final double HEIGHT = 700.0;
    private String[] pages = {
         "Page01Title.fxml"
       , "Page02Intro.fxml"
       , "Page03BadThings.fxml"
       , "Page04Speaker.fxml"
       , "Page05Party.fxml"
       , "Page06Live.fxml"
       , "Page07Tshirt.fxml"
       , "Page08Friends.fxml"
       , "Page09Kani.fxml"
    };
    private int pageIx;
    private Group root;
    private PageController presentController;
    
    @Override
    public void start(Stage stage) throws Exception {
        root = new Group();
        root.setOnMouseClicked(e -> {
            if (!presentController.doAction()){
                try {
                    goForward();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        Scene scene = new Scene(root);
        stage.setScene(scene);
        ParallelCamera camera = new ParallelCamera();
        scene.setCamera(camera);
        stage.setFullScreen(true);
        goForward();
        stage.show();
    }

    private void goForward() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(pages[pageIx]));
        Node next = (Node) loader.load();
        presentController = loader.getController();
        root.getChildren().add(next);
        Node present = null;
        if (root.getChildren().size() > 1){
            present = root.getChildren().get(0);
        }
        translatePage(next, present);
        pageIx++;
        if (pageIx >= pages.length){
            pageIx = 0;
        }
        
    }

    private void translatePage(Node next, final Node present){
        TranslateTransition fadein = new TranslateTransition(Duration.seconds(1));
        fadein.setNode(next);
        fadein.setFromX(WIDTH);
        fadein.setToX(0);
        fadein.play();
        if (present != null){
            TranslateTransition fadeout = new TranslateTransition(Duration.seconds(1));
            fadeout.setNode(present);
            fadeout.setToX(-WIDTH);
            fadeout.setOnFinished(e -> {
                root.getChildren().remove(present);
            });
            fadeout.play();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
