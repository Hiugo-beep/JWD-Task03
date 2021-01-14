package by.jwd.parsexml.reader.impl;

import java.util.List;

import by.jwd.parsexml.reader.ParserReader;

public class ParserReaderImpl implements ParserReader{
	private static int numberBytesToRead = 50;
	private int startByteToRead;
	private int bytesRead;
	private String buffer;
	private String fileRead;
	
	public ParserReaderImpl(){
		this.startByteToRead = 0;
		this.bytesRead = numberBytesToRead;
		this.buffer = "";
		this.fileRead = "";
	}
	
	private int readBytes(int startByteToRead, int numberBytesRead) {
		//здесь произойдет считка байт в потоке
		return 0;
	}
	private void filterSpaces() {
		//чистка в буфере более одного пробела
	}
	@Override
	public String readFile(String fileName){
		while(bytesRead == numberBytesToRead) { 
			bytesRead = this.readBytes(startByteToRead, bytesRead); 
			fileRead += buffer;
		}
		return fileRead;
	}

}