package ru.kpfu.itis.group403.Sharipova.Horse;


public class BoardFactory {
    private int[][] board; //-1 занято, 1 свободно, 0 конь


    public BoardFactory(int[][] board) {
        boolean check = true;
        for (int i = 0; i < board.length; i++)
            if (board[i].length != board.length)
                check = false;
        if (check)
            this.board = board;
    }

    public Cell[][] createBoard() {
        Cell[][] boardGraph = new Cell[board.length][board.length];
        for (int x = 0; x < boardGraph.length; x++)
            for (int y = 0; y < boardGraph.length; y++)
                boardGraph[x][y] = new Cell(x, y, this.board);
        return boardGraph;
    }

}
