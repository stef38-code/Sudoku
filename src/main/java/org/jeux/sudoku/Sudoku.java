package org.jeux.sudoku;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Sudoku {
    int[][] sudokuGrille;

    public void setGrille(int[][] sudokuGrilleEmpty) {
        this.sudokuGrille = sudokuGrilleEmpty;
    }

    public boolean resoudre() {
        return checkNotEmpty() && checkSize();
    }

    private boolean checkSize() {
        return !ArrayUtils.isEmpty(sudokuGrille)
                && sudokuGrille.length == 9
                && Arrays.stream(sudokuGrille).noneMatch(row -> row.length != 9);
    }

    private boolean checkNotEmpty() {
        return !ArrayUtils.isEmpty(sudokuGrille)
                && Arrays.stream(sudokuGrille)
                .flatMapToInt(Arrays::stream)
                .anyMatch(cell -> cell != 0);
    }
}
