/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package in.spiph.info.packets.handling;

import in.spiph.info.packets.serializing.PacketDecoder;
import in.spiph.info.packets.serializing.PacketEncoder;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

/**
 *
 * @author Bennett_DenBleyker
 */
public abstract class PacketHandlerInitializer extends ChannelInitializer<SocketChannel> {
    protected final SslContext sslCtx;
    protected final PacketHandler handler;
    
    public PacketHandlerInitializer(SslContext sslCtx, PacketHandler handler) {
        this.sslCtx = sslCtx;
        this.handler = handler;
    }
    
    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        
        if (sslCtx != null) {
            p.addLast(getSslHandler(ch));
        }
        
        // Packet Codecs
        p.addLast(new PacketEncoder());
        p.addLast(new PacketDecoder());
        
        // Business Logic
        p.addLast(handler);
    }
    
    public abstract ChannelHandler getSslHandler(SocketChannel ch);
}
