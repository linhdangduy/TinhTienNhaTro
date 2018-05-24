/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatro;

/**
 *
 * @author linhsama
 */
public class NhaTro {
    TinhTien tinhTien;

    public void runFrontEnd() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tinhTien = new TinhTien();
            }
        });
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NhaTro nhaTro = new NhaTro();
        nhaTro.runFrontEnd();
        System.out.println("linh");
    }
    
}
