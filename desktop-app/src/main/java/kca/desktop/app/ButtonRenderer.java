package kca.desktop.app;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;

public class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setText("Delete");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
