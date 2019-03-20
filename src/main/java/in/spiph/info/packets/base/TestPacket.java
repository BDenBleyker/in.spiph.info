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
public class TestPacket extends APacket {
    public static final int TYPE_VALUE = 0;
    
    //Request
    public TestPacket() {
        super(TYPE_VALUE, "Request", true);
    }
    
    //Response
    public TestPacket(String genericResponse) {
        super(TYPE_VALUE, genericResponse, false);
    }

    @Override
    public String toString() {
        return "TestPacket{" + getData() + '}';
    }
    
    
    
}
