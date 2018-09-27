/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hager
 */
public class KVPair {
    private int pNum;
    private String pName;
    
    public KVPair(int x, String input){
        pNum = x;
        pName = input;
    }
    
    public int getPlanetNumber(){
        return pNum;
    }
    
    public String getPlanetName(){
        return pName;
    }
}    
