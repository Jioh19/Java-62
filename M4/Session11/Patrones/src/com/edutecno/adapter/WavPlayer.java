package com.edutecno.adapter;
//Sólo implementa los métodos que le concierne a los WAV
public class WavPlayer implements MediaPlayerAdvance{

	@Override
	public void playMp3(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playWav(String fileName) {
		System.out.println("Haciendo Play al wav, Nombre: " + fileName);
		
	}

}
