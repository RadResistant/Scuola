package progettoVideo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        List<Video> videoList = new ArrayList<>();
        videoList.add(new Video("Video 1", 5));
        videoList.add(new Video("Video 2", 8));
        videoList.add(new Video("Video 3", 10));
        int totalMinutes = 120;
        List<Video> schedule = generateRandomSchedule(videoList, totalMinutes);
        System.out.println("Programma Casuale:");
        for (Video video : schedule) {
            System.out.println(video.title + " - " + video.duration + " min");
        }
    }
}