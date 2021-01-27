package by.jwd.parsexml.reader.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;

import by.jwd.parsexml.reader.ParserReader;

public class ParserReaderImpl implements ParserReader{
	private static int numberBytesToRead = 500;
	private int offsetByteToRead;
	private int bytesRead;
	private byte[] buffer;
	private String fileRead;
	private int bytesAvailable;
	
	public ParserReaderImpl(){
		this.offsetByteToRead = 0;
		this.bytesAvailable = 0;
		this.bytesRead = numberBytesToRead;
		this.buffer = new byte [numberBytesToRead];
		this.fileRead = "";
	}
	
	private void filterSpaces() {
		String wordSeparator = "\s\s+";//2 и более символов - разделителей
		String[] result;
		Pattern pattern = Pattern.compile(wordSeparator);
		result = pattern.split(fileRead);
		this.mergeTokens(result);
	}
	private void mergeTokens(String[] tokens) {
		this.fileRead = "";
		for(String str : tokens) {
				fileRead += str;
		}
	}
		
	@Override
	public String readFile( String fileName ) throws IOException {
		
		FileInputStream inFile = new FileInputStream( fileName );
		
		while(bytesRead == numberBytesToRead) { 

			bytesAvailable = inFile.available();
			if( bytesAvailable > numberBytesToRead ) 
				bytesAvailable = numberBytesToRead;

			bytesRead = inFile.read( buffer, offsetByteToRead, bytesAvailable );
			
			offsetByteToRead += bytesRead;
			fileRead += new String( buffer, "UTF-8" );
		}
		inFile.close();
		this.filterSpaces();
		return fileRead;
	}

}
