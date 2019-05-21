package myInterface;

import domain.Circle;
import domain.Rectangle;
import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;

public class Simulator 
{

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    //posiciones del circulo
    private int xCircle;
    private int yCircle;
    //posiciones del rectangulo
    private int xRec;
    private int yRec;
    //se usa para el movimiento aleatorio de la figura
    private int randomMove;
    //constructor
    public Simulator(DisplayFrame myDisplayer_)
    {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(70);
        myCircle.setWidth(70);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
        //se colocan en una posición aleaotira al principio
        this.xCircle=(int) (Math.random() * 327) + 2;
        this.yCircle=(int) (Math.random() * 337) + 25;
        
        this.xRec=(int) (Math.random() * 295) + 4;
        this.yRec=(int) (Math.random() * 320) + 27;
        
        this.randomMove=0;
    }

    
    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException 
    {
        //ciclo infinito
        while (true)
        {
            this.moveShapes();
            this.createImages();

            //pone en espera el flujo del programa
            Thread.sleep(waitingTime);
        }
    }//end method


    //cambio los valores de las variables de las figuras que tengo
    public void moveShapes() {
        //se usa un aleatorio para que la figura se mueva de manera aleatoria
        this.randomMove=(int)(Math.random()*10)+1;
        //si el numero aleatorio resulta un numero par se moverá en el eje x
        if (randomMove%2==0) {
            //se crea un nuevo aleatorio para ver la dirección en que se moverá
            this.randomMove=(int)(Math.random()*10)+1;
            //si el numero es par se moverá hacia la izquierda
            if (randomMove%2==0) {
                //se valida el borde izquierdo del eje x
                //si no sobrepasa el borde se mueve con normalidad
                if (xCircle<=myCircle.getWidth()) {
                    xCircle +=25;
                } else {
                    xCircle -=25;
                }
            //si el numero es impar se moverá hacia la derecha
            } else {
                //se valida el borde derecho del eje x
                if (xCircle>=(myDisplayer.getWindowWidth()-myCircle.getWidth())) {
                    xCircle -=25;
                } else {
                    xCircle +=25;
                }
            }
        //si el numero aleatorio resulta un numero impar se moverá en el eje y
        } else {
            //se crea un nuevo aleatorio para ver la dirección en que se moverá
            this.randomMove=(int)(Math.random()*10)+1;
            //si el numero es par se moverá hacia abajo
            if (randomMove%2==0) {
                //se valida el borde superior del eje y
                //si no sobrepasa el borde se mueve con normalidad
                if (yCircle<=myCircle.getHeight()) {
                    yCircle +=25;
                } else {
                    yCircle -=25;
                }
            } else {
                if (yCircle>=(myDisplayer.getWindowHeight()-myCircle.getHeight())) {
                    yCircle -=25;
                } else {
                    yCircle +=25;
                }
            }
        }
        
        getMyCircle().setxAxis(xCircle);
        getMyCircle().setyAxis(yCircle);
        
        this.randomMove=(int)(Math.random()*10)+1;
        if (randomMove%2==0) {
            this.randomMove=(int)(Math.random()*10)+1;
            if (randomMove%2==0) {
                if (xRec<=myRectangle.getWidth()) {
                    xRec +=25;
                } else {
                    xRec -=25;
                }
                
            } else {
                if (xRec>=(myDisplayer.getWindowWidth()-myRectangle.getWidth())) {
                    xRec -=25;
                } else {
                    xRec +=25;
                }
            }
        } else {
            this.randomMove=(int)(Math.random()*10)+1;
            if (randomMove%2==0) {
                if (yRec<=myRectangle.getHeight()) {
                    yRec +=25;
                } else {
                    yRec -=25;
                }
            } else {
                if (yRec>=(myDisplayer.getWindowHeight()-myRectangle.getHeight())) {
                    yRec -=25;
                } else {
                    yRec +=25;
                }
            }
        }
        getMyRectangle().setxAxis(xRec);
        getMyRectangle().setyAxis(yRec);
    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages()
    {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getxAxis(),
                getMyCircle().getyAxis(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.BLACK);
        graphic.fillRect(getMyRectangle().getxAxis(),
                getMyRectangle().getyAxis(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }

    //**************************************************************************
    /*     metodos accesores      */

    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public domain.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(domain.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }
}
