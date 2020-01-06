package SierpinskisTriangle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Draw_Right_Top_Square extends Canvas {
	
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
        canvas = new Draw_Right_Top_Square();
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
          
    	int x = 0;//left top
    	int y = side/2;//left top
    	int newSide = side/2;
    	
    	paintNext(g,x,y,newSide,c);
        
   }
    public void paintNext(Graphics g, int x,int y,int newSide, Color c){
      
    	int xpoints[] ={x, x+newSide,x+newSide,x};
    	int ypoints[] = {y,y,y+newSide,y+newSide};
    	c = new Color((140+newSide*2)%255, (20+newSide*3)%255, (100+newSide)%255);
        g.setColor(c);
        g.fillPolygon(xpoints, ypoints, 4);
        
        int newNew=newSide/2;

	    if(newNew>=1) {            
		        paintNext(g,x,y-newNew,newNew,c);//left top
		        paintNext(g,x+newSide,y+newSide-newNew,newNew,c);//right bottom
		       
	    } 	
    	
    }
    
}
