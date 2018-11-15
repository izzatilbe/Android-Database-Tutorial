package com.example.bryan.databasetutorial;

public class Row {

    private int _id;
    private String _name;

    public Row(String name){
        _name = name;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}