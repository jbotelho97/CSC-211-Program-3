import java.awt.*;
import java.awt.Graphics;
import java.util.Random;
import java.util.Scanner;


public class Game extends Frame{
	
	private Domino myDomino, compDomino;
	private UneFenetre myWindow;
	Random rand = new Random();
	
	public Game() {
		/** this is where the user inputs the desired dot number and 
		 * x and y coordinates.
		 */
		int numSides, xCor, yCor;
		Scanner keyboard = new Scanner(System.in);
		numSides = 0;
		while (numSides < 1 || numSides > 5){
			System.out.print("Enter a number from one to five: ");
			numSides = keyboard.nextInt();
		}
		System.out.print("Enter the x-coordinate of the domino: ");
		xCor = keyboard.nextInt();
		System.out.print("Enter the y-coordinate of the domino: ");
		yCor = keyboard.nextInt();
		int myRight = rand.nextInt((6 - 1) + 1) + 1;
		myDomino = new Domino();
		myDomino.setup(xCor, yCor, numSides, myRight);
		compDomino = new Domino();
		int compX = rand.nextInt(600);
		int compY = rand.nextInt(500);
		int compL = rand.nextInt((6 - 1) + 1) + 1;
		int compR = rand.nextInt((6 - 1) + 1) + 1;
		compDomino.setup(compX, compY, compL, compR);
		startUp(); //Initializes the window
		myWindow = new UneFenetre();//to allow for window closing
		addWindowListener(myWindow);
		compare();
	}
	/**
	 * This method compares the number of pips on the dominos and re-arranges them
	 * by putting the two with the same number together.
	 */
	private void compare(){
		int cLeft = compDomino.getLeft();
		int cRight = compDomino.getRight();
		int pLeft = myDomino.getLeft();
		int pRight = myDomino.getRight(); 
		if(pLeft == cRight){
			compDomino.setCor(myDomino.getX() - 110, myDomino.getY());
			System.out.println("There's a match!");
		}
		else if(pLeft == cLeft){
			compDomino.flip();
			compDomino.setCor(myDomino.getX() - 110, myDomino.getY());
			System.out.println("There's a match!");
		}
		else if(pRight == cLeft){
			compDomino.setCor(myDomino.getX() + 110, myDomino.getY());
			System.out.println("There's a match!");
		}
		else if(pRight == cRight){
			compDomino.flip();
			compDomino.setCor(myDomino.getX() + 110, myDomino.getY());
			System.out.println("There's a match!");
		}
		else {
			System.out.println("Not a match. Sorry!");
		}
		repaint();
	}
	
	private void startUp(){
		setSize(700,600);
		setTitle("Playing Dominos");
		setVisible(true);
	}
	
	public void paint(Graphics p){
		myDomino.drawDomino(p);
		compDomino.drawDomino(p);
	}

}
