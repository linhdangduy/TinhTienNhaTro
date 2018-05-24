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
    private float result;
    private Map<Integer, Float> dict;

    public Room(int row, int thangTruoc, int thangNay, float vs) {
        this.row = row;
        this.soDienThangTruoc = thangTruoc;
        this.soDienThangNay = thangNay;
        this.phongVsTang1 = vs;
        dict = new HashMap();
        dict.put(1, 1.5F);
        dict.put(2, 1.55F);
        dict.put(3, 1.8F);
        dict.put(4, 2.3F);
        dict.put(5, 2.5F);
        calculate();
    }
    // 1.5, 1.55, 1.8, 2.3, 2.5
    public void calculate() {
        int chechLech = soDienThangNay - soDienThangTruoc;
        result = dequy(chechLech, 1) + phongVsTang1;
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
    
    public float getResult() {
        return result;
    }
}
