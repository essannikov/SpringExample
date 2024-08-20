package springExample.MusicPlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Computer {
	private int id;
	private MusicPlayer musicPlayer;
	
	//@Autowired
	public Computer(MusicPlayer musicPlayer) {
		this.id = 1;
		this.musicPlayer = musicPlayer;
	}
	
	public void execProcess() {
		System.out.println("MusicPlayer = " + musicPlayer.toString() + " " + musicPlayer.playMusic(MusicGenre.CLASSICAL));
		System.out.println("MusicPlayer = " + musicPlayer.toString() + " " + musicPlayer.playMusic(MusicGenre.ROCK));
		System.out.println("MusicPlayer = " + musicPlayer.toString() + " " + musicPlayer.playMusic(MusicGenre.RAP));
	}

	@Override
	public String toString() {
		return "Computer id = " + id;
	}
}
