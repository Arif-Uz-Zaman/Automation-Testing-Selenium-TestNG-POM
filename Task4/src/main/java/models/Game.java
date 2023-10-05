package models;

public class Game {

	private String gameName;
	public Game(String gameName, int currentPlayers) {
		this.gameName = gameName;
		this.currentPlayers = currentPlayers;
	}
	private int currentPlayers;
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public int getCurrentPlayers() {
		return currentPlayers;
	}
	public void setCurrentPlayers(int currentPlayers) {
		this.currentPlayers = currentPlayers;
	}
	@Override
	public String toString() {
		return "Game [gameName=" + gameName + ", currentPlayers=" + currentPlayers + "]";
	}
	
	
}
