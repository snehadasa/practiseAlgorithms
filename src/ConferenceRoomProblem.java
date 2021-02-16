    import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    public class ConferenceRoomProblem {
        static class Pair {
            int startTime;
            int endTime;

            public int getStartTime() {
                return startTime;
            }

            public void setStartTime(int startTime) {
                this.startTime = startTime;
            }

            public int getEndTime() {
                return endTime;
            }

            public void setEndTime(int endTime) {
                this.endTime = endTime;
            }

            public Pair(int startTime, int endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }
        }



        public boolean ifComingInBetween(Pair pair1, Pair pair2) {
            if (pair2.getStartTime() > pair1.getStartTime() && pair2.getStartTime() < pair1.getEndTime()) {
                return true;
            }
            else if(pair1.getStartTime() > pair2.getStartTime() && pair1.getStartTime() < pair2.getEndTime()) {
                return true;
            }
            return false;
        }

        public int conferenceRoomProb(List<Pair> timeSlots) {
            int maxCount = 0;
            for (Pair p1 : timeSlots) {
                int count =0;
                for (Pair p2 : timeSlots) {
                    if (ifComingInBetween(p1, p2)) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
            return maxCount;
        }


        static class StartOrEndTime {
            public StartOrEndTime(int time, boolean isStartTime) {
                this.time = time;
                this.isStartTime = isStartTime;
            }

            public int getTime() {
                return time;
            }

            public boolean isStartTime() {
                return isStartTime;
            }

            int time;
            boolean isStartTime;
        }

        public int conferenceRoomProb1(List<Pair> timeSlots) {
            int maxCount = 0;
            List<StartOrEndTime> startOrEndTimes = new ArrayList<>();
            for (Pair p : timeSlots) {
                startOrEndTimes.add(new StartOrEndTime(p.getStartTime(), true));
                startOrEndTimes.add(new StartOrEndTime(p.getEndTime(), false));
            }
            Collections.sort(startOrEndTimes, (p1, p2) -> p1.getTime() - p2.getTime());
            int count = 0;
            for (StartOrEndTime time : startOrEndTimes) {
                if (time.isStartTime) {
                    count++;
                } else {
                    count--;
                }
                if (count > maxCount) {
                    maxCount = count;
                }
            }
            return maxCount;
        }
        public static void main(String[] args) {
            ConferenceRoomProblem res = new ConferenceRoomProblem();
            Pair p1 = new Pair(1030, 1130);
            Pair p2 = new Pair(1100, 1115);
            List<Pair> timeslots = new ArrayList<>();
            timeslots.add(p1);
            timeslots.add(p2);
            System.out.println(res.conferenceRoomProb1(timeslots));
        }
    }

