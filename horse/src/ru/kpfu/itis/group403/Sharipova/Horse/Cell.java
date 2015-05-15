package ru.kpfu.itis.group403.Sharipova.Horse;

import java.util.ArrayList;

public class Cell {

    private Location location;
    private boolean horse;
    private ArrayList<Location> ways;
    private boolean pass = false;

    public Cell getParent() {
        return parent;
    }

    public void setParent(Cell parent) {
        this.parent = parent;
    }

    private Cell parent;


    public Cell(int x, int y, int[][] board) {
        //path = "";
        parent = null;
        location = new Location(x, y);
        this.horse = board[x][y] == 0;
        int nX;
        int nY;
        int size = board.length;
        ways = new ArrayList<>();
        if (size - y > 2) {
            if (x > 0)
                if (board[x - 1][y + 2] >= 0)
                    ways.add(new Location(x - 1, y + 2));
            if (size - x > 1)
                if (board[x + 1][y + 2] >= 0)
                    ways.add(new Location(x + 1, y + 2));
        }
        if (size - x > 2) {
            if (size - y > 1)
                if (board[x + 2][y + 1] >= 0)
                    ways.add(new Location(x + 2, y + 1));
            if (y > 0)
                if (board[x + 2][y - 1] >= 0)
                    ways.add(new Location(x + 2, y - 1));
        }
        if (y > 1) {
            if (x > 0)
                if (board[x - 1][y - 2] >= 0)
                    ways.add(new Location(x - 1, y - 2));
            if (size - x > 1)
                if (board[x + 1][y - 2] >= 0)
                    ways.add(new Location(x + 1, y - 2));
        }
        if (x > 1) {
            if (size - y > 1)
                if (board[x - 2][y + 1] >= 0)
                    ways.add(new Location(x - 2, y + 1));
            if (y > 0)
                if (board[x - 2][y - 1] >= 0)
                    ways.add(new Location(x - 2, y - 1));
        }
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isHorse() {
        return horse;
    }

    public void setHorse(boolean horse) {
        this.horse = horse;
    }

    public ArrayList<Location> getWays() {
        return ways;
    }

    public void setWays(ArrayList<Location> ways) {
        this.ways = ways;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public void showWays() {
        for (Location i : ways) {
            System.out.println(i.getX() + " " + i.getY());
        }
    }
}
