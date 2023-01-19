public class Bishop extends ChessPiece {
    public Bishop(String color) {
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
        if(Math.abs(toLine-line)==Math.abs(toColumn-column) && toLine!=line) {
            int n = Math.abs(toLine-line);
            int x = 0, y = 0;
            for(int i=1; i<n; i++) {
                if(toLine>line)
                    x = line+i;
                else
                    x = line-i;
                if(toColumn>column)
                    y = column+i;
                else
                    y = column-i;
                if(chessBoard.board[x][y] != null)
                    return false;
            }
            return true;
        }
        return false;
    }

    public String getSymbol() {
        return "B";
    }
}
