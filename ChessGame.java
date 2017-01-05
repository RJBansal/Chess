import java.util.*;
/**
 * Author Rajat Bansal (101019954)
 * Assigns all pieces and game board to one game obect. 
 * Initiallizes and sets each piece to its initial location and places them on the board
 */
public class ChessGame
{
    private ChessBoard board; //initializes chessboard 
    private String player_1, player_2;
    ChessPiece Knight1,Knight2,Bishop1,Bishop2,Rook1,Rook2,Queen,King;
    ChessPiece Knight3,Knight4,Bishop3,Bishop4,Rook3,Rook4,Queen1,King1;
    private ChessLocation loc;
    private ChessPiece[] Pawn = new Pawn[8];
    private ChessPiece[] Pawn1 = new Pawn[8];
    private List<ChessPiece> playa1 = new ArrayList<ChessPiece>();
    private List<ChessPiece> playa2 = new ArrayList<ChessPiece>();
    /**
     * Constructor with no parameters, sets the initial location of all the pieces.
     * and places them on the board
     */
    public ChessGame(String player1, String player2)
    {
        board = new ChessBoard();
        this.player_1 = player1;
        this.player_2 = player2;

        Knight1 = new Knight(player_1, new ChessLocation(0,1), this);
        Knight2 = new Knight(player_1, new ChessLocation(0,6), this);
        Rook1 = new Rook(player_1, new ChessLocation(0,0), this);
        Rook2 = new Rook(player_1, new ChessLocation(0,7), this);
        Bishop1 = new Bishop(player_1, new ChessLocation(0,2), this);
        Bishop2 = new Bishop(player_1, new ChessLocation(0,5), this);
        Queen = new Queen(player_1, new ChessLocation(0,3), this);
        King = new King(player_1, new ChessLocation(0,4), this);
        playa1.add(Knight1);
        playa1.add(Knight2);
        playa1.add(Bishop1);
        playa1.add(Bishop2); 
        playa1.add(Rook1);
        playa1.add(Rook2);
        playa1.add(Queen);
        playa1.add(King);
        for (int i = 0; i <= 7; i++){
            Pawn[i] = new Pawn(player_1, new ChessLocation(1,i), this); 
            board.placePieceAt(Pawn[i], new ChessLocation(1, i));
        }
        for (int i = 0; i <= 7; i++){
            playa1.add(Pawn[i]);
        }

        
        Knight3 = new Knight(player_2, new ChessLocation(7,1), this);
        Knight4 = new Knight(player_2, new ChessLocation(7,6), this);
        Rook3 = new Rook(player_2, new ChessLocation(7,0), this);
        Rook4 = new Rook(player_2, new ChessLocation(7,7), this);
        Bishop3 = new Bishop(player_2, new ChessLocation(7,2), this);
        Bishop4 = new Bishop(player_2, new ChessLocation(7,5), this);
        Queen1 = new Queen(player_2, new ChessLocation(7,4), this);
        King1 = new King(player_2, new ChessLocation(7,3), this);
        for (int i = 0; i <= 7; i++){
            Pawn1[i] = new Pawn(player_2, new ChessLocation(6,i), this); 
            board.placePieceAt(Pawn1[i], new ChessLocation(6, i));
        }
        playa2.add(Knight3);
        playa2.add(Knight4);
        playa2.add(Bishop3);
        playa2.add(Bishop4); 
        playa2.add(Rook3);
        playa2.add(Rook4);
        playa2.add(Queen1);
        playa2.add(King1);
        for (int i = 0; i <= 7; i++){
          playa2.add(Pawn1[i]);
        }

        

    }
    //returns the first player color
    public void set_player_1(String playr){ 
        this.player_1 = playr; 
    }
    //returns the second player color
    public void set_player_2(String playr){ 
        this.player_2 = playr; 
    }
    //returns the chessboard the game will be played oin 
    public ChessBoard get_board(){ 
        return this.board; 
    }

    public void add(){

    }
    public List<ChessPiece> g_playa1(){
        return this.playa1;
    }

    public List<ChessPiece> g_playa2(){
        return this.playa2;
    }

    public ChessPiece g_kt1(){
        return this.Knight1;
    }

    public ChessPiece g_kt2(){
        return this.Knight2;
    }

    public ChessPiece g_kt3(){
        return this.Knight3;
    }

    public ChessPiece g_kt4(){
        return this.Knight4;
    }

    public ChessPiece g_b1(){
        return this.Bishop1;
    }

    public ChessPiece g_b2(){
        return this.Bishop2;
    }

    public ChessPiece g_b3(){
        return this.Bishop3;
    }

    public ChessPiece g_b4(){
        return this.Bishop4;
    }

    public ChessPiece g_r1(){
        return this.Rook1;
    }

    public ChessPiece g_r2(){
        return this.Rook2;
    }

    public ChessPiece g_r3(){
        return this.Rook3;
    }

    public ChessPiece g_r4(){
        return this.Rook4;
    }

    public ChessPiece g_q1(){
        return this.Queen;
    }

    public ChessPiece g_q2(){
        return this.Queen1;
    }

    public ChessPiece g_k1(){
        return this.King;
    }

    public ChessPiece g_k2(){
        return this.King1;
    }

    public ChessPiece[] g_p1(){
        return this.Pawn;
    }

    public ChessPiece[] g_p2(){
        return this.Pawn1;
    }

}
