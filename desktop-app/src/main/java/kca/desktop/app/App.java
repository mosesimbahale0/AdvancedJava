package kca.desktop.app;

public class App {
    public static void main(String[] args) {
        // Launch the dashboard
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
}
