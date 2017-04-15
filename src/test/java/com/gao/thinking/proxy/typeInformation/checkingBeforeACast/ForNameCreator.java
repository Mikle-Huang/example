package com.gao.thinking.proxy.typeInformation.checkingBeforeACast;

import java.util.ArrayList;
import java.util.List;

/**
 * fornamecreator
 *
 * @Author »Æ²ý»À
 * @Date 2017-04-15  7:53
 */
public class ForNameCreator extends PetCreator{
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    private static String[] typeNames={
            "com.gao.thinking.proxy.typeInformation.checkingBeforeACast.Mutt",
            "com.gao.thinking.proxy.typeInformation.checkingBeforeACast.Pug",
            "com.gao.thinking.proxy.typeInformation.checkingBeforeACast.EgyptianMau",
            "com.gao.thinking.proxy.typeInformation.checkingBeforeACast.Manx",
            "com.gao.thinking.proxy.typeInformation.checkingBeforeACast.Cymric",
            "com.gao.thinking.proxy.typeInformation.checkingBeforeACast.Rat",
            "com.gao.thinking.proxy.typeInformation.checkingBeforeACast.Mouse",
            "com.gao.thinking.proxy.typeInformation.checkingBeforeACast.Hamster"
    };

    private static void loader(){
        for(String name:typeNames){
            try {
                types.add((Class<? extends Pet>) Class.forName(name));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static{
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
