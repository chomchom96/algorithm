import java.util.*;

public class Solution {
    public static String solution(String play_time, String adv_time, String[] logs) {
        int playTimeSeconds = timeToSeconds(play_time);
        int advTimeSeconds = timeToSeconds(adv_time);

        long[] viewCount = new long[playTimeSeconds + 1];

        // 각 로그에 대해 시청 시간 기록
        for (String log : logs) {
            String[] times = log.split("-");
            int start = timeToSeconds(times[0]);
            int end = timeToSeconds(times[1]);
            viewCount[start]++;
            if (end <= playTimeSeconds) {
                viewCount[end]--;
            }
        }

        // 누적 시청 시간 계산
        for (int i = 1; i <= playTimeSeconds; i++) {
            viewCount[i] += viewCount[i - 1];
        }

        // 광고 시간 구간의 최대 시청 시간 찾기
        long maxViewTime = 0;
        long currentViewTime = 0;
        int maxStartTime = 0;

        // 초기 광고 시간 구간의 시청 시간 계산
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

    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {
            "01:00:00-01:30:00",
            "01:00:00-01:30:00",
            "00:30:00-01:00:00"
        };
        System.out.println(solution(play_time, adv_time, logs));  // 출력 예시: "01:00:00"
    }
}
