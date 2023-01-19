public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if(toLine<0 || toLine>7 || toColumn<0 || toColumn>7)
            return false;
        if(chessBoard.board[toLine][toColumn]!=null)
            if(chessBoard.board[toLine][toColumn].getColor().equals(getColor()))
                return false;
        if(toLine==line-2 && toColumn==column+1)
            return true;
        if(toLine==line-1 && toColumn==column+2)
            return true;
        if(toLine==line+1 && toColumn==column+2)
            return true;
        if(toLine==line+2 && toColumn==column+1)
            return true;
        if(toLine==line+2 && toColumn==column-1)
            return true;
        if(toLine==line+1 && toColumn==column-2)
            return true;
        if(toLine==line-1 && toColumn==column-2)
            return true;
        if(toLine==line-2 && toColumn==column-1)
            return true;
        return false;
    }

    public String getSymbol() {
        return "H";
    }
}
