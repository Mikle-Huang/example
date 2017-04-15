package com.gao.thinking.proxy.typeInformation.checkingBeforeACast;

import com.gao.thinking.proxy.util.Generator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Using isInstance
 *
 * @Author »Æ²ý»À
 * @Date 2017-04-15  11:18
 */
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>,Integer>{
        public PetCounter(){
            super(Generator.MapData.map(LiteralPetCreator.allTypes, 0));
        }
        public void count(Pet pet){
            for(Map.Entry<Class<? extends Pet>,Integer> pair:entrySet()){
                if(pair.getKey().isInstance(pet)){
                    put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }
        public String toString(){
            StringBuilder result=new StringBuilder("{");
            for(Map.Entry<Class<? extends Pet>,Integer> pair:entrySet()){
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(",");
            }
            result.delete(result.length() - 1, result.length());
            result.append("}");
            return result.toString();
        }
        public static void main(String[] args){
            PetCounter counter=new PetCounter();
            for(Pet pet:Pets.createArray(20)){
                counter.count(pet);
            }
            System.out.println(counter.toString());
        }
    }
}
