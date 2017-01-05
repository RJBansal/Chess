import java.util.*;
/** 
 * Author Rajat Bansal (101019954) 
 * Creates a Knight class and sets properties of color, image, location and valid moves. 
 * Getters and Setters for each property

 */
public class King extends ChessPiece
{
    /** 
     * Knight constructor which creates a new knight with the parameters owner, location and the game 
     * it belongs to. 
     */
    public King(String owner, ChessLocation intialLocation, ChessGame game)
    {
        super(owner,intialLocation,game);
        if(owner == "p1"){ 
            id = " |K| ";
        }
        else{
            id = " |k| ";
        }

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
        if((Math.abs(col_f - col_i) == 1) && (Math.abs(row_f - row_i)) == 1){
            if(locationInDanger(newLocation) == null){
                super.moveTo(newLocation);
                return true;
                //  else{return false;}
            }
            else{
                System.out.println("Can not move there, piece" + locationInDanger(newLocation).get_id() + "is threatening that location");
                return false;
            }
        }
        else if((Math.abs(row_f - row_i) == 1) && col_i == col_f){ 
            if((locationInDanger(newLocation) == null)){
                super.moveTo(newLocation);
                return true;
                // else{return false;}
            }
            else{
                System.out.println("Can not move there, piece" + locationInDanger(newLocation).get_id() + "is threatening that location");
                return false;
            }
        }
        else if((Math.abs(col_f - col_i) == 1) && row_i == row_f){ 
            if((locationInDanger(newLocation) == null)){
                super.moveTo(newLocation);
                return true;
                //else{return false;}
            }
            else{
                System.out.println("Can not move there, piece" + locationInDanger(newLocation).get_id() + "is threatening that location");
                return false;
            }
        }
        else{ 
            System.out.println("Invalid Move for King\n");
            return false;
        }
        // return false;
    }

    public void updateThreateningLocation(ChessLocation newLocation){ 
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
                if(get_game().get_board().isPieceAt(row + 1, col + 1) == true && !(get_game().get_board().piece_Board(row + 1,col + 1).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row + 1,col + 1));
                }
            }
            else{
                threateningLocations.add(new ChessLocation(row + 1,col + 1));
            }
            if((col - 1) >= 0){
                if(get_game().get_board().isPieceAt(row + 1, col - 1) == true && !(get_game().get_board().piece_Board(row + 1,col -1).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row + 1,col - 1));
                }
            }
            else{
                threateningLocations.add(new ChessLocation(row + 1,col - 1));
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
                if(get_game().get_board().isPieceAt(row - 1, col + 1) == true && !(get_game().get_board().piece_Board(row - 1,col + 1).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row - 1,col + 1));
                }
                else{
                    threateningLocations.add(new ChessLocation(row - 1,col + 1));
                }
            }
            if((col - 1) >= 0){
                if(get_game().get_board().isPieceAt(row - 1, col - 1) == true && !(get_game().get_board().piece_Board(row - 1,col - 1).get_player().equals(this.get_player()))){
                    threateningLocations.add(new ChessLocation(row - 1,col - 1));
                }
                else{
                    threateningLocations.add(new ChessLocation(row - 1,col - 1));
                }
            }
        }
    }

    public ChessPiece locationInDanger(ChessLocation destinationLocation){ 
        List<ChessPiece> pieceL = new ArrayList<ChessPiece>();
        if(this.get_player().equals("p2")){
            pieceL = get_game().g_playa1();
        }
        else{
            pieceL = get_game().g_playa2();
        }
        for(ChessPiece p: pieceL){
            p.updateThreateningLocation(p.get_loc());
            ArrayList<ChessLocation> cl = p.get_ThreateningLocations(); 
            for(ChessLocation temp: cl){
                if(temp.equals(destinationLocation)){
                    return p;
                }

            }

        }
        return null;  
    }

    
    public boolean anyMovesLeft(){
        for(ChessLocation temp: this.threateningLocations){
            if(!(this.locationInDanger(temp) instanceof ChessPiece)){
                return true;
            }
        }
        return false;   
    }

    public ChessPiece check(){ 
        return locationInDanger(this.get_loc());
    } 
}

