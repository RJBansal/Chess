
/**
 * ChessBoard creates a 2-D array and prints it out. Stores the information of all pieces on the board and implements
 * the changes to any movement by changing moving the image of the piece and updating the piece's location
 */
public class ChessBoard
{
    ChessPiece chess_board[][] = new ChessPiece [8][8]; //creates a 8 by 8 chessboard 
    //ChessPiece space;
    //ChessBoard constructor sets the 2-D array all to null with null being |-| 
    public ChessBoard()
    {

        for (int i = 0; i < chess_board.length; i++){ 

            for (int j = 0; j < chess_board.length; j++){ 
                chess_board[i][j] = null;

            } 
        } 

    }
    //Returns the piece image at the location specified by i and j 
    public ChessPiece piece_Board(int i, int j){ 
        return chess_board[i][j];
    }
    //Prints the board and all piece's images on it 
    public void print_board(){ 
        for (int i = 0; i < chess_board.length; i++){ //traverses the x axis of the board
            System.out.println("");
            for (int j = 0; j < chess_board.length; j++){ //traverses the y axis of the board
                if (chess_board[i][j] != null){
                    System.out.print(chess_board[i][j].get_id()); //prints out the image
                }
                else{ 
                    System.out.print(" |-| ");
                }
            } 
            System.out.println(""); //prints a line between each row 
        }
        System.out.println("\n"); 

    }
    //Checks if a piece is located at specified location, returns true or false 
    public boolean isPieceAt(int row, int col){ 

        if (chess_board[row][col] != null){
            return true;
        }

        return false; 
    } 

    public void placePieceAt(ChessPiece piece, ChessLocation location){ 
        chess_board[location.get_row()][location.get_col()] = piece; 
        piece.set_row(location.get_row()); 
        piece.set_col(location.get_col()); 
    }     
    //Removes the image of a piece at a specific location and replaces it with null 
    public void removePiece(ChessLocation location){ 
        chess_board[location.get_row()][location.get_col()] = null; 
    }

}

