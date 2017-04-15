package com.gao.thinking.proxy.typeInformation.genericClassReferences;

import com.gao.thinking.proxy.typeInformation.ClassLiterals.ClassInitialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * generic class syntax
 *
 * @Author 黄昌焕
 * @Date 2017-04-14  17:56
 */
public class FilledList<T> {
    private final static Logger logger = LoggerFactory.getLogger(ClassInitialization.class);
    private Class<T> type;
    public FilledList(Class<T> type){
        this.type=type;
    }
    public List create(int nElement){
        List<T> result = new ArrayList<T>();
        for(int i=0;i<nElement;i++){
            try {
                result.add(type.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main (String[] args) throws IllegalAccessException, InstantiationException {
        FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
        System.out.println(fl.create(11));
    }
}

class CountedInteger{
    private static long counter;
    private final long id=counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}