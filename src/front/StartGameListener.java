package front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import back.Settings;

class StartGameListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		Application.startGame();
	}
}
class SettingsListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		/*
		 * открытие окна настроек
		 */
	}
}
class Player1NameListener implements TextListener{
	@Override
	public void textValueChanged(TextEvent e) {
		Settings.PLAYER_1_NAME = ""; //= something		
	}	
}