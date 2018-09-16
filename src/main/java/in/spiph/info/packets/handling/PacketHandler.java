/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.spiph.info.packets.handling;

import in.spiph.info.packets.base.APacket;
import in.spiph.info.packets.base.TestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bennett_DenBleyker
 */
public abstract class PacketHandler extends SimpleChannelInboundHandler<APacket> {

    ChannelPipeline pipeline;
    public boolean test = getTestMode();
    public String from;
    public List<Object> toFire = new ArrayList();

    public PacketHandler(String from) {
        this.from = from;
    }
    
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        System.out.println("Channel Active");
        pipeline = ctx.pipeline();
        if (test) {
            pipeline.fireUserEventTriggered(new TestPacket());
        }
        toFire.stream().forEach(o -> pipeline.fireUserEventTriggered(o));
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object event) throws Exception {
        if (event instanceof APacket) {
            APacket packet = (APacket) event;
            packet.setFrom(from);
            System.out.println("ME: " + packet.toString());
            ctx.writeAndFlush(packet);
        } else {
            super.userEventTriggered(ctx, event);
        }
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        if (!handleException(cause)) {
            cause.printStackTrace();
        }
        ctx.close();
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, APacket packet) {

        //Print what was received
        System.out.println(packet.getFrom().substring(1) + ": " + packet.toString());

        //Handle packet
        handlePacket(pipeline, packet);
    }

    public void fireUserEventTriggered(Object event) {
        if (pipeline != null) {
            pipeline.fireUserEventTriggered(event);
        } else {
            toFire.add(event);
        }
    }

    public abstract boolean handleException(Throwable cause);
    public abstract void handlePacket(ChannelPipeline pipeline, APacket packet);
    public abstract boolean getTestMode();
    
}
