import java.util.*;

class Solution {
    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTimeSeconds = timeToSeconds(play_time);
        int advTimeSeconds = timeToSeconds(adv_time);

        long[] viewCount = new long[playTimeSeconds + 1];

        for (String log : logs) {
            String[] times = log.split("-");
            int start = timeToSeconds(times[0]);
            int end = timeToSeconds(times[1]);
            viewCount[start]++;
            if (end <= playTimeSeconds) {
                viewCount[end]--;
            }
        }

        for (int i = 1; i <= playTimeSeconds; i++) {
            viewCount[i] += viewCount[i - 1];
        }

        long maxViewTime = 0;
        long currentViewTime = 0;
        int maxStartTime = 0;

        for (int i = 0; i < advTimeSeconds; i++) {
            currentViewTime += viewCount[i];
        }

        maxViewTime = currentViewTime;

        for (int start = 1; start <= playTimeSeconds - advTimeSeconds; start++) {
            currentViewTime = currentViewTime - viewCount[start - 1] + viewCount[start + advTimeSeconds - 1];
            if (currentViewTime > maxViewTime) {
                maxViewTime = currentViewTime;
                maxStartTime = start;
            }
        }

        return secondsToTime(maxStartTime);
    }

    private static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }

    private static String secondsToTime(int seconds) {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

 
}
