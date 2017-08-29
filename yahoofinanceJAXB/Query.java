
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "query")
public class Query {
    private String count;
    private String created;
    private String lang;
    Results results;

    public Query () {

    }

    public Query(String count, String created, String lang, Results results) {
        this.count = count;
        this.created = created;
        this.lang = lang;
        this.results = results;
    }

    @Override
    public String toString() {
        StringBuilder sbq = new StringBuilder();
        sbq.append("Count: " + count + " \n")
                .append("Created: " + created + " \n")
                .append("Lang: " + lang + " \n")
                .append("Result: " + results.toString() + " \n");

        return sbq.toString();
    }



    public String getCount() {
        return count;
    }

    @XmlAttribute(name="count", namespace="http://www.yahooapis.com/v1/base.rng")
    public void setCount(String count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    @XmlAttribute(name="created", namespace="http://www.yahooapis.com/v1/base.rng")
    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    @XmlAttribute(name="lang", namespace="http://www.yahooapis.com/v1/base.rng")
    public void setLang(String lang) {
        this.lang = lang;
    }

    public Results getResults() {
        return results;
    }

    @XmlElement(name="results")
    public void setResults(Results results) {
        this.results = results;
    }
}
