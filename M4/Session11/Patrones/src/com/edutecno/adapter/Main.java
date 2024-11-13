package com.edutecno.adapter;

public class Main {
	public static void main(String[] args) {
		VlcPlayer vlc = new VlcPlayer();
		
		vlc.play("mp3", "Hotel California");
		vlc.play("wav", "Welcome to the Jungle");
		vlc.play("acc", "Bohemian Rapsody");
	}
}
