package springExample.MusicPlayer.genres;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import springExample.MusicPlayer.MusicAbstract;

//@Component
public class RockMusic extends MusicAbstract{
	@Override
	public List<String> getSong() {
		List<String> songList = new ArrayList<>();
		
		songList.add("Wind cries Mary");
		songList.add("The Unforgiven");
		songList.add("Smells Like Teen Spirit");
		
		return songList;
	}
}
