package springExample.MusicPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class MusicPlayer {
	private HashMap<MusicGenre, MusicAbstract> musicList = new HashMap<>();
	
	@Value("${musicPlayer.name}")
	private String name;
	@Value("${musicPlayer.volume}")
	private int volume;
	
	private final String MUSIC_NOT_FOUND = "Not found";
	
	
	//IoC
	public MusicPlayer(HashMap<MusicGenre, MusicAbstract> musicList) {
		this.musicList = musicList;
	}
	
	//@Autowired
	public MusicPlayer(@Qualifier("classicalMusic") MusicAbstract musicClassical, 
			           @Qualifier("rockMusic") MusicAbstract musicRock,
			           @Qualifier("rapMusic") MusicAbstract musicRap) {
		this.musicList.put(MusicGenre.CLASSICAL, musicClassical);
		this.musicList.put(MusicGenre.ROCK, musicRock);
		this.musicList.put(MusicGenre.RAP, musicRap);
	}
	
	public MusicPlayer() {}
	
	
	public String playMusic(MusicGenre musicGenre) {		
		String text = "";
//		try {
//			text = Optional.ofNullable(musicList.get(musicGenre)).map(
//						m -> { 
//							List<String> listSongs = m.getSong();
//							return listSongs.get(new Random().nextInt(listSongs.size()));
//					}).orElse(MUSIC_NOT_FOUND);
//		} catch (Exception e) {
//			text = MUSIC_NOT_FOUND;
//		}
		
		return "Playing: " + text;
	}
	
	
	public HashMap<MusicGenre, MusicAbstract> getMusicList() {
		return musicList;
	}

	public void setMusicList(HashMap<MusicGenre, MusicAbstract> musicList) {
		this.musicList = musicList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	@Override
	public String toString() {
		//this.musicList.stream().forEach(m -> { System.out.println("Playing: " + m.getSong()); });
		//String result = this.musicList.stream().map(Object::toString).collect(Collectors.joining(", "));
		
		return this.name + " (volume: " + String.valueOf(volume) + ")";
	}
}
