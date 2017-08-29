
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Есть список поездов, представленный с виде XML. Вывести на экран информацию о тех поездах, которые
 * отправляются сегодня с 15:00 до 19:00.
 */
public class Main {
    public static void main(String[] args) {
        String path = "d:\\trains.xml";
        // читаем из файла
        Trains trains = unmarshallerTrains(path);
        //Выводим на экран информацию о всех поездах
        System.out.println(trains);
        //Выводим на экран информацию о тех поездах, которые отправляются на выбраную дату и диапозон времени
        trains.trainBetween("25.06.2016", "15:00", "19:00");
        //добавить новые поезда
        addTrainFromConsole(trains); // new Trains();
        //записываем в файл
        marshallerTrains(path, trains);
    }

    public static Trains unmarshallerTrains(String path ) {
        Trains trains = new Trains();
        try {
            // читаем из файла
            File file = new File(path); // new File(path);
            JAXBContext context = JAXBContext.newInstance(Trains.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trains;
    }

    public static void marshallerTrains(String path, Trains trains){
     //   Trains trains = new Trains();
        try {
            //RandomAccessFile file = new RandomAccessFile(path, "rw");

             File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Marshaller marshaller = jaxbContext.createMarshaller();  //синоним сериализации

            // читабельное форматирование
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  //без него док сохранится в одну строку

            // пишем в файл
            marshaller.marshal(trains, file);
            //выводим содержимое
            marshaller.marshal(trains, System.out);



        }
     catch (JAXBException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

    public static void addTrainFromConsole(Trains trains){
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while (true) {
            try {
                Train trainNew = new Train();
                //train id
                System.out.println("введите train id");
                s = reader.readLine();
                if (s.isEmpty()) {
                    System.out.println("введение данных закончено");
                    break;
                } else
                {
                    trainNew.setId(Integer.parseInt(s));
                }
                //from
                System.out.println("введите from");
                s = reader.readLine();
                if (s.isEmpty()) {
                    System.out.println("введение данных закончено");
                    break;
                } else
                {
                    trainNew.setFrom(s);
                }
                //to
                System.out.println("введите to");
                s = reader.readLine();
                if (s.isEmpty()) {
                    System.out.println("введение данных закончено");
                    break;
                } else
                {
                    trainNew.setTo(s);
                }
                //date
                System.out.println("введите date");
                s = reader.readLine();
                if (s.isEmpty()) {
                    System.out.println("введение данных закончено");
                    break;
                } else
                {
                    trainNew.setDate(s);
                }
                // departure
                System.out.println("введите departure");
                s = reader.readLine();
                if (s.isEmpty()) {
                    System.out.println("введение данных закончено");
                    break;
                } else
                {
                    trainNew.setDeparture(s);
                }

              trains.addTrains(trainNew);
              
            }
            catch (IOException e) {
                e.printStackTrace();
            }

       
        }
    }
}
