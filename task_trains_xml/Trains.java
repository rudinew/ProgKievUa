import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "trains")
@XmlAccessorType(XmlAccessType.FIELD)
public class Trains {

    @XmlElement(name="train")
    private List<Train> trains = new ArrayList<Train>();

    public void addTrains(Train train) {
        trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }

    // поезда в заданом промежутке времени
    public void  trainBetween(String date, String timeFrom, String timeTo) {
        List<Train> trainList = new ArrayList<Train>();
        for(int i = 0; i < trains.size(); i++) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            try {
                //Parses text from a string to produce a Date.
                Date dtFrom = dateFormat.parse(date + " " + timeFrom);
                Date dtTo = dateFormat.parse(date + " " + timeTo);
                Date dateTrain = dateFormat.parse(trains.get(i).getDate() + " " + trains.get(i).getDeparture());

                if(dateTrain.after(dtFrom) && dateTrain.before(dtTo)) {
                    trainList.add(trains.get(i));
                 }

            } catch(ParseException e) {
                e.printStackTrace();
            }
        }
        if (trainList.isEmpty()){
            System.out.println(String.format("%1$s c %2$s по %3$s нет поездов", date, timeFrom, timeTo) );
        }
        else{
            System.out.println(String.format("Список поездов на дату %1$s c %2$s по %3$s", date, timeFrom, timeTo));
            for (Train t: trainList){
                System.out.println("поезд № " + t.getId() + " город с " + t.getFrom() + " город до " + t.getTo());
            }
        }

    }

    @Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }
}
