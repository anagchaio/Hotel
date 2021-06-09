package com.utn;

import java.io.*;
import java.util.*;

public class RoomFile{

    private String file;

    public RoomFile(String file){
        this.file = file;
    }

    public List<Room> load() {
        List <Room> rooms= new ArrayList<>();
        try {
            boolean cont = true;
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            while (cont) {

                Room aux = (Room) input.readObject();
                if (aux != null) {
                    rooms.add(aux);
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
        return rooms;
    }

    public void save(List <Room> rooms) {
        try {
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
            for (int i= 0; i < rooms.size(); i++){
                objOut.writeObject(rooms.get(i));
            }
            objOut.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
