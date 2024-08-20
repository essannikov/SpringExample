package springExample.MusicPlayer.genres;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import springExample.MusicPlayer.MusicAbstract;

//@Component
public class RapMusic extends MusicAbstract{
	@Override
	public List<String> getSong() {
		List<String> songList = new ArrayList<>();
		
		songList.add("Not Afraid");
		songList.add("Still D.R.E");
		songList.add("In da Club");
		
		return songList;
	}
}
