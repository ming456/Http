package com.lzw.constrol;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.lzw.model.Obj_gys;

public class ReflectObject {
    static Obj_gys objgys = new Obj_gys();
    
    public static void printMethods(Class c1) {
        System.out.println("class " + c1.getName());
        Method[] method = c1.getDeclaredMethods();
        for (int i = 0; i < method.length; i++) {
            Method m = method[i];
            Class retype = m.getReturnType();
            String name = m.getName();
            
            System.out.print(Modifier.toString(m.getModifiers()));
            System.out.print(" " + retype.getName() + " " + name + "(");
            Class[] param = m.getParameterTypes();
            for (int j = 0; j < param.length; j++) {
                if (j > 0)
                    System.out.print(",");
                System.out.print(param[j].getName());
            }
            System.out.println(")");
        }
    }
    
    public static void printFields(Class c1) {
        Field[] fields = c1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            Class type = f.getType();
            String name = f.getName();
            try {
                String mm = f.get(objgys).toString();
                System.out.println(mm);
            } catch (java.lang.IllegalAccessException ill) {
                ill.printStackTrace();
            }
            System.out.print(Modifier.toString(f.getModifiers()));
            System.out.println(" " + type.getName() + " " + name + ";");
        }
    }
}
