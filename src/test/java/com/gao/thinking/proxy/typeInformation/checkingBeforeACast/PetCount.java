package com.gao.thinking.proxy.typeInformation.checkingBeforeACast;

import java.util.HashMap;

/**
 * Using instanceof
 *
 * @Author »Æ²ý»À
 * @Date 2017-04-15  8:02
 */
public class PetCount {
    static class PetCounter extends HashMap<String , Integer>{
        public void count(String type){
            Integer quantity = get(type);
            if(quantity==null){
                put(type, 1);
            }else{
                put(type, quantity + 1);
            }
        }

        public static void countPets(PetCreator creator){
            PetCounter counter=new PetCounter();
            for(Pet pet:creator.createArray(20)){
                System.out.println(pet.getClass().getSimpleName()+" ");
                if(pet instanceof Pet)
                    counter.count("Pet");
                if(pet instanceof Dog)
                    counter.count("Dog");
                if(pet instanceof Mutt)
                    counter.count("Mutt");
                if(pet instanceof Cat)
                    counter.count("Cat");
                if(pet instanceof EgyptianMau)
                    counter.count("EgyptianMau");
                if(pet instanceof Manx)
                    counter.count("Manx");
                if(pet instanceof Cymric)
                    counter.count("Cymric");
                if(pet instanceof Rodent)
                    counter.count("Rodent");
                if(pet instanceof Mouse)
                    counter.count("Mouse");
                if(pet instanceof Hamster)
                    counter.count("Hamster");
            }
            System.out.println(counter);
        }

        public static void main(String[] args){
            countPets(new ForNameCreator());
            countPets(Pets.creator);
        }
    }
}
