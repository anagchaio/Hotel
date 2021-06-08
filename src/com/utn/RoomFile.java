package com.utn;

import java.io.*;
import java.util.*;

public class RoomFile implements ToFile{

    private List<Room> rooms = new ArrayList();
    private String file;

    public RoomFile(String file, ArrayList <Room> rooms){
        this.file = file;
        this.rooms = rooms;
    }

    @Override
    public List load() {
        try{
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
            Room aux;
            while ((aux = (Room)objIn.readObject())!=null){
                System.out.println(aux);
                rooms.add(aux);
            }
            objIn.close();
        }
        catch (ClassNotFoundException | FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public void save() {

        try {
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
            for (int i= 0; i < rooms.size(); i++){
                objOut.writeObject(new Room(rooms.get(i)));
            }
            objOut.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
