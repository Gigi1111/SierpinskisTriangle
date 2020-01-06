package SierpinskisTriangle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DrawTriangle extends Canvas {
	
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
    	
    	height = (int)screenSize.height;
    	height-=70;
    	//x,2x,xRoot3
    	side = (int)(2*height/Math.sqrt(3));
        JFrame frame = new JFrame("My Drawing");
        canvas = new DrawTriangle();
        canvas.setSize(side,height);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
    	
    	int windowHeight = canvas.getHeight();
    	int windowWidth = canvas.getWidth(); 
    	
    	windowHeight +=150;
    	side = windowHeight>=windowWidth?windowWidth:windowHeight;
    	//height-=70;
    	//x,2x,xRoot3
    	//side = (int)(2*height/Math.sqrt(3));
    	height = (int)(Math.sqrt(3)*side/2);    	
    	//left right top
        int xpoints[] = {0, side/2, side};
        int ypoints[] = {height, 0, height};
        int npoints = 3;

        i+=interval;
	    Color c = new Color(i%255,0,(blue+i/2)%255);
        g.setColor(c);
         g.fillPolygon(xpoints, ypoints, npoints);//draws polygon outline
      
         i+=interval;
         c = new Color(i%255,0,(blue+i/2)%255);
         paintNext(g, side/2,0, side, height,c);//top point and side
        
   }
    public void paintNext(Graphics g, int x, int y, int s,int h, Color c){
      int ss = (int)(s/2);   	
      int hh = (int)(h/2); //(int)(Math.sqrt(3)*ss/2);    
      if(ss>2) {
	      int xpoints[] = {x-ss/2, x, x+ss/2};
	      int ypoints[] = {y+hh,y+2*hh,y+hh};
	      int npoints = 3;     
	      g.setColor(c);
	      g.fillPolygon(xpoints, ypoints, npoints);
	      i+=interval;
	      c = new Color(i%255,0,(blue+i/2)%255);
	      paintNext(g, x-ss/2, y+hh, ss, hh,c);//left
	      paintNext(g, x+ss/2, y+hh, ss, hh,c);//right
	      paintNext(g, x, y, ss, hh,c);//top
      }
    	
    }
    
}
