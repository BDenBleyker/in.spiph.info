/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info.packets.base;

import java.io.Serializable;

/**
 *
 * @author Bennett.DenBleyker
 */
public abstract class APacket implements Serializable {

    private static long nextId = 0;
    private final long id;
    private final int type;
    private Object data;
    private String from = "Unknown";
    private boolean isRequest;

    public APacket(int type, Object data) {
        this(type, data, false);
    }
    
    public APacket(int type, Object data, boolean isRequest) {
        this.id = nextId++;
        this.type = type;
        this.data = data;
        this.isRequest = true;
    }

    @Override
    public String toString() {
        return "APacket[" + id + "]{" + "from=\"" + from + "\", type=" + type + ", data=\"" + data.toString() + "\"}";
    }

    public long getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isRequest() {
        return isRequest;
    }

    public void setIsRequest(boolean isRequest) {
        this.isRequest = isRequest;
    }

}
