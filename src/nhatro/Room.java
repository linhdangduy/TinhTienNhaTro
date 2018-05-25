/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhatro;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author linhsama
 */
public class Room {
    private int row;
    private int soDienThangTruoc;
    private int soDienThangNay;
    private float phongVsTang1;
    private int nguoi;
    private float tienNuoc;
    private float result;
    private float soTienPhaiTra;
    private Map<Integer, Integer> dict;

    public Room(int row, int thangTruoc, int thangNay, float vs, float tienNuoc, int nguoi) {
        this.row = row;
        this.soDienThangTruoc = thangTruoc;
        this.soDienThangNay = thangNay;
        this.phongVsTang1 = vs;
        this.nguoi = nguoi;
        this.tienNuoc = tienNuoc;
        dict = new HashMap();
        dict.put(1, 1500);
        dict.put(2, 1550);
        dict.put(3, 1800);
        dict.put(4, 2300);
        dict.put(5, 2500);
        calculate();
    }
    // 1.5, 1.55, 1.8, 2.3, 2.5
    public void calculate() {
        int chechLech = soDienThangNay - soDienThangTruoc;
        result = dequy(chechLech, 1) + phongVsTang1*nguoi;
    }
    
    public float dequy(int chenhLech, int turn) {
        if (turn == 1 || turn == 2) {
            if (chenhLech > 50) {
                return 50*dict.get(turn) + dequy(chenhLech-50, turn+1);
            } else {
                return chenhLech*dict.get(turn);
            }
        } else {
            if (chenhLech > 100) {
                return 100*dict.get(turn) + dequy(chenhLech-100, turn+1);
            } else {
                return chenhLech*dict.get(turn);
            }
        } 
    }
    
    public int getRow() {
        return row;
    }
    
    public float getResult() {
        return result;
    }
    
    public void soTienPhaiTra(float tienDienChung) {
//        soTienPhaiTra = result + tienDienChung*nguoi + tienNuoc*nguoi;
        soTienPhaiTra = result  + tienNuoc*nguoi;
    }
    
    public float tienMoiPhong() {
        return soTienPhaiTra;
    }
}
