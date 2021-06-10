package com.utn;

import java.io.*;
import java.util.*;

public class ToFile <T>{

    private String file;

    public ToFile(String file){
        this.file = file;
    }

    public List<T> load() {
        List <T> list= new ArrayList<>();
        try {
            boolean cont = true;
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            while (cont) {

                T aux = (T) input.readObject();
                if (aux != null) {
                    list.add(aux);
                } else {
                    cont = false;
                }
            }
            input.close();
        }
        catch (ClassNotFoundException | FileNotFoundException e){
            e.printStackTrace();
        }
        catch(EOFException e){
            System.out.println("El archivo fue cargado perfectamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void save(List <T> list) {
        try {
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
            for (int i= 0; i < list.size(); i++){
                objOut.writeObject(list.get(i));
            }
            objOut.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
