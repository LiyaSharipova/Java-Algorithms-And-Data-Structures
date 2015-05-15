package ru.kpfu.itis.group403.Sharipova.Horse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PathFinder {
    private int[][] board;
    private Cell[][] boardGraph;
    private Location horse;
    private Location horse2;
    public static final char EMPTY = '0';
    public static final char NOTEMPTY = '#';
    public static final char HOARSE = '*';

    public PathFinder(File txt) throws IOException {
        readFile(txt);

    }

    private void readFile(File txt) throws IOException {
        try (
                BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(txt)))) {
            String len = r.readLine();
            int n = Integer.parseInt(len);
            int i = n - 1;
            boolean f = false;
            board = new int[n][n];
            while ((len = r.readLine()) != null) {
                for (int j = 0; j < n; j++) {
                    switch (len.charAt(j)) {
                        case EMPTY:
                            board[j][i] = 1;
                            break;
                        case NOTEMPTY:
                            board[j][i] = -1;
                            break;
                        case HOARSE:
                            if (!f) {
                                board[j][i] = 1;
                                horse = new Location(j, i);
                                f = true;
                            } else {
                                board[j][i] = 0;
                                horse2 = new Location(j, i);
                            }
                            break;

                        default:
                            throw new NumberFormatException("Wrong symbol" + len.charAt(j));
                    }

                }
                i--;
            }
        }
    }

    public String find() {
        BoardFactory factory = new BoardFactory(board);
        boardGraph = factory.createBoard();
        boardGraph[horse.getX()][horse.getY()].setPass(true);
        go(boardGraph[horse.getX()][horse.getY()].getWays());
        Cell cell = boardGraph[horse2.getX()][horse2.getY()];
        String path = horse2.getX() + "-" + horse2.getY();
        while (cell.getParent() != null) {
            cell = cell.getParent();
            path = cell.getLocation().getX() + "-" + cell.getLocation().getY() + "," + path;
        }
        path = horse.getX() + "-" + horse.getY() + "," + path;
        return path;
    }

    public void go(ArrayList<Location> cells) {

        ArrayList<Location> newCells = new ArrayList<>();
        for (Location i : cells) {
            Cell cellGoFrom = boardGraph[i.getX()][i.getY()];
            if (!cellGoFrom.isPass()) {
                cellGoFrom.setPass(true);
                newCells.addAll(cellGoFrom.getWays());
            }
            for (Location j : cellGoFrom.getWays()) {
                Cell cellGoTo = boardGraph[j.getX()][j.getY()];
                if (!cellGoTo.isPass())
                    cellGoTo.setParent(cellGoFrom);
            }
        }
        if (!newCells.isEmpty())
            go(newCells);
    }

    public static void main(String[] args) {
        try {
            PathFinder test = new PathFinder(new File("horse.txt"));
            System.out.println(test.find());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
