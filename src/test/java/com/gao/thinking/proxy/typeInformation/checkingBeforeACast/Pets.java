package com.gao.thinking.proxy.typeInformation.checkingBeforeACast;

import java.util.List;

/**
 * facade to produce a default PetCreator
 *
 * @Author »Æ²ý»À
 * @Date 2017-04-15  10:45
 */
public class Pets {
    public static final PetCreator creator=new LiteralPetCreator();
    public static Pet randomPet(){
        return creator.randomPet();
    }
    public static Pet[] createArray(int size){
        return creator.createArray(size);
    }
    public static List<Pet> arrayList(int size){
        return creator.arrayList(size);
    }
}
