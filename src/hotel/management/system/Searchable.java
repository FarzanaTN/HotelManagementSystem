package hotel.management.system;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public interface Searchable {
    int getColumnIndex(String s);

    // Default method for performing search
    default void performSearch(JComboBox<String> searchOptions, JTextField searchField, JLabel messageLabel, JTable table) {
        String searchOption = (String) searchOptions.getSelectedItem();
        String searchText = searchField.getText();
        searchAndHighlight(searchOption, searchText, messageLabel, table);
    }

    // Default method for searching and highlighting
    default void searchAndHighlight(String searchOption, String searchText, JLabel messageLabel, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        int rowCount = tableModel.getRowCount();
        boolean found = false;
        
        java.util.List<Integer> matchingRows = new java.util.ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            String cellValue = (String) tableModel.getValueAt(i, getColumnIndex(searchOption));
            if (cellValue != null && cellValue.equalsIgnoreCase(searchText)) {
                matchingRows.add(i);
                found = true;
            }
        }

        if (found) {
            int[] rowsArray = matchingRows.stream().mapToInt(Integer::intValue).toArray();
            table.setRowSelectionInterval(rowsArray[0], rowsArray[0]); // Select the first found row
            for (int i = 1; i < rowsArray.length; i++) {
                table.addRowSelectionInterval(rowsArray[i], rowsArray[i]); // Add selection for other rows
            }
            messageLabel.setText("");
        } else {
            messageLabel.setText("Not found");
            messageLabel.setForeground(java.awt.Color.RED);
            table.clearSelection();
        }
    }
}
