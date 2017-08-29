
import javax.xml.bind.annotation.*;
import java.util.Date;

//@XmlRootElement(name="train")
@XmlAccessorType(XmlAccessType.FIELD)
// определяем последовательность тегов в XML
@XmlType(propOrder = {"from", "to", "date", "departure"})
public class Train {
    @XmlAttribute
    private int id;
    @XmlElement
    private String from;
    @XmlElement
    private String to;
    @XmlElement
    private String date;
    @XmlElement
    private String departure;

    @Override
    public String toString() {
        return "[ train id = " + id + ", from = " + from + ", to = " + to + ", date = " + date + " departure =" + departure +"]";
    }
    //Id
    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id;  }
   //From
    public String getFrom() {   return from;  }
    public void setFrom(String from) {
        this.from = from;
    }
   //To
    public String getTo() {  return to; }
    public void setTo(String to) {
        this.to = to;
    }
    //Date
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    //Departure
    public String getDeparture() {
    return departure;
}
    public void setDeparture(String departure) {
        this.departure = departure;
    }

}
