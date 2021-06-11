package com.utn;

import java.io.*;
import java.util.*;

public class ToFile <T>{
    private String file;

    public ToFile(String file){
        this.file = file;
    }

    public List<T> load() throws IOException {
        List <T> list= new ArrayList<>();
        boolean cont = true;
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        try {
            while (cont) {
                T aux = (T) input.readObject();
                if (aux != null) {
                    list.add(aux);
                } else {
                    cont = false;
                }
            }
        }
        catch (ClassNotFoundException | FileNotFoundException e){
            e.printStackTrace();
        }
        catch(EOFException e){
            System.out.println("El archivo " + file + " fue cargado totalmente");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
        return list;
    }

    public void save(List <T> list) throws IOException {
        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
        try {
            for (int i= 0; i < list.size(); i++){
                objOut.writeObject(list.get(i));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            objOut.close();
        }
    }
}
