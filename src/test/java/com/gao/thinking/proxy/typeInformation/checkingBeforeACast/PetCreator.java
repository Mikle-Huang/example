package com.gao.thinking.proxy.typeInformation.checkingBeforeACast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * create random sequences of Pets
 *
 * @Author »Æ²ý»À
 * @Date 2017-04-14  22:46
 */
public abstract class PetCreator {
    private Random rand=new Random(47);
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet()  {
        int n=rand.nextInt(types().size());
        Pet pet=null;
        try {
            pet=types().get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return pet;
    }

    public Pet[] createArray(int size) {
        Pet[] result=new Pet[size];
        for(int i=0;i<size;i++)
            result[i]=randomPet();
        return result;
    }

    public ArrayList<Pet> arrayList(int size){
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}

