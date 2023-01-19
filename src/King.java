public class King extends ChessPiece {
    public King(String color) {
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
        if(toLine==line+1 && toColumn==column+1 && !isUnderAttack(chessBoard, toLine, toColumn))
            return true;
        else if(toLine==line && toColumn==column+1 && !isUnderAttack(chessBoard, toLine, toColumn))
            return true;
        else if(toLine==line-1 && toColumn==column+1 && !isUnderAttack(chessBoard, toLine, toColumn))
            return true;
        else if(toLine==line-1 && toColumn==column && !isUnderAttack(chessBoard, toLine, toColumn))
            return true;
        else if(toLine==line-1 && toColumn==column-1 && !isUnderAttack(chessBoard, toLine, toColumn))
            return true;
        else if(toLine==line && toColumn==column-1 && !isUnderAttack(chessBoard, toLine, toColumn))
            return true;
        else if(toLine==line+1 && toColumn==column-1 && !isUnderAttack(chessBoard, toLine, toColumn))
            return true;
        else if(toLine==line+1 && toColumn==column && !isUnderAttack(chessBoard, toLine, toColumn))
            return true;
        return false;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        boolean result = false;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(i==line && j==column)
                    continue;
                if(chessBoard.board[i][j] == null)
                    continue;
                if(chessBoard.board[i][j].getColor().equals(getColor()))
                    continue;
                if(chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column))
                        result = true;
            }
        }
        return result;
    }
}