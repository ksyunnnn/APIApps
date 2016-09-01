package com.ksyunnnn.apiapps;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Category {
    @Element(name = "category",data=true, required=false)
    public String category ;

    public String getCategory(){
        return category ;
    }
    public String setCategory(){
        return category ;
    }
    Category(){}

}
