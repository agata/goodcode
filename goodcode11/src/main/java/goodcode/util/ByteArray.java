package goodcode.util;

import org.apache.commons.lang3.ArrayUtils;

public class ByteArray {

	private final byte[] bytes;

	public ByteArray(byte[] bytes) {
		this.bytes = bytes;
	}

	public int getLength() {
		return bytes.length;
	}

	public String getString(int index, int length) {
		return new String(getBytes(index, length));
	}

	public byte[] getBytes(int index, int length) {
		return ArrayUtils.subarray(this.bytes, index, index + length);
	}

}
