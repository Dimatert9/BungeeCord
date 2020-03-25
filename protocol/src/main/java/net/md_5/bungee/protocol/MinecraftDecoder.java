package net.md_5.bungee.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class MinecraftDecoder extends MessageToMessageDecoder<ByteBuf>
{

    @Setter
    private Protocol protocol;
    private final boolean server;
    @Setter
    private int protocolVersion;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
    {
        ByteBuf slice = null;

        try
        {
            int originalReaderIndex = in.readerIndex();
            int originalReadableBytes = in.readableBytes();
            int packetId = DefinedPacket.readVarInt(in);
            slice = in.retainedSlice(originalReaderIndex, originalReadableBytes);

            Protocol.DirectionData prot = (server) ? protocol.TO_SERVER : protocol.TO_CLIENT;
            int protocolVersion = this.protocolVersion;
            DefinedPacket packet = prot.createPacket(packetId, protocolVersion);
            if ( packet != null )
            {
                packet.read( in, prot.getDirection(), protocolVersion );
                if ( in.isReadable() )
                {
                    in.skipBytes( in.readableBytes() ); //BotFilter
                    throw new BadPacketException( "Did not read all bytes from packet " + packet.getClass() + " " + packetId + " Protocol " + protocol + " Direction " + prot.getDirection() );
                }
            } else
            {
                in.skipBytes( in.readableBytes() );
            }

            //System.out.println( "ID: " + packetId + ( packet == null ? " (null)" : " ("+packet+")" ) );
            out.add( new PacketWrapper( packet, slice ) );
            slice = null;
        } finally
        {
            if ( slice != null )
            {
                slice.release();
            }
        }
    }

    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception
    {
        return msg instanceof ByteBuf;
    }
}
