package controller;

import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ControllerFunction {

    public static void setInnerShadowEffect(Text text){
        text.setFill(Color.RED);
        Light.Distant distant = new Light.Distant();
        distant.setAzimuth(-135.0f);
        Lighting l = new Lighting();
        l.setLight(distant);
        l.setSurfaceScale(5.0f);
        text.setEffect(l);
        
    }
    
    public static void saySomething(String source){
        AudioClip audioClip = new AudioClip(source);
        audioClip.play(1.0);
    }
    
}
