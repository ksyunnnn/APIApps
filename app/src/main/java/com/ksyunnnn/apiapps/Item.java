package com.ksyunnnn.apiapps;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Item {
    @Element(name = "title")
    private String title ;
    @Element(name = "link")
    private String link ;
    @Element(name = "comments")
    private String comments ;
    @ElementList(entry = "category",inline = true,data=true, required=false)
    private List<Category> category ;
    @Element(name = "guid")
    private String guid ;
    @Element(name = "image")
    private String image ;
    @Element(name = "pubDate")
    private String pubDate ;
    @Element(name = "description")
    private String description ;

    public Item(String title, String link, String comments, List<Category> category, String guid, String image, String pubDate, String description){
        this.title = title ;
        this.link = link ;
        this.comments = comments ;
        this.category = category ;
        this.guid = guid ;
        this.image = image ;
        this.pubDate = pubDate ;
        this.description = description ;
    }

    public String gettitle(){
        return title ;
    }
    public String getlink(){
        return link ;
    }
    public String getcomments(){
        return comments ;
    }
    public List<Category> getcategory(){
        return category ;
    }
    public String getguid(){
        return guid ;
    }
    public String getimage(){
        return image ;
    }
    public String getpubDate(){
        return pubDate ;
    }
    public String getdescription(){
        return description ;
    }

    public String settitle(){
        return title ;
    }
    public String setlink(){
        return link ;
    }
    public String setcomments(){
        return comments ;
    }
    public List<Category> setcategory(){
        return category ;
    }
    public String setguid(){
        return guid ;
    }
    public String setimage(){
        return image ;
    }
    public String setpubDate(){
        return pubDate ;
    }
    public String setdescription(){
        return description ;
    }

}
