package com.ksyunnnn.apiapps;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Rss {
    @Element(name = "channel")
    private Channel mChannel;

    public Channel getChannel() {
        return mChannel;
    }

    public void setChannel(Channel channel) {
        this.mChannel = mChannel;
    }

}
