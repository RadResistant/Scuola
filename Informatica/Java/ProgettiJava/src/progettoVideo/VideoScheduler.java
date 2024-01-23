package progettoVideo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Video {
    String title;
    int duration; // Durata in minuti

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

        while (remainingTime > 0) {
            // Seleziona un video a caso dalla lista
            Video selectedVideo = videoList.remove(random.nextInt(videoList.size()));

            // Verifica se la durata del video è minore del tempo rimanente
            if (selectedVideo.duration <= remainingTime) {
                // Aggiungi il video allo scheduler
                schedule.add(selectedVideo);

                // Sottrai la durata del video dal tempo rimanente
                remainingTime -= selectedVideo.duration;
            }
        }

        return schedule;
    }

    public static void main(String[] args) {
        List<Video> videoList = new ArrayList<>();
        videoList.add(new Video("Video 1", 5));
        videoList.add(new Video("Video 2", 8));
        videoList.add(new Video("Video 3", 10));
        // Aggiungi altri video secondo necessità

        int totalMinutes = 120; // Durata totale in minuti

        List<Video> schedule = generateRandomSchedule(videoList, totalMinutes);

        // Stampa il programma casuale
        System.out.println("Programma Casuale:");
        for (Video video : schedule) {
            System.out.println(video.title + " - " + video.duration + " min");
        }
    }
}