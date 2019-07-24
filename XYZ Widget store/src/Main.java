import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Record> r2;

    public static void main(String[] args) {
        Queue<Record> recordque = new LinkedQueue<Record>();
        Main mainer = new Main();
        r2 = new ArrayList<Record>();
        mainer.getData();

        for (Record r : r2) {
            if (r.type.equals("R")) {
                System.out.println(r.number + " widgets for the price of " + r.price);
                recordque.insert(r);
            } else if (r.type.equals("P")) {
                System.out.println(r.number + "% discount for the next 2 customers ");

            } else if (r.type.equals("S")) {


            }
        }

        for(Record list: r2){
            if(list.type.equals("S")){

                if(list.number<recordque.iterator().next().number) {

                    recordque.iterator().next().number -= list.number;

                    System.out.println(list.number + "widgets sold");
                    System.out.println(list.number +" at " + recordque.iterator().next().price + list.number*recordque.iterator().next().price);
                    System.out.println(" ");
                    System.out.println(" ");
                }
                else if(list.number>recordque.iterator().next().number){
                    System.out.println(list.number + " widgets sold");
                    double holder = list.number;
                    while(holder>recordque.iterator().next().number){

                        holder = holder- recordque.iterator().next().number;
                        if(holder >= 0){
                            System.out.println(recordque.iterator().next().number+ " at" + recordque.iterator().next().price);
                            recordque.delete();
                        }
                        else{
                            System.out.println((recordque.iterator().next().number+holder) + " at " +recordque.iterator().next().price);
                            holder = recordque.iterator().next().number - holder;
                            recordque.iterator().next().number= recordque.iterator().next().number + holder;
                            System.out.println(recordque.iterator().next().number);


                        }

                    }
                }
            }
        }





            for (Record ii : recordque) {
                System.out.println(ii.number +"     " +ii.price);

            }




    }
    static void getData(){
        try{
            File file = new File("/Users/saheedandrew/Desktop/3115 folder/XYZ Widget store/src/data");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line=reader.readLine())!=null){
                addRecord(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void addRecord(String lineToParse){
        String[] tokens = lineToParse.split(" ");
        if (tokens.length == 3){
            Record temp = new Record(tokens[0], Double.valueOf(tokens[1]),Double.valueOf(tokens[2]));
            r2.add(temp);
        }
        else if(tokens.length ==2){
            Record temp = new Record(tokens[0], Double.valueOf(tokens[1]));
            r2.add(temp);
        }
        else{

        }
    }

}
