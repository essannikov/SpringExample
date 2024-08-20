package springExample.MusicPlayer.genres;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import springExample.MusicPlayer.MusicAbstract;

import javax.annotation.*;


//@Component
//@Scope("prototype")
public class ClassicalMusic extends MusicAbstract{
	private ClassicalMusic() {};
	
	public static ClassicalMusic getClassicalMusic() {
		return new ClassicalMusic();
	}
	
//	@PostConstruct
	public void doMyInit() {
		System.out.println("Doing my initialization");
	}
	
//	@PreDestroy
	public void doMyDestroy() {
		System.out.println("Doing my destruction");
	}
	
	@Override
	public List<String> getSong() {
		List<String> songList = new ArrayList<>();
		
		songList.add("Hungarian Rhapsody");
		songList.add("Fur Elise");
		songList.add("Moonlight Sonata");
		
		return songList;
	}
}
