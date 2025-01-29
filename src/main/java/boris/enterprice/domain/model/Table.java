package boris.enterprice.domain.model;

import java.util.List;

public class Table {
    private final List<String> headers;
    private final List<List<String>> rows;

    public Table(List<String> headers, List<List<String>> rows) {
        this.headers = headers;
        this.rows = rows;
    }

    public void print() {
        int[] columnWidths = calculateColumnWidths();
        printHeaders(columnWidths);
        printSeparator(columnWidths);
        printRows(columnWidths);
    }

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

    private void printHeaders(int[] columnWidths) {
        printRow(headers, columnWidths);
    }

    private void printSeparator(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("-".repeat(width) + "-+-");
        }
        System.out.println();
    }

    private void printRows(int[] columnWidths) {
        for (List<String> row : rows) {
            printRow(row, columnWidths);
        }
    }

    private void printRow(List<String> row, int[] columnWidths) {
        for (int i = 0; i < row.size(); i++) {
            System.out.print(row.get(i));
            printPadding(columnWidths[i] - row.get(i).length());
            System.out.print(" | ");
        }
        System.out.println();
    }

    private void printPadding(int length) {
        for (int j = 0; j < length; j++) {
            System.out.print(" ");
        }
    }
}