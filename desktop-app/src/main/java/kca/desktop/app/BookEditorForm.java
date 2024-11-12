package kca.desktop.app;

import javax.swing.*;

public class BookEditorForm extends javax.swing.JFrame {

    private Integer bookId; // or use Book book if you need more details

    /**
     * Creates new form BookEditorForm
     */
    public BookEditorForm(Integer bookId) {
        this.bookId = bookId;
        initComponents();
        loadBookData(); // Load book data when the form is initialized
    }

//    private void initComponents() {
//
////        jLabel1 = new javax.swing.JLabel();
////        jTextField1 = new javax.swing.JTextField();
////        jLabel2 = new javax.swing.JLabel();
////        jTextField2 = new javax.swing.JTextField();
////        jLabel3 = new javax.swing.JLabel();
////        jLabel4 = new javax.swing.JLabel();
////        jTextField3 = new javax.swing.JTextField();
////        jLabel5 = new javax.swing.JLabel();
////        jTextField4 = new javax.swing.JTextField();
////        jLabel6 = new javax.swing.JLabel();
////        jTextField5 = new javax.swing.JTextField();
////        jLabel7 = new javax.swing.JLabel();
////        jTextField6 = new javax.swing.JTextField();
////        jLabel8 = new javax.swing.JLabel();
////        jTextField7 = new javax.swing.JTextField();
////        jButton1 = new javax.swing.JButton();
////        jButton2 = new javax.swing.JButton();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        jLabel1.setText("Title");
//
//        jLabel2.setText("Author");
//
//        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
//        jLabel3.setText("Edit Book");
//
//        jLabel4.setText("Description");
//
//        jLabel5.setText("Price");
//
//        jLabel6.setText("Image URL");
//
//        jLabel7.setText("Rating");
//
//        jLabel8.setText("Stock");
//
//        jButton1.setText("Save");
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                saveButtonActionPerformed(evt);
//            }
//        });
//
//        jButton2.setText("Cancel");
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Title");

        jTextField1.setText("jTextField1");

        jLabel2.setText("Author");

        jTextField2.setText("jTextField2");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setText("Edit Book");

        jLabel4.setText("Description");

        jTextField3.setText("jTextField3");

        jLabel5.setText("Price");

        jTextField4.setText("jTextField4");

        jLabel6.setText("Image URL");

        jTextField5.setText("jTextField5");

        jLabel7.setText("Rating");

        jTextField6.setText("jTextField6");

        jLabel8.setText("Stock");

        jTextField7.setText("jTextField7");

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField6)
                                    .addComponent(jTextField7))))
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Implement save logic here
        // Get the updated values from the fields and save changes
        String title = jTextField1.getText();
        String author = jTextField2.getText();
        String description = jTextField3.getText();
        String price = jTextField4.getText();
        String imageUrl = jTextField5.getText();
        String rating = jTextField6.getText();
        String stock = jTextField7.getText();

        // Call the backend to update the book using bookId and these details
        // For example: BookUpdater.updateBook(bookId, title, author, description, price, imageUrl, rating, stock);
        // Close the form or show a success message
    }

    private void loadBookData() {
        // Fetch the book details using bookId and populate the form fields
        // Example:
        // Book book = BookLoader.loadBook(bookId);
        // jTextField1.setText(book.getTitle());
        // jTextField2.setText(book.getAuthor());
        // jTextField3.setText(book.getDescription());
        // jTextField4.setText(String.valueOf(book.getPrice()));
        // jTextField5.setText(book.getImageUrl());
        // jTextField6.setText(String.valueOf(book.getRating()));
        // jTextField7.setText(String.valueOf(book.getStock()));
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new BookEditorForm(1).setVisible(true); // Example with book ID 1
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
