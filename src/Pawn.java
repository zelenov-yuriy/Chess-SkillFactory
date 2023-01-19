public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(toLine<0 || toLine>7 || toColumn<0 || toColumn>7)
            return false;
        if(getColor().equals("White")) {
            if(chessBoard.board[toLine][toColumn]==null) {
                if(toColumn == column) {
                    if(toLine == line+1)
                        return true;
                    else if(toLine == line+2 && line==1)
                        return true;
                }
            }
            else if(chessBoard.board[toLine][toColumn].getColor().equals("Black")) {
                if (toColumn == column-1 || toColumn == column+1)
                    if (toLine == line+1)
                        return true;
            }
        }
        else {
            if(chessBoard.board[toLine][toColumn]==null) {
                if(toColumn == column) {
                    if(toLine == line-1)
                        return true;
                    else if(toLine == line-2 && line==6)
                        return true;
                }
            }
            else if(chessBoard.board[toLine][toColumn].getColor().equals("White")) {
                if (toColumn == column-1 || toColumn == column+1)
                    if (toLine == line-1)
                        return true;
            }
        }
        return false;
    }

    public String getSymbol() {
        return "P";
    }
}
