package kca.desktop.app;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;

public class EditButtonRenderer extends JButton implements TableCellRenderer {
    public EditButtonRenderer() {
        setText("Edit");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
