/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author hmh25
 */
public class Nodes {

    public Nodes origin;
    public int[][] matrix;
    public int dest;
    public int x, y;
    public int cost;

    public Nodes(int[][] matrix, int x, int y, int x2, int y2, int dest, Nodes origin) {
        this.origin = origin;
        this.matrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = matrix[i].clone();
        }

        this.matrix[x][y] = this.matrix[x][y] + this.matrix[x2][y2];
        this.matrix[x2][y2] = this.matrix[x][y] - this.matrix[x2][y2];
        this.matrix[x][y] = this.matrix[x][y] - this.matrix[x2][y2];

        this.cost = Integer.MAX_VALUE;
        this.dest = dest;
        this.x = x2;
        this.y = y2;
    }
}
