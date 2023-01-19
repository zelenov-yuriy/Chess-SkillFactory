public class Queen extends ChessPiece {
    public Queen(String color) {
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
            int x, y;
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
        else if(toLine==line && toColumn!=column) {
            int n = Math.abs(toColumn-column);
            int y;
            for(int i=1; i<n; i++) {
                if(toColumn>column)
                    y = column+i;
                else
                    y = column-i;
                if(chessBoard.board[line][y] != null)
                    return false;
            }
            return true;
        }
        else if(toLine!=line && toColumn==column) {
            int n = Math.abs(toLine-line);
            int x;
            for(int i=1; i<n; i++) {
                if(toLine>line)
                    x = line+i;
                else
                    x = line-i;
                if(chessBoard.board[x][column] != null)
                    return false;
            }
            return true;
        }
        return false;
    }

    public String getSymbol() {
        return "Q";
    }
}
