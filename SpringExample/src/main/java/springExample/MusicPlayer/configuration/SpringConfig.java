package springExample.MusicPlayer.configuration;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import springExample.MusicPlayer.Computer;
import springExample.MusicPlayer.MusicAbstract;
import springExample.MusicPlayer.MusicGenre;
import springExample.MusicPlayer.MusicPlayer;
import springExample.MusicPlayer.genres.ClassicalMusic;
import springExample.MusicPlayer.genres.RapMusic;
import springExample.MusicPlayer.genres.RockMusic;

@Configuration
//@ComponentScan("springExample.MusicPlayer") //for automatic search of beans
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
	@Bean
	@Scope("prototype")
	public ClassicalMusic classicalMusic() {
		return ClassicalMusic.getClassicalMusic();
	}
	
	@Bean
	public RockMusic rockMusic() {
		return new RockMusic();
	}
	
	@Bean
	public RapMusic rapMusic() {
		return new RapMusic();
	}
	
	@Bean
	public HashMap<MusicGenre, MusicAbstract> musicList(){
		HashMap<MusicGenre, MusicAbstract> musicList = new HashMap<>();
		
		musicList.put(MusicGenre.CLASSICAL, classicalMusic());
		musicList.put(MusicGenre.ROCK, rockMusic());
		musicList.put(MusicGenre.RAP, rapMusic());
		
		return musicList;
	}
	
	@Bean
	public MusicPlayer musicPlayer() {
		return new MusicPlayer(musicList());
	}
	
	@Bean
	public Computer computer() {
		return new Computer(musicPlayer());
	}
}
