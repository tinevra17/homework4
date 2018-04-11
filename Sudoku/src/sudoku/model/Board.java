package sudoku.model;


/**
 * This class will provide all the functionality for creating a sudoku board
 * and keep track of the board itself.
 */
public class Board {
	
	public int size;
	public int[][] puzzle;
	public int xpos;
	public int ypos;
	public int value;

	/** The default size of the board will be 4 and makes a call to
	 * makeOriginalBoard which will create a 2D array with this given size.
	 */
	public Board() {
		size = 4;
		makeOriginalBoard();
	}

	/**
	 * It then makes a call to makeOriginalBoard which will create
	 * a 2D array with this given size.
	 * @param size Constructor that receives an integer value and sets its value to
	 * 'int size'.
	 */
	public Board(int size) {
		this.size = size;
		makeOriginalBoard();
	}
	
	/** makeOriginalBoard takes the size stored into 'int size' and creates a
	 * new 2D Array with the row length = to size and the column length  = to 
	 * size. After creating the array, it sets all initial values to -1.  
	 */
	public void makeOriginalBoard() {
		puzzle = new int[size][size];
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				puzzle[i][j] = 0; 
			}
		}
	}
	
	/** isSolved will iterate throughout the entire 2D Array to check
	 * and make sure there are no more unchanged numbers (-1's). Once all 
	 * numbers have been changed from -1's to another int value then this
	 * method will return true.
	 */
	public boolean isSolved() {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				if (puzzle[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	/** modifyBoard receives 3 integers (x, y, v) and modifies the 2D Array
	 * puzzle. 'x' represents the row, 'y' represents the column, and 'v'
	 * represents the number that will be placed into the array at positions
	 * x & y.
	 */
	public void modifyBoard() {
		puzzle[xpos][ypos] = value;
	}

	/** checkBoard receives 1 integers (v) and checks to make sure that
	 * 'v' is not found anywhere in row 'x' nor column 'y'. If 'v' is found in
	 * either row x or row y then this method will return false otherwise this
	 * method will return true.
	 * @param v is the number to be imputed into the board
	 * @return
	 */
	public boolean checkBoard(int v) {
		// Check rows.
		for (int i = 0; i < puzzle.length; i++) {
			if (puzzle[i][ypos] == v)
				return false;
		}

		// Check columns.
		for (int j = 0; j < puzzle[xpos].length; j++) {
			if (puzzle[xpos][j] == v)
				return false;
		}

		// Check surrounding box.
		double sqrtSize = Math.sqrt(size);
		int rowCounter = 1;
		while (xpos >= sqrtSize * rowCounter) {
			rowCounter++;
		}
		//System.out.println("This is the quadrant for row: " + rowCounter);

		int colCounter = 1;
		while (ypos >= sqrtSize * colCounter) {
			colCounter++;
		}
		//System.out.println("This is the quadrant for column: " + colCounter);

		for (int i = (int)(sqrtSize * rowCounter) - 1; i > ((rowCounter * sqrtSize) - sqrtSize) - 1; i--) {
			for (int j = (int)(sqrtSize * colCounter) - 1; j > ((colCounter * sqrtSize) - sqrtSize) - 1; j--) {
				//System.out.print("(" + (i) + ", " + (j) + ") ");
				if (puzzle[i][j] == v) {
					return false;
				}
			}
			System.out.println();
		}

		return true;
	}
	

	
	/** getSize will return the size of 'int size' to whichever method calls it.
	 */
	public int size() {
		return size;
	}















}
