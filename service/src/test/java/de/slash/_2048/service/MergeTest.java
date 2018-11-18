package de.slash._2048.service;

import de.slash._2048.model.Cell;
import de.slash._2048.model.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class MergeTest
{
    @Test
    void testSample1()
    {
        Cell[] input = {new Cell(1, 0, 2), new Cell(1, 1, 2), new Cell(1, 2, 4), new Cell(1, 3, null)};
        Cell[] expected = {new Cell(1, 0, 4), new Cell(1, 1, 4), new Cell(1, 2, null), new Cell(1, 3, null)};
        testMerge(input, Direction.LEFT, expected);
    }

    @Test
    void testSample2()
    {
        Cell[] input = {new Cell(1, 0, 2), new Cell(1, 1, null), new Cell(1, 2, null), new Cell(1, 3, null)};
        Cell[] expected = {new Cell(1, 0, 2), new Cell(1, 1, null), new Cell(1, 2, null), new Cell(1, 3, null)};
        testMerge(input, Direction.LEFT, expected);
    }

    @Test
    void testSample3()
    {
        Cell[] input = {new Cell(1, 0, 4), new Cell(1, 1, null), new Cell(1, 2, 2), new Cell(1, 3, 2)};
        Cell[] expected = {new Cell(1, 0, 4), new Cell(1, 1, 4), new Cell(1, 2, null), new Cell(1, 3, null)};
        testMerge(input, Direction.LEFT, expected);
    }

    @Test
    void testSample4()
    {
        Cell[] input = {new Cell(1, 0, 2), new Cell(1, 1, 2), new Cell(1, 2, null), new Cell(1, 3, 2)};
        Cell[] expected = {new Cell(1, 0, 4), new Cell(1, 1, 2), new Cell(1, 2, null), new Cell(1, 3, null)};
        testMerge(input, Direction.LEFT, expected);
    }

    @Test
    void testSample5()
    {
        Cell[] input = {new Cell(1, 0, 2), new Cell(1, 1, null), new Cell(1, 2, 2), new Cell(1, 3, 2)};
        Cell[] expected = {new Cell(1, 0, 4), new Cell(1, 1, 2), new Cell(1, 2, null), new Cell(1, 3, null)};
        testMerge(input, Direction.LEFT, expected);
    }

    @Test
    void testSample6()
    {
        Cell[] input = {new Cell(1, 0, 2), new Cell(1, 1, 2), new Cell(1, 2, null), new Cell(1, 3, null)};
        Cell[] expected = {new Cell(1, 0, null), new Cell(1, 1, null), new Cell(1, 2, null), new Cell(1, 3, 4)};
        testMerge(input, Direction.RIGHT, expected);
    }

    @Test
    void testSample7()
    {
        Cell[] input = {new Cell(1, 0, 4), new Cell(1, 1, 2), new Cell(1, 2, null), new Cell(1, 3, null)};
        Cell[] expected = {new Cell(1, 0, null), new Cell(1, 1, null), new Cell(1, 2, 4), new Cell(1, 3, 2)};
        testMerge(input, Direction.RIGHT, expected);
    }

    private void testMerge(Cell[] input, Direction direction, Cell[] expected)
    {
        GameBoardService service = new GameBoardService();
        Cell[] result = service.moveAndMergeEqual(input, direction);
        assertArrayEquals(expected, result);
    }
}