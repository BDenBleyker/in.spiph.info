/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info.packets.client;

import com.google.gson.internal.LinkedTreeMap;
import in.spiph.info.Page;
import in.spiph.info.packets.base.ObjectPacket;

/**
 *
 * @author Bennett.DenBleyker
 */
public class PagePacket extends ObjectPacket {
    public static final int TYPE_VALUE = 2;

    //Request
    public PagePacket(String id) {
        super(TYPE_VALUE, id + "", true);
    }

    //Response
    public PagePacket(Page data) {
        super(TYPE_VALUE, data, false);
    }

    @Override
    public String toString() {
        if (getData() instanceof Page) {
            Page page = (Page) getData();
            String title;
            if (page.getHtml().contains("<title>")) {
                title = page.getHtml().split("<title>")[1].split("</title>")[0];
            } else {
                title = "";
            }
            if (title.length() > 40 || title.length() == 0) {
                return "PagePacket{Posts: " + page.getPosts().size() + ", Html: " + page.getHtml() + '}';
            } else {
                return "PagePacket{Posts: " + page.getPosts().size() + ", Title: \"" + title + "\"}";
            }
        } else if (getData() instanceof String) {
            return "PagePacket{Request: " + getData() + "}";
        } else if (getData() instanceof LinkedTreeMap) {
            setData((LinkedTreeMap) getData());
            return toString();
        } else {
            return "PagePacket{ERROR: " + getData().getClass().toString() + getData().toString() + "}";
        }
    }
    
    @Override
    public void setData(Object data) {
        if (data instanceof LinkedTreeMap) {
            super.setData(Page.valueOf((LinkedTreeMap) data));
        } else {
            super.setData(data);
        }
    }

}
