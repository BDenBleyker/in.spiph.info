/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info.packets.handling;

import in.spiph.info.packets.handling.PacketHandler;
import in.spiph.info.packets.handling.PacketHandlerInitializer;
import io.netty.channel.ChannelHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

/**
 *
 * @author Bennett.DenBleyker
 */
public class PacketServerInitializer extends PacketHandlerInitializer {

    public PacketServerInitializer(SslContext sslCtx, PacketHandler handler) {
        super(sslCtx, handler);
    }
    
    @Override
    public ChannelHandler getSslHandler(SocketChannel ch) {
        return sslCtx.newHandler(ch.alloc());
    }
}
