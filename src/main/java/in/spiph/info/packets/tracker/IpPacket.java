/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info.packets.tracker;

import in.spiph.info.packets.base.APacket;

/**
 *
 * @author Bennett.DenBleyker
 */
public class IpPacket extends APacket {
    public static final int TYPE_VALUE = 1;
    
    //Request
    public IpPacket(String idRequest) {
        super(TYPE_VALUE, idRequest + ";?", true);
    }

    //Response
    public IpPacket(String idRequest, String ipResponse) {
        super(TYPE_VALUE, idRequest + ";" + ipResponse.replaceAll(";", ""), false);
    }

    @Override
    public String toString() {
        String[] dataSplit = getData().toString().split(";");
        if (dataSplit[1].equals("?")) {
            return "IpPacket{REQUEST " + dataSplit[0] + '}';
        } else {
            return "IpPacket{" + dataSplit[1] + " " + dataSplit[0] + '}';
        }
    }

}
