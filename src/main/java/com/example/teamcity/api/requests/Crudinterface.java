package com.example.teamcity.api.requests;

public interface Crudinterface {
    public Object create(Object obj);
    public Object get(String id);
    public Object update(Object obj);
    public  Object delete(String id);
}
