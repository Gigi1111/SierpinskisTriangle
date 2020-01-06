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
    	//x,2x,xRoot3
    	//side = (int)(2*height/Math.sqrt(3));
        JFrame frame = new JFrame("My Drawing");
        canvas = new DrawSquare();
        canvas.setSize(side,side);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
    	
//    	int windowHeight = canvas.getHeight();
//    	int windowWidth = canvas.getWidth(); 
//    	
//    	windowHeight +=150;
//    	side = windowHeight>=windowWidth?windowWidth:windowHeight;
//    	//height-=70;
//    	//x,2x,xRoot3
//    	//side = (int)(2*height/Math.sqrt(3));
//    	height = (int)(Math.sqrt(3)*side/2);    	
    	//left right top
//        int xpoints[] = {0, side/2, side};
//        int ypoints[] = {height, 0, height};
//        int npoints = 3;
//
//        i+=interval;
//	    Color c = new Color(i%255,0,(blue+i/2)%255);
//        g.setColor(c);
//         g.fillPolygon(xpoints, ypoints, npoints);//draws polygon outline
//      
//         i+=interval;
//         c = new Color(i%255,0,(blue+i/2)%255);
//         paintNext(g, side/2,0, side, height,c);//top point and side
    	int xpoints[] = {0,side, side,0};
        int ypoints[] = {0,0,side,side};
      
    	Color c = new Color(75, 100, 191);
         g.setColor(c);
          g.fillPolygon(xpoints, ypoints, 4);
          
    	int x = side/3;//left top
    	int y = side/3;//left top
    	int newSide = side/3;
    	
    	paintNext(g,x,y,newSide,c);
        
   }
    public void paintNext(Graphics g, int x,int y,int newSide, Color c){
      
    	int xpoints[] ={x, x+newSide,x+newSide,x};
    	int ypoints[] = {y,y,y+newSide,y+newSide};
    	c = new Color((200+newSide*2)%255, (50+newSide*3)%255, (100+newSide)%255);
        g.setColor(c);
        g.fillPolygon(xpoints, ypoints, 4);//draws polygon outline
        
        int newNew=newSide/3;
    	 //1,2,3,4,5,6,7,8
       // if(x+2*newSide < side && x-2*newSide > 0 && y+2*newSide < side && y-2*newSide >0) {
        if(newNew>=1) {            
	        paintNext(g,x-2*newNew,y-2*newNew,newNew,c);//left top
	        paintNext(g,x+newNew,y-2*newNew,newNew,c);//middle top
	        paintNext(g,x+newSide+newNew,y-2*newNew,newNew,c);//right top
	        paintNext(g,x+newSide+newNew,y+newNew,newNew,c);//right middle
	    	paintNext(g,x+newSide+newNew,y+newSide+newNew,newNew,c);//right bottom
	    	paintNext(g,x-2*newNew,y+newNew,newNew,c);//left middle
	    	paintNext(g,x-2*newNew,y+newSide+newNew,newNew,c);//left bottom
	    	paintNext(g,x+newNew,y+newSide+newNew,newNew,c);//middle bottom
    	
//    	paintNext(g,x-2*newSide,y-2*newSide,newSide,c);
//    	paintNext(g,x-2*newSide,y-2*newSide,newSide,c);
//    	paintNext(g,x-2*newSide,y-2*newSide,newSide,c);
//    	paintNext(g,x-2*newSide,y-2*newSide,newSide,c);
//    	paintNext(g,x-2*newSide,y-2*newSide,newSide,c);
//    	paintNext(g,x-2*newSide,y-2*newSide,newSide,c);
        }
    	
    	
    }
    
}
