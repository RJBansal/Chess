
/**
 * Author Rajat Bansal (101019954)
 * ChessLocation stores and returns the location of a piece at a given location on the board 
 */
public class ChessLocation
{
    private int row; 
    private int col; 
    //ChessLocation constructor creates an new location object with x and y coordinates 
    public ChessLocation (int x, int y)
    {  
        this.row = x; 
        this.col = y; 
    }
    // sets the row of the piece
    public void set_row (int x)
    { 
        this.row = x;   
    }
    //sets the col of the piece
    public void set_col (int y)
    { 
        this.col = y;   
    }
    //sets the row and col of the piece 
    public void set_xy (int x, int y){ 
        this.row = x; 
        this.col = y; 
    } 
    //returns the row of the piece 
    public int get_row ()
    { 
        return this.row;
    }
    //returns the col of the piece 
    public int get_col ()
    { 
        return this.col;  
    }
   public boolean equals(Object cp){
        boolean check = false; 
        
        if(cp!= null && cp instanceof ChessLocation){ 
            ChessLocation o = (ChessLocation)cp;
            check = this.get_row() == o.get_row() && this.get_col() == o.get_col();
        }
        return check;
    }
}
