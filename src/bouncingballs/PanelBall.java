
package bouncingballs;

import java.awt.Color;
import java.awt.Graphics;

public class PanelBall extends javax.swing.JPanel implements Runnable {
 
    Thread hilo;
    
    int x = getWidth() / 2; 
    public PanelBall() {
        initComponents();
        hilo = new Thread(this); 
    }
    
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0,0, getWidth(), getHeight()); 
        g.setColor(Color.red); 
        g.fillOval(x, getHeight() / 2, 30, 30); 
    }
    
    public void inicio() {
        hilo.start();
    }
    
    public void pausa() {
        hilo.suspend();
    }
    
    public void continuar() {
        hilo.resume();
    }
    
    @Override
    public void run() {
         try {
             while(true) {
                 while (x < getWidth() - 30) {
                     Thread.sleep(50);
                     x += 10;
                     repaint(); 
                 }
                 while(x > 10) {
                     Thread.sleep(50);
                     x -= 10; 
                     repaint(); 
                 }
             }
         } catch (Exception e) {
             System.out.println("An error ocurred " + e.getMessage());  
         }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
