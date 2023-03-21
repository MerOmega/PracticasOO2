package ar.edu.unlp.info.oo2.ejercicio_1;

public class Tweet {
	private Tweet tweetOrigen;
	private String cuerpo;
	
	
	public Tweet getTweetOrigen() {
		return tweetOrigen;
	}
	public void setTweetOrigen(Tweet tweetOrigen) {
		this.tweetOrigen = tweetOrigen;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	
	public void setCuerpo(String cuerpo) throws Exception {
		try {
			if ((cuerpo.length() >=1) && (cuerpo.length() <= 280)){
				this.cuerpo = cuerpo;
			}else {
				throw new Exception();
			}
		}catch (Exception e) {
			throw new Exception ("El cuerpo debe ser como minimo de 1 caracter"
				+ "y como maximo 280 caracteres", e);
		}
	}
	
	@Override
	public String toString() {
		return "Tweet [tweetOrigen=" + tweetOrigen + ", cuerpo=" + cuerpo + "]";
	}
	
	public Tweet(Tweet tweetOrigen, String cuerpo) throws Exception {
		super();
		try {
			if ((cuerpo.length() >=1) && (cuerpo.length() <= 280)){
				this.cuerpo = cuerpo;
			}else {
				throw new Exception();
			}
			if (tweetOrigen != null) {
				this.tweetOrigen = tweetOrigen;
			}
			
		}catch (Exception e) {
			throw new Exception ("El cuerpo debe ser como minimo de 1 caracter"
					+ "y como maximo 280 caracteres", e);
		}
		
	}
	
	
	
}
	
	
