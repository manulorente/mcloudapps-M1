package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;
import mcloudapps.utils.models.Coordinate;

public class Game {
   
    private Board board;
    private Turn turn;
    private Result result;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
        this.result = new Result(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    } 

    public int getNumberOfRows() {
        return Board.getNumberOfRows();
    }

    public int getNumberOfColumns() {
        return Board.getNumberOfColumns();
    }

    public void next() {
        this.turn.nextPlayer();
    }

    public Color getActivePlayerColor() {
        return this.turn.getActivePlayer().getColor();
    }

    public boolean isEmpty(Coordinate coordinate) {
        return this.board.isEmpty(coordinate);
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public void putToken(int column, Color color) {
        this.board.putToken(column, color);
    }

    public Error getPutTokenError(int column) {
        return this.turn.getPutTokenError(column);
    }

    public boolean isGameOver() {
        return this.result.isGameOver();
    }

    public Color getResult() {
        return this.result.getResult();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Game game = (Game) object;
        return this.board.equals(game.board) && this.turn.equals(game.turn) && this.result.equals(game.result);
    }

}