/**
 * Created by suchintan on 2014-09-08.
 */
public class GenerateData {

    //generate a comma separated list of userdata
    //taxonomy:
    //{userid}, {dayofweek}:{hour}:{numberofsessions}, ... [repeated for each possible hour in a week]

    //the data represents the number of play sessions the user has had
    public static void main(String[] args) {
        int useridmax = 10000000; //10m possible users
        int totalIterations = 7 * 24; //7 days in a week, 24 hours in a day.
        int sessionMax = 4; //0 to 3 session count in any given timeslot

        int numusers = 25000;

        for(int c = 0; c < numusers; c++){
            int userid = (int)(Math.random() * useridmax);
            String s = userid + ",";
            for(int d = 0; d < totalIterations; d++){
                //let's say that on average, the user only goes on once every 10 times

                int dayofweek = d / 24;
                int hour = d % 24;
                int sessions = 0;

                if((int)(Math.random() * 10) == 0){
                    sessions = (int)(Math.random()*sessionMax);
                }
                s += dayofweek + ":" + hour + ":" + sessions;

                s += ",";
            }
            s = s.substring(0, s.length()-1); //remove the last comma.. not needed
            System.out.println(s);

            //reset s for the next user
            s = "";
        }

    }
}
