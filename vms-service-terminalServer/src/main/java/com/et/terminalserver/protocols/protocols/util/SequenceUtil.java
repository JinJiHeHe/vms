package com.et.terminalserver.protocols.protocols.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceUtil {

	private final static Map<String, AtomicInteger> seqCache = new HashMap<String, AtomicInteger>();

	public static void createSequence(String seqName) {
		seqCache.put(seqName, new AtomicInteger());
	}

	public static int getSequenceValue(String seqName) {
		if (!seqCache.containsKey(seqName)) {
			return (int) System.nanoTime();
		}
		return seqCache.get(seqName).getAndIncrement();
	}
}
