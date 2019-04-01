package com.codecool;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Battleship {
    private int startX;
    private int startY;
    private int length;

    public Battleship(int startX, int startY, int length) {
        this.startX = startX;
        this.startY = startY;
        this.length = length;
    }

    public Battleship(int[] sizes) {
        if (sizes.length >= 3) {
            this.startX = sizes[0];
            this.startY = sizes[1];
            this.length = sizes[2];
        } else {
            throw new InvalidParameterException();
        }
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getLength() {
        return length;
    }

    public static List<Battleship> getBattleships(int[][] sizes) {
        if (isInvalidParameter(sizes)) {
            throw new InvalidParameterException();
        } else {
            return Arrays.stream(sizes)
                    .map(Battleship::new)
                    .collect(Collectors.toList());
        }
    }

    private static boolean isInvalidParameter(int[][] sizes) {
        return sizes.length == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battleship that = (Battleship) o;
        return startX == that.startX &&
                startY == that.startY &&
                length == that.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startX, startY, length);
    }
}
