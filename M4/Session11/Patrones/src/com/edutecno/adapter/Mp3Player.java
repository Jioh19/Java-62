package com.edutecno.adapter;
//Sólo implementa los métodos que le concierne a los MP3
public class Mp3Player implements MediaPlayerAdvance{

	@Override
	public void playMp3(String fileName) {
		System.out.println("Haciendo play al archivo mp3, Nombre: " + fileName);
		
	}

	@Override
	public void playWav(String fileName) {
		// TODO Auto-generated method stub
		
	}

}
