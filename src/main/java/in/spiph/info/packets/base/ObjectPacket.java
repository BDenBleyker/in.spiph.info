/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info.packets.base;

/**
 *
 * @author Bennett.DenBleyker
 */
public class ObjectPacket extends APacket {
    public static final int GENERIC_TYPE_VALUE = 3;
    
    public ObjectPacket(Object obj, boolean isRequest) {
        super(GENERIC_TYPE_VALUE, obj, isRequest);
    }
    
    public ObjectPacket(int type, Object obj, boolean isRequest) {
        super(type, obj, isRequest);
    }

    @Override
    public String toString() {
        return "ObjectPacket{" + getData().toString() + "}";
    }
}
