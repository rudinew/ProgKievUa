
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


    @XmlRootElement(name="results")
    public class Results {

        @XmlElement(name="rate")
        protected List<Rate> rates = new ArrayList<Rate>();

        public void add(Rate rate) {
            rates.add(rate);
        }

        public Rate getRate( int i) {
            return rates.get(i);
        }

        @Override
        public String toString() {
            return Arrays.deepToString(rates.toArray());
        }
    }
