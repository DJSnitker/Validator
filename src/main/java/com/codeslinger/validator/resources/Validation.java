package com.codeslinger.validator.resources;

public class Validation {

    private String type;
    private String name;
    private String stuff;

    public Validation( String type, String name, String stuff ){
        this.type = type;
        this.name = name;
        this.stuff = stuff;
    }

    public String getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public String getStuff(){
        return stuff;
    }

    public String toString(){
        return type + " " + name + " " + stuff;
    }

    public boolean equals( Object o ){
        if( o == this ) return true;
        if( !(o instanceof  Validation )){
            return false;
        }
        Validation val = (Validation) o;
        return val.type.equals( type ) && val.name.equals( name ) && val.stuff.equals( stuff );
    }

    public int hashCode() {
        int seed = 17; //start with a prime, multiply each sub data by a subsequent prime
        seed = 31 * seed + type.hashCode();
        seed = 31 * seed + name.hashCode();
        seed = 31 * seed + stuff.hashCode();
        return seed;
    }

}
