package com.codecool;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple BattleshipGen.
 */
public class BattleshipGenTest
{

    @Test
    public void shouldAnswerWithTrue()
    {
        int[] size1 = {1, 2, 3};
        int[] size2 = {2, 3, 4};
        int[] size3 = {69, 69, 69};
        int[][] shipSizes = {size1, size2, size3};
        List<Battleship> expected = new ArrayList<>();
        expected.add(new Battleship(size1));
        expected.add(new Battleship(size2));
        expected.add(new Battleship(size3));

        List<Battleship> actual = Battleship.getBattleships(shipSizes);

        assertThat(actual, is(expected));
    }
}
