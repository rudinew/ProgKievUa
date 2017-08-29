
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {
    public static void main(String[] args)  throws Exception{

    // читаем из файла
        String fileDir = "d://yahoo.xml";

        String request = "http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        String result = performRequest(request);
        //Prints formatted representations of objects to a text-output stream
        PrintWriter pr = new PrintWriter(fileDir);
        try {
            pr.write(result);
        } finally{
            pr.close();

            Query query = new Query();

            try {
                File f = new File(fileDir);
                JAXBContext jaxbContext = JAXBContext.newInstance(Query.class);
                Unmarshaller unm = jaxbContext.createUnmarshaller();
                query = (Query) unm.unmarshal(f);

                for (Rate rate : query.results.rates) {
                    System.out.println(rate.getId() + "=" + rate.getRate());
                    System.out.println(rate.getBid());
                }

                System.out.println();
                System.out.println(query.toString());
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
        } finally {
            http.disconnect();
        }

        return sb.toString();
    }

}
