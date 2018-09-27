/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hager
 */
public class Array {
    
    private KVPair[] keyValuePairs;
    
    public Array(){
        keyValuePairs = new KVPair[5];
    }
    
    public void insert(KVPair kvp){
        
        int index = hash(kvp.getPlanetNumber(), keyValuePairs.length);
        if(keyValuePairs[index] == null){
            
            keyValuePairs[index] = kvp;
            
        }else{
            
            //open addressing and linear probing
            while(keyValuePairs[index] != null){
                
                if(index + 1 >= keyValuePairs.length){
                    index = 0;
                }
                
                if(keyValuePairs[index + 1] == null){
                    keyValuePairs[index + 1] = kvp;
                    break;
                }else{
                        index++;
                    
                    
                }
            }
            
        }
        
        //check array capacity for possible rehashing
        int totalPairs = 0;
        for(int i = 0; i < keyValuePairs.length; i++){
            if(keyValuePairs[i] !=  null){
                totalPairs++;
            }
        }
        if(totalPairs >= (keyValuePairs.length * .8)){
        
            rehash();
            
        }
        
    }
    
    public int hash(int pNum, int tableSize){
    
        int index = pNum % tableSize;
        return index;
        
    }
    
    public void rehash(){
    
        KVPair[] temp = new KVPair[keyValuePairs.length * 2];
        for(int i = 0; i < keyValuePairs.length; i++){
        
            if(keyValuePairs[i] !=  null){
            
                int index = hash(keyValuePairs[i].getPlanetNumber(), temp.length);
                if(temp[index] == null){
            
                    temp[index] = keyValuePairs[i];
            
                }else{
            
                //open addressing and linear probing
                while(temp[index] != null){
                    
                    if(index + 1 >= temp.length){
                        index = 0;
                    }
                    
                    if(temp[index +1 ] == null){
                        temp[index + 1] = keyValuePairs[i];
                        break;
                    }else{
                            index++;
                        
                    }
                }
            
                }
                
            }
            
        }
        
        keyValuePairs = temp;
        
    }
    
    public void printHash(){
        
        for(int i = 0; i < keyValuePairs.length; i++){
            if(keyValuePairs[i] == null){
                
                System.out.println("Index: " + i + "\tNo Planet");
                
            }else{
            
                System.out.println("Index: " + i + "\tPlanet Number: " + keyValuePairs[i].getPlanetNumber() + "\tPlanet Name: " + keyValuePairs[i].getPlanetName());
                
            }
            
            
        }
        
    }
    
}
