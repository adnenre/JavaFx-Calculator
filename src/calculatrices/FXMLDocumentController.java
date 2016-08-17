/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatrices;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.ScaleTransition;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author versus
 */
public class FXMLDocumentController {
    
    private Label label;
    @FXML
    private Label ecran;
     @FXML
    private Label ecran2;
    @FXML
    private Label close;
    @FXML
    private Button zero;
    @FXML
    private Button point;
    @FXML
    private Button un;
    @FXML
    private Button plus;
    @FXML
    private Button moin;
    @FXML
    private Button fois;
    @FXML
    private Button neuf;
    @FXML
    private Button deux;
    @FXML
    private Button Trois;
    @FXML
    private Button six;
    @FXML
    private Button Cinque;
    @FXML
    private Button quatre;
    @FXML
    private Button sept;
    @FXML
    private Button huit;
    @FXML
    private Button div;
    @FXML
    private Button mod;
    @FXML
    private Button clear;
    private String operateur="",  prev_text="";
    private Boolean Cop=false ,update=false, click = true; //clique operator ,apdate ecran
    private double rez;
    private RotateTransition rt;
    private ScaleTransition sc;

   

    @FXML
    private void closewindows(MouseEvent event) {
        System.exit(0);
    }

     @FXML
    private void Setchiffre(ActionEvent e) {
          
     String str = ((Button)e.getSource()).getText();
    
     // animer(e);
      scale(e);
     if (update)
     {
        
         update= false;
     }
     else {
          if(!ecran.getText().equals("0"))
    
        str = ecran.getText()+ str;
    
    }
       ecran.setText(str);
       
        ecran2.setText(prev_text + str );
     
      
    }
    public void scale(ActionEvent e) {
     
        sc = ScaleTransitionBuilder.create()
                 .node((Button)e.getSource())
                .duration(Duration.seconds(0.1))
                .toX(0.8)
                .toY(0.8)
                .cycleCount(2)
                .autoReverse(true)
                .build();
        sc.play();
       
     
    
    
    }
    public void animer(ActionEvent e )
    {    
         rt = RotateTransitionBuilder.create()
                 .node((Button)e.getSource())
                 .duration(Duration.seconds(1))
                 .fromAngle(0)
                 .toAngle(20)
                 .cycleCount(2)
                 .autoReverse(true)
                 .build();
        rt.play();
    }
    
    @FXML
    private void SetPoint(ActionEvent e) {
       scale(e);
         ecran.setText(".");
          ecran2.setText(".");
    }
 @FXML
    private void setEgal(ActionEvent e) {
      
      scale(e);
      
        calcule();
        Cop = false;
        ecran2.setText(prev_text +" = "+rez);
        prev_text="";
        update= true;
     
        
          
    }

    @FXML
    private void setplus(ActionEvent e) {
       
         scale(e);
         
        if(Cop){
           
            calcule();
            ecran.setText(String.valueOf(rez));
        }else if(!ecran.getText().equals(""))
           {
                  rez = Double.valueOf(ecran.getText()).doubleValue();
                  prev_text = ecran2.getText();
                  Cop=true;
           }else{
                  ecran.setText("0");
                }
        
        operateur =  "+";
        update= true;
     
       ecran2.setText(prev_text+ operateur);
       prev_text =ecran2.getText();
    }

    @FXML
    private void setmoin(ActionEvent e) {
       
      scale(e);
        if(Cop){
            calcule();
            ecran.setText(String.valueOf(rez));
        }else if(!ecran.getText().equals(""))
           {
                  rez = Double.valueOf(ecran.getText()).doubleValue();
                  prev_text = ecran2.getText();
                  Cop=true;
           }else{
                  ecran.setText("0");
                }
        
        operateur =  "-";
        update= true;
     
       ecran2.setText(prev_text+ operateur);
         prev_text =ecran2.getText();
         
         
    }

    @FXML
    private void setfois(ActionEvent e) {
        
         scale(e);
        if(Cop){
            calcule();
            ecran.setText(String.valueOf(rez));
        }else if(!ecran.getText().equals(""))
           {
                  rez = Double.valueOf(ecran.getText()).doubleValue();
                  
                  prev_text = ecran2.getText();
                  Cop=true;
           }else{
                  ecran.setText("0");
                }
        
        operateur =  "*";
        update= true;
     
       ecran2.setText(prev_text+ operateur);
         prev_text =ecran2.getText();
    }

    @FXML
    private void setdiv(ActionEvent e) {
         scale(e);
       if(Cop){
            calcule();
            ecran.setText(String.valueOf(rez));
        }else if(!ecran.getText().equals(""))
           {
                  rez = Double.valueOf(ecran.getText()).doubleValue();
                  prev_text = ecran2.getText();
                  Cop=true;
           }else{
                  ecran.setText("0");
                }
        
        operateur =  "/";
        update= true;
     
       ecran2.setText(prev_text+ operateur);
         prev_text =ecran2.getText();
    }

    @FXML
    private void setmod(ActionEvent e) {
         scale(e);
        if(Cop){
            calcule();
            ecran.setText(String.valueOf(rez));
        }else if(!ecran.getText().equals(""))
           {
                  rez = Double.valueOf(ecran.getText()).doubleValue();
                  prev_text = ecran2.getText();
                  Cop=true;
           }else{
                  ecran.setText("0");
                }
        
        operateur =  "%";
        update= true;
     
       ecran2.setText(prev_text+ operateur);
         prev_text =ecran2.getText();
    }

    @FXML
    private void Clear(ActionEvent e) {
         scale(e);
          ecran.setText("");
           ecran2.setText("");
           prev_text ="";
           Cop=false;
           update=false;
        
    }
   
    
    public void calcule(){
        
    if (operateur.equals("+"))
        {
        rez =rez + Double.valueOf(ecran.getText()).doubleValue();
       ecran.setText(String.valueOf(rez));
         prev_text = ecran2.getText();
       ecran2.setText(prev_text+"+");
        }
     if (operateur.equals("-"))
        {
        rez =rez - Double.valueOf(ecran.getText()).doubleValue();
        ecran.setText(String.valueOf(rez));
         prev_text = ecran2.getText();
       ecran2.setText(prev_text+"-");
        }
      if (operateur.equals("*"))
        {
        rez =rez * Double.valueOf(ecran.getText()).doubleValue();
         
        ecran.setText(String.valueOf(rez));
         prev_text = ecran2.getText();
       ecran2.setText(prev_text+"*");
        }
       if (operateur.equals("/"))
        {
            try{
                  rez =rez /Double.valueOf(ecran.getText()).doubleValue();
                 
                  ecran.setText(String.valueOf(rez));
                  prev_text = ecran2.getText();
                  ecran2.setText(prev_text+"/");
                }catch(ArithmeticException e){
                           ecran.setText("division par 0 impossible");
                           }         
        }
       if (operateur.equals("%"))
        {
            try{
                  rez =rez % Double.valueOf(ecran.getText()).doubleValue();
                  
                  ecran.setText(String.valueOf(rez));
                  prev_text = ecran2.getText();
                  ecran2.setText(prev_text+"%");
                }catch(ArithmeticException e){
                           ecran.setText("division par 0 impossible");
                           }         
        }
         
    }
    
   
}
