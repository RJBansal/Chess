import java.util.*;
/** 
 * Author Rajat Bansal (101019954) 
 * Creates a Knight class and sets properties of color, image, location and valid moves. 
 * Getters and Setters for each property

 */
public class Bishop extends ChessPiece
{
    /** 
     * Knight constructor which creates a new knight with the parameters owner, location and the game 
     * it belongs to. 
     */
    public Bishop(String owner, ChessLocation intialLocation, ChessGame game)
    {
        super(owner,intialLocation,game);
        if(owner == "p1"){ 
            id = " |B| ";
        }
        else{
            id = " |b| ";
        }

    }

    /** 
     * Checks the valid moves for a knight piece. If within range of board and valid moves, it
     * removes piece from old location and relocates it at the new valid location. 
     */

    public boolean moveTo(ChessLocation newLocation)
    { 
        double check = (newLocation.get_col() - get_col())%(newLocation.get_row() - get_row());

        if( check == 0){ 
            if(checkLineOfSight(get_loc(), newLocation) == true){ 
                if(super.moveTo(newLocation) == true){
                return true;}
                else return false;
            }
        }
        else { 
            System.out.println("Invalid Move for Bishop\n");
            return false;
        }
        return false;
    }

    protected void updateThreateningLocation(ChessLocation newLocation){
        int distanceYP = (7 - newLocation.get_row());
        int distanceYN = newLocation.get_row(); 
        int distanceHP = (7 - newLocation.get_col());
        int distanceHN = newLocation.get_col();
        int incYP = 1;
        int incYN = -1;
        int incHP = 1;
        int incHN = -1; 
        if(distanceYP == 0){
            incYP = 0;}
        if(distanceYN == 0){ 
            incYN = 0;}
        if(distanceHP == 0){
            incHP = 0;}
        if(distanceHN == 0){
            incHN = 0;}  
         int dis1 = 0; 
         int dis2 = 0; 
         int dis3 = 0; 
         int dis4 = 0;
        if(distanceYP >= distanceHP){
            dis1 = distanceHP;
        }
        else dis1 = distanceYP;
        if(distanceYP >= distanceHN){
            dis2 = distanceHN;
        }
        else dis2 = distanceYP;
        if(distanceYN >= distanceHP){
            dis3 = distanceHP;
        }
        else dis3 = distanceYN;
        if(distanceYN >= distanceHN){
            dis4 = distanceHN;
        }
        else dis4 = distanceYN;
        threateningLocations.clear(); 
        int row = newLocation.get_row() + incYP;
        int col = newLocation.get_col() + incHP;
        for(int i = dis1; i > 1; i--){ 
            if(get_game().get_board().isPieceAt(row, col) == false){
                threateningLocations.add(new ChessLocation(row,col)); 
            }
            else {
                break;
            }
            row += incYP; 
            col += incHP;
        }
        row = newLocation.get_row() + incYP;
        col = newLocation.get_col() + incHN;
        for(int i = dis2; i > 1; i--){ 
            if(get_game().get_board().isPieceAt(row, col) == false){
                threateningLocations.add(new ChessLocation(row,col)); 
            }
            else {
                break;
            }
            row += incYP; 
            col += incHN;
        }
        row = newLocation.get_row() + incYN;
        col = newLocation.get_col() + incHP;
        for(int i = dis3; i > 1; i--){ 
            if(get_game().get_board().isPieceAt(row, col) == false){
                threateningLocations.add(new ChessLocation(row,col)); 
            }
            else {
                break;
            }
            row += incYN; 
            col += incHP;
        }
        row = newLocation.get_row() + incYN;
        col = newLocation.get_col() + incHN;
        for(int i = dis4; i > 1; i--){ 
            if(get_game().get_board().isPieceAt(row, col) == false){
                threateningLocations.add(new ChessLocation(row,col)); 
            }
            else {
                break;
            }
            row += incYN; 
            col += incHN;
        }
    }
}

