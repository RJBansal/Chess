import java.util.*;
/**
 * Write a description of class ChessPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class ChessPiece implements ChessPieceInterface
{
    private ChessGame game1;
    private String player; 
    private ChessLocation location; 
    protected String id;
    protected ArrayList<ChessLocation> threateningLocations;

    public ChessPiece(String owner, ChessLocation intialLocation, ChessGame game){ 

        this.player = owner; 
        this.location = intialLocation;
        this.game1 = game;
        game1.get_board().placePieceAt(this,intialLocation);
        threateningLocations = new ArrayList<>();

    } 

    public String get_player()
    { 
        return this.player;    
    }

    public void set_player(String player)
    {
        this.player = player;
    }
    //sets the row of the knight 
    public void set_row(int x){ 
        this.location.set_row(x);
    } 
    //sets the coloumn of the knight 
    public void set_col(int y){ 
        this.location.set_col(y);
    } 
    //returns the row of the knight
    public int get_row(){ 
        return location.get_row(); 
    } 
    //returns the coloumn of the knight 
    public int get_col(){ 
        return location.get_col();
    } 

    public String get_id(){ 
        return this.id;
    }

    public ChessLocation get_loc()
    {
        return location;
    }

    public ChessGame get_game(){
        return this.game1;
    }

    public ArrayList get_ThreateningLocations(){
        return this.threateningLocations;
    }

    public boolean moveTo(ChessLocation newLocation){

        if (newLocation.get_col() <= 7 && newLocation.get_row() <= 7){
            if(newLocation.get_col() >= 0 && newLocation.get_row() >= 0){
                if(get_game().get_board().isPieceAt(newLocation.get_row(), newLocation.get_col()) == true){
                    if(!(get_player().equals(get_game().get_board().piece_Board(newLocation.get_row(), newLocation.get_col()).get_player()))){
                        this.game1.get_board().removePiece(location);
                        this.game1.get_board().placePieceAt(this, newLocation);
                        this.updateThreateningLocation(newLocation);
                        this.game1.get_board().print_board();
                        return true;
                    }
                    else{
                        System.out.println("Invalid Move. Cannot kill own piece\n");
                        return false;
                    }
                }
                else{
                    this.game1.get_board().removePiece(location);
                    this.game1.get_board().placePieceAt(this, newLocation);
                    this.updateThreateningLocation(newLocation);
                    this.game1.get_board().print_board();
                    return true;
                }
            }
            else System.out.println("Invalid Move. Out of Bounds\n"); return false;
        } 
        else System.out.println("Invalid Move. Out of Bounds\n"); return false;
    }

    protected boolean checkLineOfSight(ChessLocation start, ChessLocation end){
        int distance_y = end.get_row()-start.get_row();
        int distance_x = end.get_col()-start.get_col();  
        int inc_x = 1;
        int inc_y = 1;
        int distance = distance_y;
        if(distance_y < 0){
            inc_y = -1;}
        if(distance_x < 0){ 
            inc_x = -1;}
        if(distance_x == 0){
            inc_x = 0;}
        if(distance_y == 0){
            inc_y = 0;}
        if(distance_y == 0){ 
            distance = distance_x;} 

        int row = start.get_row() + inc_y;
        int col = start.get_col() + inc_x; 
        for(int i = 0; i < (Math.abs(distance)-1) ; i++){ 

            boolean check = this.game1.get_board().isPieceAt(row,col);
            if(check == true){ 
                System.out.println("Invalid Move. Piece in between\n");
                return false;
            }
            row = row + inc_y;
            col = col + inc_x;
        }
        return true;
    }

    protected void updateThreateningLocation(ChessLocation newLocation){
    }
}

