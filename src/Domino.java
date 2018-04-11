import java.awt.Graphics;

//import javax.swing.JPanel;
/**
 * 
 * @author Jack Botelho
 * This class creates and draws a 3-D domino in a JPanel and adds dots to both side1s.
 */
public class Domino{
	/** X is the x-coordinate, y is the y coordinate, and side1 is the number of dots
	 * on the left side1 of the domino.
	 */
	private int x, y, side1, side2; 
	private static final int DOMINO_LENGTH = 100;//Static Domino Length
	private static final int DOMINO_HEIGHT = 50;//Static Domino Height
	public Domino() {
		
	}
	/**
	 * Sets up the domino's specifications.
	 * @param xCor 
	 * @param yCor
	 * @param left - Number of pips on the left side
	 * @param right - Number of pips on the right side
	 */
	public void setup(int xCor, int yCor, int left, int right){
		x = xCor;
		y = yCor;
		side1 = left;
		side2 = right;
	}
	
	/**
	 * Changes the Domino's co-ordinates.
	 */
	public void setCor(int newX, int newY){
		x = newX;
		y = newY;
	}
	
	/** Returns the X-Value */
	public int getX(){
		return x;
	}
	
	/** Returns the Y-Value */
	public int getY(){
		return y;
	}
	
	/**
	 * Returns the number of pips on the left.
	 */
	public int getLeft(){
		return side1;
	}
	
	/**
	 * Returns the number of pips on the right.
	 */
	public int getRight(){
		return side2;
	}
	
	/**
	 * Swaps the number of pips on each side.
	 */
	public void flip(){
		int temp = side1;
		side1 = side2;
		side2 = temp;
	}
	
	
	/** This method draws up the domino for me first drawing a skelton and then
	 * using if loops to get the dots that the user inputted.
	 */
	public void drawDomino(Graphics pane){
		drawBlank(pane);
		if(side1 == 1){
			drawOne(pane, true);
		}
		else if(side1 == 2){
			drawTwo(pane, true);
		}
		else if(side1 == 3){
			drawThree(pane, true);
		}
		else if(side1 == 4){
			drawFour(pane, true);
		}
		else {
			drawFive(pane, true);
		}
		 // Generates a random number for the other side1
		if(side2 == 1){
			drawOne(pane, false);
		}
		else if(side2 == 2){
			drawTwo(pane, false);
		}
		else if(side2 == 3){
			drawThree(pane, false);
		}
		else if(side2 == 4){
			drawFour(pane, false);
		}
		else {
			drawFive(pane, false);
		}

	}
	
	/** Draws the domino Skeleton */
	private void drawBlank(Graphics pane){
		pane.drawRect(x, y, DOMINO_LENGTH, DOMINO_HEIGHT);
		pane.drawLine(x + DOMINO_LENGTH/2, y, x + DOMINO_LENGTH/2, y + DOMINO_HEIGHT);
		pane.drawLine(x - 10, y - 10, x - 10 , (y + DOMINO_HEIGHT) - 10 );
		pane.drawLine(x - 10, y - 10, (x + DOMINO_LENGTH) - 10, y - 10);
		pane.drawLine(x - 10, y - 10, x, y);
		pane.drawLine(x - 10, (y + DOMINO_HEIGHT) - 10, x, y + DOMINO_HEIGHT);
		pane.drawLine((x + DOMINO_LENGTH) - 10, y - 10, x + DOMINO_LENGTH, y);
	}
	
	/** Draws one dot on either the left or right side */
	private void drawOne(Graphics pane, boolean isLeft){
		if(isLeft){
			pane.fillOval((x + (DOMINO_LENGTH)/4) - 5, (y + (DOMINO_HEIGHT)/2) - 5, 10, 10);
		}
		else {
			pane.fillOval((x + 3 * (DOMINO_LENGTH) / 4) - 5, (y + (DOMINO_HEIGHT)/2) - 5, 10, 10);
		}
	}
	
	/** Draws two dots on either the left or right side */
	private void drawTwo(Graphics pane, boolean isLeft){
		if(isLeft){
			pane.fillOval(x + 5, y + 5 , 10, 10);
			pane.fillOval(x + (DOMINO_LENGTH / 2)- 15, y + (DOMINO_HEIGHT - 15), 10, 10);
		}
		else {
			pane.fillOval(x + 5 + DOMINO_LENGTH / 2, y + 5 , 10, 10);
			pane.fillOval((x + (2 * DOMINO_LENGTH / 2)- 15), y + (DOMINO_HEIGHT - 15), 10, 10);
		}
	}
	
	/** Draws three dots on either the left or right side */
	private void drawThree(Graphics pane, boolean isLeft){
		if(isLeft){
			drawOne(pane, true);
			drawTwo(pane, true);
		}
		else {
			drawOne(pane, false);
			drawTwo(pane, false);
		}
	}
	
	/** Draws four dots on either the left or right side */
	private void drawFour(Graphics pane, boolean isLeft){
		if(isLeft){
			drawTwo(pane, true);
			pane.fillOval(x + 5,  y + DOMINO_HEIGHT - 15, 10, 10);
			pane.fillOval(x + (DOMINO_LENGTH / 2) - 15, y + 5, 10, 10);
		}
		else {
			drawTwo(pane, false);
			pane.fillOval(x + 5 + DOMINO_LENGTH / 2, y + DOMINO_HEIGHT -15, 10, 10);
			pane.fillOval(x + DOMINO_LENGTH - 15, y + 5, 10, 10);
		}
	}
	
	/** Draws five dots on either the left or right side */
	private void drawFive(Graphics pane, boolean isLeft){
		if(isLeft){
			drawFour(pane, true);
			drawOne(pane, true);
		}
		else {
			drawFour(pane, false);
			drawOne(pane, false);
		}
	}
	
	
}
