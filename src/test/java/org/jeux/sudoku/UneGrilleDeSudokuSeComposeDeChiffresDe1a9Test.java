package org.jeux.sudoku;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UneGrilleDeSudokuSeComposeDeChiffresDe1a9Test {
    public static final int[][] sudokuGrilleInvalid = {
            {5, 7, 4, 2, 8, 6, 3, 9, 99},// Invalid number 99
            {1, 3, 8, 7, 4, 9, 2, 5, 6},
            {2, 9, 6, 5, 3, 1, 4, 8, 7},
            {7, 1, 9, 6, -3, 3, 8, 4, 2},// Invalid number -3
            {4, 5, 3, 8, 2, 7, 1, 6, 9},
            {8, 6, 2, 1, 9, 4, 5, 7, 3},
            {6, 4, 7, 3, 1, 5, 9, 2, 8},
            {3, 8, 5, 9, 6, 2, 7, 1, 4},
            {9, 2, 1, 4, 7, 8, 6, 3, 10} // Invalid number 10
    };

    public static final int[][] sudokuGrilleValid = {
            {5, 7, 4, 2, 8, 6, 3, 9, 1},
            {1, 3, 8, 7, 4, 9, 2, 5, 6},
            {2, 9, 6, 5, 3, 1, 4, 8, 7},
            {7, 1, 9, 6, 5, 3, 8, 4, 2},
            {4, 5, 3, 8, 2, 7, 1, 6, 9},
            {8, 6, 2, 1, 9, 4, 5, 7, 3},
            {6, 4, 7, 3, 1, 5, 9, 2, 8},
            {3, 8, 5, 9, 6, 2, 7, 1, 4},
            {9, 2, 1, 4, 7, 8, 6, 3, 5}
    };

    @Test
    void verifier_sudoku_avec_chiffres_invalides_retourne_false() {
        Sudoku sudoku = new Sudoku();
        sudoku.setGrille(sudokuGrilleInvalid);
        assertThat(sudoku.resoudre()).isFalse();
    }

    @Test
    void verifier_sudoku_avec_chiffres_valides_retourne_true() {
        Sudoku sudoku = new Sudoku();
        sudoku.setGrille(sudokuGrilleValid);
        assertThat(sudoku.resoudre()).isTrue();
    }
}
