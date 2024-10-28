/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.inserttable;

import com.formdev.flatlaf.FlatClientProperties;
import static com.formdev.flatlaf.FlatClientProperties.TEXT_FIELD_LEADING_ICON;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.mycompany.inserttable.Create;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import sample.table.CheckBoxTableHeaderRenderer;
import sample.table.TableHeaderAlignment;

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        init();
    }
    private void init(){
   
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
        
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height: 30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");
                
        table.putClientProperty(FlatClientProperties.STYLE,"" 
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing: 0, 1;"
                + "cellFocusColor: $TableHeader.hoverBackground;"
                + "selectionBackground: $TableHeader.hoverBackground;" // Sửa lại chính tả
                + "selectionForeground: $Table.foreground;");
   
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE,""
                + "trackArc:999;"
                + "trackInsets: 3,3,3,3;"
                + "thumbInsets: 3,3,3,3;"
                + "background: $Table.background;");
        
        ibTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +5;");
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search...");
        txtSearch.putClientProperty(FlatClientProperties. TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("sample/icon/search.svg"));
        txtSearch.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15"
                + "borderWidth:0;"
                + "foccusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$Panel.background");
        
        
        table.getColumnModel().getColumn(0).setHeaderRenderer(new CheckBoxTableHeaderRenderer(table, 0));
        table.getTableHeader().setDefaultRenderer(new TableHeaderAlignment(table));
        
        testData(); 
    }
 
   
    private void testData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{false, 1, "Steven Currie", "100", "26/10/2024", "Business Analyst", "Single", "stevecurrie.hust@gmail.com"});
        model.addRow(new Object[]{false, 2, "John Doe", "101", "26/10/2024", "Software Engineer", "Married", "johndoe@example.com"});
        model.addRow(new Object[]{false, 3, "Alice Smith", "102", "26/10/2024", "Product Manager", "Single", "alicesmith@example.com"});
        model.addRow(new Object[]{false, 4, "Bob Johnson", "103", "26/10/2024", "Designer", "Married", "bobjohnson@example.com"});
        model.addRow(new Object[]{false, 5, "Charlie Brown", "104", "26/10/2024", "Data Scientist", "Single", "charliebrown@example.com"});
        model.addRow(new Object[]{false, 6, "Diana Prince", "105", "26/10/2024", "Marketing Manager", "Single", "dianaprince@example.com"});
        model.addRow(new Object[]{false, 7, "Edward Elric", "106", "26/10/2024", "Mechanical Engineer", "Married", "edwardelric@example.com"});
        model.addRow(new Object[]{false, 8, "Fiona Apple", "107", "26/10/2024", "Content Writer", "Single", "fionaapple@example.com"});
        model.addRow(new Object[]{false, 9, "George Clooney", "108", "26/10/2024", "Actor", "Married", "georgeclooney@example.com"});
        model.addRow(new Object[]{false, 10, "Hannah Montana", "109", "26/10/2024", "Musician", "Single", "hannahmontana@example.com"});
        model.addRow(new Object[]{false, 11, "Ian Somerhalder", "110", "26/10/2024", "Actor", "Married", "iansomerhalder@example.com"});
        model.addRow(new Object[]{false, 12, "Julia Roberts", "111", "26/10/2024", "Actress", "Single", "juliaroberts@example.com"});
        model.addRow(new Object[]{false, 13, "Kevin Bacon", "112", "26/10/2024", "Director", "Married", "kevinbacon@example.com"});
        model.addRow(new Object[]{false, 14, "Lily Collins", "113", "26/10/2024", "Fashion Designer", "Single", "lilycollins@example.com"});
        model.addRow(new Object[]{false, 15, "Matthew McConaughey", "114", "26/10/2024", "Actor", "Married", "matthewmcconaughey@example.com"});
        model.addRow(new Object[]{false, 16, "Natalie Portman", "115", "26/10/2024", "Actress", "Single", "natalieportman@example.com"});
        model.addRow(new Object[]{false, 17, "Oscar Isaac", "116", "26/10/2024", "Actor", "Married", "oscarisaac@example.com"});
        model.addRow(new Object[]{false, 18, "Penny Lane", "117", "26/10/2024", "Musician", "Single", "pennylane@example.com"});
        model.addRow(new Object[]{false, 19, "Quentin Tarantino", "118", "26/10/2024", "Director", "Married", "quentintarantino@example.com"});
        model.addRow(new Object[]{false, 20, "Rachel Green", "119", "26/10/2024", "Fashion Stylist", "Single", "rachelgreen@example.com"});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearch = new javax.swing.JTextField();
        ibTitle = new javax.swing.JLabel();
        buttonAction2 = new sample.swing.ButtonAction();
        buttonAction1 = new sample.swing.ButtonAction();
        buttonAction3 = new sample.swing.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SELECT", "#", "NAME", "ROOM", "DATE", "Job", "INFORMATION", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(40);
            table.getColumnModel().getColumn(3).setMaxWidth(100);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(6).setPreferredWidth(150);
            table.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        ibTitle.setText("RESIDENT");

        buttonAction2.setText("Delete");
        buttonAction2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction2ActionPerformed(evt);
            }
        });

        buttonAction1.setText("Edit");
        buttonAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction1ActionPerformed(evt);
            }
        });

        buttonAction3.setText("New");
        buttonAction3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ibTitle)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(10, 10, 10))
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ibTitle)
                .addGap(9, 9, 9)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(480, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void buttonAction2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAction2ActionPerformed

    private void buttonAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAction1ActionPerformed

    private void buttonAction3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction3ActionPerformed
    Create create = new Create();
    DefaultOption option = new DefaultOption(){
     @Override
           public boolean closeWhenClickOutside(){
                   return true;
           }
   };
   
    String actions[] = new String[]{"Cancel", "Save"};
    GlassPanePopup.showPopup(new SimplePopupBorder(create, "Create Resident", actions, (pc, i) ->{
       if(i == 1){
       // save
        }else{
          pc.closePopup();
       }
    }),option);
    }//GEN-LAST:event_buttonAction3ActionPerformed

    public static void main(String args[]) {
     
        FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sample.swing.ButtonAction buttonAction1;
    private sample.swing.ButtonAction buttonAction2;
    private sample.swing.ButtonAction buttonAction3;
    private javax.swing.JLabel ibTitle;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
