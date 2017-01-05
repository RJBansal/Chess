import java.util.*;
/**
 * Author Rajat Bansal (10101954) Chess
 * Play game executes the other classes and runs the logic of chess. Decides the players turn and uses user input to 
 * move pieces on the board
 */
public class PlayGame
{
    /**
     * Main executes the logic of the game
     */

    public static void main(String[]args){ 

        System.out.println("CHESSGAME by Rajat Bansal(101019954) \n\nType in the Following Format 'Move 1 2 to 3 4'. Ensure it is exactly the same format, space between each digit\nType Quit to quit the game\nThe knight starts at 0 1\nEnjoy"); 
        ChessGame game = new ChessGame("p1", "p2"); 
        game.get_board().print_board();

        int x; 
        int y;  
        int x_final; 
        int y_final;  
        int turn = 1;
        boolean hasMoved = false; 
        ChessPiece check1 = null; 
        ChessPiece check2 = null; 
        ChessLocation k1Loc = new ChessLocation (0,4);
        ChessLocation k2Loc = new ChessLocation (7,3);

        /** 
         * While loop executes constant user input to prompt for what piece needs to be moved
         * Sends information to knight class, to execute valid move 
         */

        while(true){
            Scanner reader = new Scanner(System.in); //creates scanner for user input 
            System.out.println("Enter a move or type Quit: "); 
            String store = reader.nextLine(); //stores the input into a string
            String[] input = store.split( " " ); //splits the string by a space and stores it into an array 

            //checks if user wants to quit the game
            if (input[0].equalsIgnoreCase("Quit")){ 
                break;
            }
            if(input[0].equalsIgnoreCase("Restart")){
                game = new ChessGame("p1", "p2");
                game.get_board().print_board();
                turn = 1; 
            }
            //if input is a command, x,y and final x,y cordinates are extracted from input
            else{ 

                x = Integer.parseInt(input[1]); // changes x string coord into an integer
                y = Integer.parseInt(input[2]);  //changes y string coord into an integer
                x_final = Integer.parseInt(input[4]);
                y_final = Integer.parseInt(input[5]); // changes y final string coord into integer
                ChessLocation loc2 = new ChessLocation(x_final,y_final);

                if (x_final <= 7 && y_final <= 7){
                    if(x_final >= 0 && y_final >= 0){
                        if(game.get_board().isPieceAt(x, y) == true){
                            if(turn == 1 && game.get_board().piece_Board(x,y).get_player() == "p1"){
                                hasMoved = game.get_board().piece_Board(x,y).moveTo(new ChessLocation(x_final,y_final)) == true;
                                if(hasMoved && game.get_board().piece_Board(x_final,y_final).get_id().equals(" |K| ")){
                                    k1Loc.set_xy(x_final, y_final);
                                }
                                if(hasMoved && game.get_board().piece_Board(x_final,y_final).get_loc().equals(k2Loc)){
                                    System.out.println("Player 1 wins!");
                                    break;
                                }
                                check2 = ((King)game.get_board().piece_Board(k2Loc.get_row(),k2Loc.get_col())).check();
                                if(check2!= null)
                                    System.out.println("Player2's King is in check by "+ check2.get_loc().get_row() + "," + check2.get_loc().get_col());
                                if(hasMoved)
                                    turn = 0;

                            }
                            else if(turn == 0 && game.get_board().piece_Board(x,y).get_player() == "p2"){
                                hasMoved = game.get_board().piece_Board(x,y).moveTo(new ChessLocation(x_final,y_final)) == true;
                                if(hasMoved && game.get_board().piece_Board(x_final,y_final).get_id().equals(" |k| ")){
                                    k2Loc.set_xy(x_final, y_final); 
                                }
                                if(hasMoved && game.get_board().piece_Board(x_final,y_final).get_loc().equals(k1Loc)){
                                    System.out.println("Player 2 wins!");
                                    break;
                                }
                                check1 = ((King)game.get_board().piece_Board(k1Loc.get_row(),k1Loc.get_col())).check();
                                if(check1!= null)
                                    System.out.println("Player1's King is in check by "+ check1.get_loc().get_row() + "," + check1.get_loc().get_col());
                                if(hasMoved)
                                    turn = 1;
                            }
                            else{ 
                                System.out.println("Wrong player");
                            }
                        }
                    }
                    else{
                        System.out.println("Out of Bounds\n");
                    }
                }
                else{
                    System.out.println("Out of Bounds\n");  
                }
            }
        }
    }
}

