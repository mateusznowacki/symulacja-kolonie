package com.simulaton.app.map;

import java.util.Objects;

/**
 * Class Position
 */

public class NPosition {
    private int x;
    private int y;

    public NPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPosition nPosition = (NPosition) o;
        return x == nPosition.x && y == nPosition.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
