package com.utn;

import java.util.Scanner;

public enum RoomType {
    SIMPLE ("SIMPLE"),
    DOUBLE ("DOUBLE"),
    SUITE ("SUITE");

    private String type;

    RoomType (String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public static RoomType selectRoomType(){
        RoomType rt = null;
        System.out.print("\n\t Ingrese un numero segun el tipo de habitacion\n");
        System.out.print("\t 0. Simple\n");
        System.out.print("\t 1. Double\n");
        System.out.print("\t 2. Suite\n");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num == 0){ rt = SIMPLE; }
        if(num == 1){ rt = DOUBLE; }
        if(num == 2){ rt = SUITE; }
        if(rt == null){
            System.out.print("\n\t Seleccione un valor valido\n");
            selectRoomType();
        }
        return rt;
    }
}
