package org.jeux.sudoku;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sudoku {
    int[][] sudokuGrille;

    public void setGrille(int[][] sudokuGrilleEmpty) {
        this.sudokuGrille = sudokuGrilleEmpty;
    }

    public boolean resoudre() {
        return checkNotEmpty()
                && checkSize()
                && checkValidNumbers();
    }

    /**
     * Contrôle si la grille ne contient pas de chiffres invalides (hors de 1 à 9) et afficher les coordonnées des
     * cellules contenant un chiffre invalide
     *
     * @return true si la grille est valide
     */

    private boolean checkValidNumbers() {
        List<int[]> invalidCells = IntStream.range(0, sudokuGrille.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, sudokuGrille[i].length)
                        .mapToObj(j -> new int[]{i, j}))
                .filter(coords -> {
                    int cell = sudokuGrille[coords[0]][coords[1]];
                    return cell < 1 || cell > 9;
                })
                .toList();

        invalidCells.forEach(coords -> {
            int cell = sudokuGrille[coords[0]][coords[1]];
            System.out.println("Invalid number at (" + coords[0] + ", " + coords[1] + "): " + cell);
        });

        return invalidCells.isEmpty();

    }

    /**
     * Contrôle la taille de la grille et si elle est vide
     *
     * @return true si la grille est valide
     */
    private boolean checkSize() {
        return sudokuGrille.length == 9
                && Arrays.stream(sudokuGrille).noneMatch(row -> row.length != 9);
    }

    /**
     * Contrôle si la grille n'est pas vide
     *
     * @return true si la grille n'est pas vide
     */
    private boolean checkNotEmpty() {
        return !ArrayUtils.isEmpty(sudokuGrille)
                && Arrays.stream(sudokuGrille)
                .flatMapToInt(Arrays::stream)
                .anyMatch(cell -> cell != 0);
    }
}
