package boris.enterprice.domain.model;

import java.util.List;

/**
 * Represents a table with headers and rows.
 */
public class Table {
    private final List<String> headers;
    private final List<List<String>> rows;

    /**
     * Constructor for Table.
     *
     * @param headers the headers of the table
     * @param rows the rows of the table
     */
    public Table(List<String> headers, List<List<String>> rows) {
        this.headers = headers;
        this.rows = rows;
    }

    /**
     * Prints the table.
     */
    public void print() {
        int[] columnWidths = calculateColumnWidths();
        printHeaders(columnWidths);
        printSeparator(columnWidths);
        printRows(columnWidths);
    }

    /**
     * Calculates the width of each column.
     *
     * @return the width of each column
     */
    private int[] calculateColumnWidths() {
        int[] columnWidths = new int[headers.size()];
        for (int i = 0; i < headers.size(); i++) {
            columnWidths[i] = headers.get(i).length();
        }
        for (List<String> row : rows) {
            for (int i = 0; i < row.size(); i++) {
                columnWidths[i] = Math.max(columnWidths[i], row.get(i).length());
            }
        }
        return columnWidths;
    }

    /**
     * Prints the headers of the table.
     *
     * @param columnWidths the width of each column
     */
    private void printHeaders(int[] columnWidths) {
        printRow(headers, columnWidths);
    }

    /**
     * Prints the separator between the headers and the rows.
     *
     * @param columnWidths the width of each column
     */
    private void printSeparator(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("-".repeat(width) + "-+-");
        }
        System.out.println();
    }

    /**
     * Prints the rows of the table.
     *
     * @param columnWidths the width of each column
     */
    private void printRows(int[] columnWidths) {
        for (List<String> row : rows) {
            printRow(row, columnWidths);
        }
    }

    /**
     * Prints a row of the table.
     *
     * @param row the row to print
     * @param columnWidths the width of each column
     */
    private void printRow(List<String> row, int[] columnWidths) {
        for (int i = 0; i < row.size(); i++) {
            System.out.print(row.get(i));
            printPadding(columnWidths[i] - row.get(i).length());
            System.out.print(" | ");
        }
        System.out.println();
    }

    /**
     * Prints padding.
     *
     * @param length the length of the padding
     */
    private void printPadding(int length) {
        for (int j = 0; j < length; j++) {
            System.out.print(" ");
        }
    }
}