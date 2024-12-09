package video;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
class Video {
    String title;
    int duration;
    public Video(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
}
public class VideoScheduler {
    public static List<Video> generateRandomSchedule(List<Video> videoList, int totalTime) {
    	List<Video> schedule = new ArrayList<>();
        int remainingTime = totalTime;
        Random random = new Random();
        Video previousVideo=null;
        Video selectedVideo;
        while (remainingTime > 0) {
        	selectedVideo = videoList.remove(random.nextInt(videoList.size()));
            if (selectedVideo.duration <= remainingTime && selectedVideo!=previousVideo) {
                schedule.add(selectedVideo);
                remainingTime -= selectedVideo.duration;
            }
            previousVideo=selectedVideo;
            videoList.add(selectedVideo);
        }
        return schedule;
    }
    public static void main(String[] args) {
        try {
			BufferedReader lettoreRighe=new BufferedReader(new FileReader(args[0]));
			String riga=" ";
			String misto[];
			List<int> durata=new ArrayList<>(); 
			List<String> nomi=new ArrayList<String>();
			for (int i=0;riga!=null;i++) {
				riga=lettoreRighe.readLine();
				misto=riga.split(",");
				for(int j=0;i<misto.length;i++) {
					nomi.add(misto[0]);
				}
			}			
		}
		catch (Exception e) {
			System.out.println("ERRORE "+ e.getLocalizedMessage());
		}
        List<Video> videoList = new ArrayList<>();
        int tempo=Integer.parseInt(args[1]);
        List<Video> schedule = generateRandomSchedule(videoList,tempo);
        System.out.println("Programma Casuale:");
        for (Video video : schedule) {
            System.out.println(video.title + " - " + video.duration + " min");
        }
    }
}