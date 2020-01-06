package SierpinskisTriangle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DrawSquare extends Canvas {
	
	static int height;
	static int side;
	int s;
	int h;
	int i=150;
	int interval =5;
	int blue=200;
	static Dimension screenSize;
	static Canvas canvas ;
    public static void main(String[] args) {
    	screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
    	side = (int)screenSize.height;
    	side-=70;
        JFrame frame = new JFrame("My Drawing");
        canvas = new DrawSquare();
        canvas.setSize(side,side);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
    	int xpoints[] = {0,side, side,0};
        int ypoints[] = {0,0,side,side};
      
    	Color c = new Color(75, 100, 191);
         g.setColor(c);
          g.fillPolygon(xpoints, ypoints, 4);
          
    	int x = side/3;//left top
    	int y = side/3;//left top
    	int newSide = side/3;
    	
    	paintNext(g,x,y,newSide);
        
   }
    public void paintNext(Graphics g, int x,int y,int newSide){
      
    	int xpoints[] ={x, x+newSide,x+newSide,x};
    	int ypoints[] = {y,y,y+newSide,y+newSide};
    	Color c = new Color((200+newSide*2)%255, (50+newSide*3)%255, (100+newSide)%255);
        g.setColor(c);
        g.fillPolygon(xpoints, ypoints, 4);//draws polygon outline
        
        int newNew=newSide/3;
        if(newNew>=1) {            
	        paintNext(g,x-2*newNew,y-2*newNew,newNew);//left top
	        paintNext(g,x+newNew,y-2*newNew,newNew);//middle top
	        paintNext(g,x+newSide+newNew,y-2*newNew,newNew);//right top
	        paintNext(g,x+newSide+newNew,y+newNew,newNew);//right middle
	    	paintNext(g,x+newSide+newNew,y+newSide+newNew,newNew);//right bottom
	    	paintNext(g,x-2*newNew,y+newNew,newNew);//left middle
	    	paintNext(g,x-2*newNew,y+newSide+newNew,newNew);//left bottom
	    	paintNext(g,x+newNew,y+newSide+newNew,newNew);//middle bottom
    	
        }
    	
    	
    }
    
}
