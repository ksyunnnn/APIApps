package com.ksyunnnn.apiapps;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class Channel {
    @Element(name = "title")
    private String mTitle;

    //@Element(name = "link")
    //private String mLink;

    @Element(name = "description")
    private String mChannelDescription;

    @ElementList(inline = true)
    private List<Item> mItemList;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = mTitle;
    }

    /*public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        this.mLink = mLink;
    }*/

    public String getDescription() {
        return mChannelDescription;
    }

    public void setDescription(String description) {
        this.mChannelDescription = mChannelDescription;
    }

    public List<Item> getItemList() {
        return mItemList;
    }

    public void setItemList(List<Item> itemList) {
        this.mItemList = mItemList;
    }

}
