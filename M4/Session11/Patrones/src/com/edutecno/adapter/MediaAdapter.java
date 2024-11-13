package com.edutecno.adapter;
//Clase encargada de instancias a los objetos según el tipo ingresado
//Además encargada de hacer play a los archivos
public class MediaAdapter  implements MediaPlayer{
	MediaPlayerAdvance mediaPlayerAdvance;
	

	public MediaAdapter(String tipoAudio) {
		if(tipoAudio.equalsIgnoreCase("mp3")) {
			mediaPlayerAdvance = new Mp3Player();
		} else if(tipoAudio.equalsIgnoreCase("wav")) {
			mediaPlayerAdvance = new WavPlayer();
		} else {
			System.out.println("Formato no soportado");
		}
	}

	@Override
	public void play(String tipoAudio, String fileName) {
		if(tipoAudio.equalsIgnoreCase("mp3")) {
			mediaPlayerAdvance.playMp3(fileName);
		} else if(tipoAudio.equalsIgnoreCase("wav")) {
			mediaPlayerAdvance.playWav(fileName);
		} 
	}

}
