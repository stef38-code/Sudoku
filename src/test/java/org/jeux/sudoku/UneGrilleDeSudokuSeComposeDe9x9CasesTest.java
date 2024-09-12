package org.jeux.sudoku;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UneGrilleDeSudokuSeComposeDe9x9CasesTest {
    public static final int[][] sudokuGrilleEmpty = new int[9][9];
    public static final int[][] sudokuGrilleNotempty = {
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
    void verifier_sudoku_vide_retourne_false() {
        Sudoku sudoku = new Sudoku();
        sudoku.setGrille(sudokuGrilleEmpty);
        assertThat(sudoku.resoudre()).isFalse();
    }

    @Test
    void verifier_sudoku_non_vide_retourne_true() {
        Sudoku sudoku = new Sudoku();
        sudoku.setGrille(sudokuGrilleNotempty);
        assertThat(sudoku.resoudre()).isTrue();
    }
}
