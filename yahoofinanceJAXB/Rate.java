
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "rate")
public class Rate {
    private String id;
    private String name;
    private String rate;
    private String date;
    private String time;
    private String ask;
    private String bid;

    public Rate() {}

    public Rate(String id, String name, String rate, String date, String time, String ask, String bid) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.date = date;
        this.time = time;
        this.ask = ask;
        this.bid = bid;
    }

    @Override
    public String toString() {
        StringBuilder sbr = new StringBuilder();
        sbr.append("Id: " + id + " \n")
                .append("Name: " + name + " \n")
                .append("Rate: " + rate + " \n")
                .append("Date: " + date + " \n")
                .append("Time: " + time + " \n")
                .append("Ask: " + ask + " \n")
                .append("Bid: " + bid + " \n");

        return sbr.toString();
    }

    public String getId() {
        return id;
    }

    @XmlAttribute(name="id")
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name="Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    @XmlElement(name="Rate")
    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    @XmlElement(name="Date")
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    @XmlElement(name="Time")
    public void setTime(String time) {
        this.time = time;
    }

    public String getAsk() {
        return ask;
    }

    @XmlElement(name="Ask")
    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBid() {
        return bid;
    }

    @XmlElement(name="Bid")
    public void setBid(String bid) {
        this.bid = bid;
    }



}
