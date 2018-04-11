package sudoku.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import sudoku.model.Board;

/**
 * A special panel class to display a Sudoku board modeled by the
 * {@link sudoku.model.Board} class. You need to write code for
 * the paint() method.
 *
 * @see sudoku.model.Board
 * @author Yoonsik Cheon
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel {
    
	public interface ClickListener {
		
		/** Callback to notify clicking of a square. 
		 * 
		 * @param x 0-based column index of the clicked square
		 * @param y 0-based row index of the clicked square
		 */
		void clicked(int x, int y);
	}
	
    /** Background color of the board. */
	private static final Color boardColor = new Color(247, 223, 150);

    /** Board to be displayed. */
    private Board board;

    /** Width and height of a square in pixels. */
    private int squareSize;

    /**
	 *Create a new board panel to display the given board.
	 */
    public BoardPanel(Board board, ClickListener listener) {
    		//Graphics g = new Graphics();
        this.board = board;
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	int xy = locateSquaree(e.getX(), e.getY());
            	if (xy >= 0) {
            		listener.clicked(xy / 100, xy % 100);
            		//highlightBox(g, e.getX(), e.getY());
            	}
            }
        });
    }

    /** Set the board to be displayed. */
    public void setBoard(Board board) {
    	this.board = board;
    }
    
    /**
     * Given a screen coordinate, return the indexes of the corresponding square
     * or -1 if there is no square.
     * The indexes are encoded and returned as x*100 + y, 
     * where x and y are 0-based column/row indexes.
     */
    private int locateSquaree(int x, int y) {
    	if (x < 0 || x > board.size * squareSize
    			|| y < 0 || y > board.size * squareSize) {
    		return -1;
    	}
    	int xx = x / squareSize;
    	int yy = y / squareSize;

//    	//checks if the board is solved
//    	board.isSolved();

    	return xx * 100 + yy;
    }

    /** Draw the associated board. */
	@Override
    public void paint(Graphics g) {
        super.paint(g);

        // determine the square size
        Dimension dim = getSize();
        squareSize = Math.min(dim.width, dim.height) / board.size;

        // draw background
        final Color oldColor = g.getColor();
        g.setColor(boardColor);
        g.fillRect(0, 0, squareSize * board.size, squareSize * board.size);

        // WRITE YOUR CODE HERE ...
        // i.e., draw grid and squares.
        g.setColor(boardColor);
       
        
    		g.setColor(Color.magenta);
    		g.fillRect(squareSize * board.xpos, squareSize * board.ypos, squareSize, squareSize); 
        
        	g.setColor(Color.BLACK);
        for (int i = 0; i < board.size; i++) {
        		for (int j = 0; j < board.size; j++) {
        			//we dont print nothing
        			if (board.puzzle[i][j] == 0) {
						g.setColor(Color.blue);
        				g.drawString("", ((squareSize*i) + (squareSize / 2)), ((squareSize*j) + (squareSize / 2)));
        			}

        			else {
        				//we print the string
						g.setColor(Color.BLACK);
        				g.drawString(board.puzzle[i][j]+"", (squareSize*i) + (squareSize / 2), (squareSize*j) + (squareSize / 2));

        				//if()
        				g.setColor(Color.red);
        			}
        		}
        }
        
        for (int i = 0; i <= board.size; i++) {
    		if (i % Math.sqrt(board.size) == 0) {
    			g.setColor(Color.black);
    		}
    		else {
    			g.setColor(Color.gray);
    		}
    		g.drawLine(0, squareSize * i, board.size * squareSize, squareSize * i);
    		g.drawLine(squareSize * i, 0, squareSize * i, squareSize * board.size);
    }
    }

}
