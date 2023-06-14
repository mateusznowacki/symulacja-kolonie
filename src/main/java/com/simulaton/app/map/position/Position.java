package com.simulaton.app.map.position;

import java.util.Objects;

/**
 * The type Position.
 */
public class Position {
    private final int x;
    private final int y;

    /**
     * Instantiates a new Position.
     *
     * @param x the x
     * @param y the y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
