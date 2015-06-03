package view.notification;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class NotificationPanel extends BorderPane implements EventHandler{
	
	private static ArrayList<String> notificationList = new ArrayList<String>();
	
	private static int duration = 1;
	
	private Timeline timeline = new Timeline();
	private Label label = new Label("Mededelingen");
    private int count = 0;
	
	public NotificationPanel(){
		
		setId("notification-slider");
		
		setCenter(label);
		
		label.setAlignment(Pos.CENTER);
		label.setFont(new Font("Calibri", 42));
		label.setWrapText(true);
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(duration), this));
		timeline.playFromStart();
		
	}

	@Override
	public void handle(Event event) {
		
		if(notificationList.size() == 0){
			label.setText("Er zijn op dit moment geen mededelingen...");
			return;
		}
		
		if (notificationList.size() == count) {
			count = 0;
		}
		
		// update Label with Array title
		// change to array with Announcements
		String current = notificationList.get(count);
		label.setText(current);
		
		count++;
		
	}
	
	public static void insert(String notification){
		notificationList.add(notification);
	}
	
	public static void clear(){
		notificationList.clear();
	}
	
}