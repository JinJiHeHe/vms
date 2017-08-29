package com.et.terminalserver.t808;


import com.et.terminalserver.protocols.business.bo.BusinessObject;
import com.et.terminalserver.protocols.protocols.BoMapper;
import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.common.AbstractAnalysis;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.util.T808_Util;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

/**
 * @Title: T808_ProtocolAnalysis
 * @Description: 部标808协议解析类
 * @author: guanhl
 * @date: 2014年4月4日 上午12:00:14
 */

public class T808_ProtocolAnalysis<A extends T808_MessageHeader, B extends T808_MessageBody>
		extends AbstractAnalysis<A, B> {

	BoMapper mapper = new T808_BoMapper();
	//Log log = LogFactory.getLog(T808_ProtocolAnalysis.class);

	@Override
	public Message<A, B> unpack(byte[] data) {
		// 转移还原
		byte[] reverseBytes = T808_Util.reverseEscapeData(data);
		// 校验
		boolean check = T808_Util.check(reverseBytes) == BytesUtil.getByte(
				reverseBytes.length - 2, reverseBytes);
		if (check) {
			//log.warn("check the data is not right ");
		}
		
		// if (true) {
		T808_Process<A, B> process = T808_MessageProcessManager
				.getProcess(T808_Util.getMessageID(reverseBytes));
		return process.unpackData(reverseBytes);
	}

	@Override
	public boolean doCase(Object data) {
		
		byte[] bytes = (byte[]) data;
		// 第一位
		byte firstFlag = BytesUtil.getByte(0, bytes);
		// 最后一位
		byte lastFlag = BytesUtil.getByte(bytes.length - 1, bytes);
		if (firstFlag == 0x7e && lastFlag == 0x7e) {// 正常源数据
			return true;
		}
		return false;
	}

	/**
	 * 解析终端标识，部标一般为sim卡号
	 */
	@Override
	public String getTerminalKey(byte[] data) {
		// 获取5-6位 参考JTT808
		byte[] simBytes = BytesUtil.cutBytes(5, 6, data);
		// 变为电话号
		String sim = BytesUtil.bcdToStr(simBytes);
		return sim;
	}

	@Override
	public byte[] pack(Message<A, B> message) {
		T808_Process<A, B> process = T808_MessageProcessManager
				.getProcess((Integer) message.getMessageHeader().getMessageID());
		return process.packData(message);
	}

	@Override
	public BusinessObject mapBusinessObject(Message<A, B> message) {
		return mapper.mapper(message);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Message<A, B> mapBusinessObject(BusinessObject bo, int opts) {
              return null;
		//return (Message<A, B>) mapper.mapper(bo, opts);
	}

	@Override
	public Object disassembly(Channel channel, ByteBuf in) {

		return decode(channel, in);
	}

	private int findEndOfLine(final ByteBuf buffer) {
		final int n = buffer.writerIndex();
		for (int i = buffer.readerIndex(); i < n; i++) {
			final byte b = buffer.getByte(i);
			if (b == 0x7e) {
				if (buffer.getByte(i + 1) == 0x7e) {
					return i + 1;
				}
			}
		}
		return -1; // Not found.
	}

	private Object decode(Channel channel, ByteBuf in) {
		final ByteBuf frame;
		final int readIndex = in.readerIndex(); // 读取索引
		final int writeIndex = in.writerIndex(); // 写入索引
		if (writeIndex == readIndex)
			return null;
		if (in.getByte(readIndex) == 0x7e) {// 开头是7e
			if ((readIndex + 1 != writeIndex) // 两个索引
					&& in.getByte(writeIndex - 1) == 0x7e) {// 屁股是7e
				int index = findEndOfLine(in); // 找找中间有没有7e7e
				if (index < 0) { // 这就是没有 说明这是个整包
					frame = in.readBytes(writeIndex - readIndex);
				} else { // 这就是有，说明是粘包，但是只取第一个包
					frame = in.readBytes(index - readIndex);
				}
				return frame;
			} else { // 屁股不是7e，开头是7e
				int index = findEndOfLine(in);
				if (index < 0) { // 这就是说明，这就是个只有开头的半包
					return null;
				} else {// 这就是说明，这是个有整包和半包合在一起的包，取一个整包出来
					frame = in.readBytes(index - readIndex);
					return frame;
				}
			}
		} else {// 7e不开头，该忽略忽略
			int index = findEndOfLine(in);
			if (index < 0) {
				in.readerIndex(writeIndex);// 忽略
				return null;
			} else {
				in.readerIndex(index);
				return null;
			}
		}

	}

}
