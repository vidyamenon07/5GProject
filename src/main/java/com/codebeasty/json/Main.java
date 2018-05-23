package com.codebeasty.json;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.*;
import java.net.URL;
import java.net.URLConnection;
import org.apache.http.client.utils.URIBuilder;

public class Main {

    private static Scanner input;

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> list = new LinkedList<>();
        List<Double> totArr = new ArrayList<>();

        if (args.length == 0) {
            System.out.println("File name not specified.");
            System.exit(1);
        }

        try {
            File file = new File(args[0]);
            input = new Scanner(file);
        } catch (IOException ioException) {
            System.err.println("Cannot open file.");
            System.exit(1);
        }

        int total = 0;
        int i = 0;
        while (input.hasNextLine()) {
            total += 1;
            String line = input.nextLine();
            list.add(line);
        }
        String[] array = list.toArray(new String[list.size()]);

        Double[] storeTotal = new Double[0];
        double totalval;
        for (i = 0; i < array.length; i++) {
            String present = null;
            List<String> single = new LinkedList<>();
            present = array[i];

            StringTokenizer st2 = new StringTokenizer(present, ",");
            while (st2.hasMoreElements()) {
                single.add(st2.nextToken());
            }
            String[] storeline = single.toArray(new String[single.size()]);

            int j = 0;
            totalval = 0;
            for (j = 0; j < storeline.length; j++) {
                String getval = null;
                getval = storeline[j];
                List<String> arr = new LinkedList<>();
                StringTokenizer st = new StringTokenizer(getval, "-");
                while (st.hasMoreElements()) {
                    arr.add(st.nextToken());
                }
                String[] getfinalval = arr.toArray(new String[arr.size()]);

                int x = 0;
                Double value = readHTML(getfinalval[0]);
                double newval;
                newval = Double.parseDouble(String.valueOf(value));
                double cal = 0;
                double q = Double.parseDouble(getfinalval[1]);
                cal = newval * q;
                totalval = totalval + cal;
                cal=0;
            }
            totArr.add(totalval);

            storeTotal = totArr.toArray(new Double[totArr.size()]);
            totalval = 0;
        }
        int x=0;
        int y=0;
        Double temp= Double.valueOf(0);
        String temp1="";
        for(x=0;x<storeTotal.length;x++)
        {
            for(y=x+1;y<storeTotal.length;y++)
            {
                if(storeTotal[x]<storeTotal[y])
                {
                    temp1=array[x];
                    array[x]=array[y];
                    array[y]=temp1;
                    temp=storeTotal[x];
                    storeTotal[x]=storeTotal[y];
                    storeTotal[y]=temp;

                }
            }
        }

            int z=0;
            for(z=0;z<array.length;z++)
                System.out.println(" " + array[z]);
            input.close();
    }
    public static Double readHTML(String symbol) throws IOException, URISyntaxException {
        URIBuilder b = new URIBuilder("https://www.alphavantage.co/query");
        b.addParameter("function", "BATCH_STOCK_QUOTES");
        b.addParameter("symbols", symbol);
        b.addParameter("apikey","5L08WDLXGEVD83RJ");
        URL url = b.build().toURL();

        String price = "not found";
       try{
            URLConnection urlconn = url.openConnection();
            InputStreamReader inputStream = new InputStreamReader(urlconn.getInputStream());
            BufferedReader buff = new BufferedReader(inputStream);
            String line = buff.readLine();
            while(line != null)
            {
                line = buff.readLine();
                if(line.contains("price"))
                {
                    int target=line.indexOf("price");
                    int deci=line.indexOf(".",target);
                    int start=deci;
                    while(line.charAt(start) != '\"')
                    {
                        start--;
                    }

                    price = line.substring(start+1,deci+3);
                    break;
                }


            }

            return Double.valueOf(price);
        }
        catch(NullPointerException ex)
        {
            return null;
        }

    }

}
