package com.edutecno.adapter;

public class VlcPlayer implements MediaPlayer{
	private MediaPlayer mediaPlayer;
	
	//Llama a MediaAdapter segun el tipo de audio, si bien parece al patrón fábrica, este
	//objeto es invisible para el usuario
	@Override
	public void play(String tipoAudio, String fileName) {
		mediaPlayer = new MediaAdapter(tipoAudio);
		mediaPlayer.play(tipoAudio, fileName);
	}
}
