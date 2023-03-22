package ar.edu.unlp.info.oo2.ejercicio_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaTest {
	private MediaPlayer mediaPlayer;
	
	@BeforeEach
	void setUp() {
		mediaPlayer = new MediaPlayer();
	}
	
	@Test
	void test() {

		this.mediaPlayer.addMedia(new Audio());
		this.mediaPlayer.addMedia(new VideoFile());
		this.mediaPlayer.addMedia(new Adaptador(new VideoStream()));
		
		this.mediaPlayer.reproducir();
	
	}
}
