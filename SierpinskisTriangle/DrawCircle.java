package SierpinskisTriangle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DrawCircle extends Canvas {
	
	static int height;
	static int width;
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
    	
    	side = (int)screenSize.height-70;
    	JFrame frame = new JFrame("My Drawing");
        canvas = new DrawCircle();
        canvas.setSize(side,side);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
    	//paint background
    	int xpoints[] = {0,side, side,0};
        int ypoints[] = {0,0,side,side};
        Color c = new Color(75, 100, 191);
        g.setColor(c);
        g.fillPolygon(xpoints, ypoints, 4);
    	//
    	int r = side/2;
    	int x = side/2-r/2;
    	int y = side/2-r/2;
	   
        paintNext(g,x,y,r);
        
   }
    public void paintNext(Graphics g, int x, int y, int r){
    	
    	Color c = new Color((120+r*2)%255, (10+r*3)%255, (210+r*15)%255);
    	g.setColor(c);
    	g.fillOval(x, y, r, r);
    	
    	int newR=r/2;
    	if(newR>=2) {
    		paintNext(g, x-newR/2, y+newR/2, newR);//left
    		paintNext(g, x+r-newR/2, y+newR/2, newR);//right
    		paintNext(g, x+r/2-newR/2, y-newR/2, newR);//top
    		paintNext(g, x+r/2-newR/2, y+r-newR/2, newR);//bottom
    	}
    	    
    }
    
}
