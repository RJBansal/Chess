
/** 
 * Author Rajat Bansal (101019954) 
 * Creates a Knight class and sets properties of color, image, location and valid moves. 
 * Getters and Setters for each property

 */
public class Knight extends ChessPiece
{   

    /** 
     * Knight constructor which creates a new knight with the parameters owner, location and the game 
     * it belongs to. 
     */
    public Knight(String owner, ChessLocation intialLocation, ChessGame game)
    {
        super(owner, intialLocation, game);
        if(owner == "p1"){ 
            id = " |N| ";
        }
        else{
            id = " |n| ";
        }

    }

    public String get_id(){ 
        return super.id;
    }
    //returns the owner of the knight

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
        /**
         * Checks if the new location and the intial location have a col difference of exactly 2 and a row difference of exactly 1
         * if so it is a valid move 
         */
        if (((Math.abs(col_f - col_i) == 2) && (Math.abs(row_f - row_i)) == 1)||((Math.abs(col_f - col_i) == 1) && (Math.abs(row_f - row_i)) == 2)){ 
            if(super.moveTo(newLocation) == true){ 
            return true;}
            else return false;
        }
        else { 
            System.out.println("Invalid Move for Knight\n");
            return false;
        }
    }

    protected void updateThreateningLocation(ChessLocation newLocation){
        int row = newLocation.get_row(); 
        int col = newLocation.get_col();
        threateningLocations.clear(); 
        if((row + 2) <= 7){
            if((col + 1) <= 7){ 
                if(get_game().get_board().isPieceAt(row + 2, col + 1) == false){
                    threateningLocations.add(new ChessLocation(row + 2, col + 1));
                }
                else if(get_game().get_board().isPieceAt(row + 2, col + 1) == true && !(get_game().get_board().piece_Board(row + 2, col +1).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row + 2, col + 1));
                }
            }
            if((col - 1) >= 0){ 
                if(get_game().get_board().isPieceAt(row + 2, col - 1) == false){
                    threateningLocations.add(new ChessLocation(row + 2, col - 1));
                }
                else if(get_game().get_board().isPieceAt(row + 2, col - 1) == true && !(get_game().get_board().piece_Board(row + 2, col - 1).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row + 2, col - 1));
                }
            }
        }
        if((row - 2) >= 0){
            if((col + 1) <= 7){ 
                if(get_game().get_board().isPieceAt(row - 2, col + 1) == false){
                    threateningLocations.add(new ChessLocation(row - 2, col + 1));
                }
                else if(get_game().get_board().isPieceAt(row - 2, col + 1) == true && !(get_game().get_board().piece_Board(row - 2, col + 1).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row - 2, col + 1));
                }
            }
            if((col - 1) >= 0){ 
                if(get_game().get_board().isPieceAt(row - 2, col - 1) == false){
                    threateningLocations.add(new ChessLocation(row - 2, col - 1));
                }
                else if(get_game().get_board().isPieceAt(row - 2, col - 1) == true && !(get_game().get_board().piece_Board(row - 2, col - 1).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row - 2, col - 1));
                }
            }
        }
        if((col + 2) <= 7){
            if((row + 1) <= 7){ 
                if(get_game().get_board().isPieceAt(row + 1, col + 2) == false){
                    threateningLocations.add(new ChessLocation(row + 1, col + 2));
                }
                else if(get_game().get_board().isPieceAt(row + 1, col + 2) == true && !(get_game().get_board().piece_Board(row + 1, col + 2).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row + 1, col + 2));
                }
            }
            if((row - 1) >= 0){ 
                if(get_game().get_board().isPieceAt(row - 1, col + 2) == false){
                    threateningLocations.add(new ChessLocation(row - 1, col + 2));
                }
            }
        }
        if((col - 2) >= 0){
            if((row + 1) <= 7){ 
                if(get_game().get_board().isPieceAt(row + 1, col - 2) == false){
                    threateningLocations.add(new ChessLocation(row + 1, col - 2));
                }
                else if(get_game().get_board().isPieceAt(row + 1, col - 2) == true && !(get_game().get_board().piece_Board(row + 1, col - 2).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row + 1, col - 2));
                }
            }
            if((row - 1) >= 0){ 
                if(get_game().get_board().isPieceAt(row - 1, col - 2) == false){
                    threateningLocations.add(new ChessLocation(row - 1, col -2));
                }
                else if(get_game().get_board().isPieceAt(row - 1, col - 2) == true && !(get_game().get_board().piece_Board(row - 1, col - 2).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row - 1, col - 2));
                }
            }
        }
    }
}

