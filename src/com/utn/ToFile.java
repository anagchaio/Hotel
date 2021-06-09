package com.utn;

import java.util.*;

public interface ToFile <T>{

    public List<T> load();
    public void save(List <T> list);


}
