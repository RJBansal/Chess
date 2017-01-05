 
/** 
 * Author Rajat Bansal (101019954) 
 * Creates a Knight class and sets properties of color, image, location and valid moves. 
 * Getters and Setters for each property

 */
public class Pawn extends ChessPiece
{
    public boolean firstmove;
    public boolean firstmove2;

    /** 
     * Pawn constructor which creates a new pawn with the parameters owner, location and the game 
     * it belongs to. Sets the id for pawn depending on owner. 
     */
    public Pawn(String owner, ChessLocation intialLocation, ChessGame game)
    {
        super(owner,intialLocation,game);
        if(owner == "p1"){ 
            id = " |P| ";
        }
        else{
            id = " |p| ";
        }
        firstmove = true;
        firstmove2 = true;

    }

    /** 
     * Checks the valid moves for a knight piece. If within range of board and valid moves, it
     * removes piece from old location and relocates it at the new valid location. 
     */

    public boolean moveTo(ChessLocation newLocation)
    { 
        int row_i = get_row();
        int col_i = get_col();
        int row_f = newLocation.get_row();
        int col_f = newLocation.get_col();

        if((row_i + 1 == row_f) && (col_i + 1 == col_f || col_i - 1 == col_f) && get_game().get_board().piece_Board(row_f,col_f).get_id().equals( " |p| ")){
            super.get_game().get_board().removePiece(newLocation);
            if(super.moveTo(newLocation) == true){
                return true;}
            else return false;
        }
        else if(firstmove == true && row_i + 2 == row_f && col_i == col_f && id == " |P| " ){ 
            if(super.moveTo(newLocation) == true){
            firstmove = false;
            return true;}
            else return false;
        }
        else if(row_i + 1 == row_f && col_i == col_f && id == " |P| "){ 
            if(super.moveTo(newLocation) == true){
            firstmove = false;
            return true;}
            else return false;
        }
        else{
            if(firstmove2 == true && row_i - 2 == row_f && col_i == col_f && id == " |p| "){ 
                if(super.moveTo(newLocation) == true){
                firstmove2 = false;
                return true;}
                else return false;
            }
            else if(row_i - 1 == row_f && col_i == col_f && id ==  " |p| "){ 
                if(super.moveTo(newLocation) == true){
                firstmove2 = false;
                return true;}
                else return false;
            }
            else if((row_i - 1 == row_f) && (col_i + 1 == col_f || col_i - 1 == col_f) && get_game().get_board().piece_Board(row_f,col_f).get_id().equals( " |P| ")){
                super.get_game().get_board().removePiece(newLocation);
                if(super.moveTo(newLocation) == true){
                return true;}
                else return false;
            }
            else{ 
                System.out.println("Invalid Move for Pawn\n");
                return false;
            }
        }
    }

    protected void updateThreateningLocation(ChessLocation newLocation){
        int row = newLocation.get_row();
        int col = newLocation.get_col();
        threateningLocations.clear(); 
        if((row + 1) <= 7){
            if(get_game().get_board().isPieceAt(row + 1, col) == true && !(get_game().get_board().piece_Board(row + 1,col).get_player().equals(this.get_player()))){
                threateningLocations.add(new ChessLocation(row + 1,col)); 
            }
            else{
                threateningLocations.add(new ChessLocation(row + 1,col));
            }
            if((col + 1) <= 7){
                if(get_game().get_board().isPieceAt(row + 1, col + 1) == true && this.get_id().equals( " |P| ")){
                    if(!(get_game().get_board().piece_Board(row + 1, col + 1).get_id().equals(" |p| "))){ 
                        threateningLocations.add(new ChessLocation(row + 1,col + 1));
                    }
                }
            }
            if((col - 1) >= 0){
                if(get_game().get_board().isPieceAt(row + 1, col - 1) == true && this.get_id().equals(" |P| ")){
                    if(!(get_game().get_board().piece_Board(row + 1, col - 1).get_id().equals(" |p| "))){ 
                        threateningLocations.add(new ChessLocation(row + 1,col - 1));
                    }
                }
            }
        }
        if((row - 1) >= 0){
            if(get_game().get_board().isPieceAt(row - 1, col) == true && !(get_game().get_board().piece_Board(row - 1,col).get_player().equals(this.get_player()))){
                threateningLocations.add(new ChessLocation(row - 1,col)); 
            }
            else{
                threateningLocations.add(new ChessLocation(row - 1,col));
            }
            if((col + 1) <= 7){
                if(get_game().get_board().isPieceAt(row - 1, col + 1) == true && this.get_id().equals(" |p| ")){
                    if(!(get_game().get_board().piece_Board(row - 1, col + 1).get_id().equals(" |P| "))){ 
                        threateningLocations.add(new ChessLocation(row + 1,col + 1));
                    }
                }
            }
            if((col - 1) >= 0){
                if(get_game().get_board().isPieceAt(row - 1, col - 1) == true && this.get_id().equals(" |p| ")){
                    if(!(get_game().get_board().piece_Board(row - 1, col - 1).get_id().equals(" |P| "))){ 
                        threateningLocations.add(new ChessLocation(row + 1,col - 1));
                    }
                }
            }
        }
    }
}
