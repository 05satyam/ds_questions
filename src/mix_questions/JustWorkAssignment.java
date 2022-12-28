/**
 * Submitted by: SATYAM MITTAL
 * email: satyam05@mail.fresnostate.edu
 * linkedin: https://www.linkedin.com/in/satyam-sm
 * brief: pursuing MS in computer science from Fresno State and graduating in december 2023.
 *
 * HOW TO RUN THE PROGRAM
 *
 * - No external jars required
 * - main method is used to run the application - located at the end of the code
 *
 * - in method printResultCSV() please change the output path as per your local system
 *     change path: PrintWriter writer = new PrintWriter("/Users/satyammittal/Desktop/output.csv");
 *
 * - in method readCSV() please change input path as per your local system
 *     change path:  BufferedReader br = new BufferedReader(new FileReader("/Users/satyammittal/Desktop/Intern_AccountTransaction-data.csv"));
 */

package mix_questions;

import java.io.*;
import java.util.*;

/**
 * Below class is used to store the ouput transaction data for a custid and then used to genrate the csv file
 *
 *  custId - store the user cust id  - Cust01
 *  dateAndYear - store the month/year  -- 11/2022
 *  minBalance - store th min balance for the month : -2000 for 11/2022
 *  maxBalance - store th maximum balance for the month : 4000 for 11/2022
 *  endingBalance - store th ending balance for the month : 5000 for 11/2022
 */
class TransactionsRecord {

    String custId;
    String dateAndYear;
    int minBalance, maxBalance, endingBalance;


    //default constructor
    TransactionsRecord() {
    }

    /**
     *
     * @param custId
     * @param dateAndYear
     * @param minBalance
     * @param maxBalance
     * @param endingBalance
     *
     * parametrized constructore
     */
    public TransactionsRecord(String custId, String dateAndYear, int minBalance, int maxBalance, int endingBalance) {
        this.custId = custId;
        this.dateAndYear = dateAndYear;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.endingBalance = endingBalance;
    }

    /**
     *
     * @return
     * Below method is used to override to-string method of class and used to write output into csv file
     */
    @Override
    public String toString(){
        StringBuilder dataBuilder = new StringBuilder();
        appendColumnData(dataBuilder, custId);
        appendColumnData(dataBuilder, String.valueOf(dateAndYear));
        appendColumnData(dataBuilder, String.valueOf(minBalance));
        appendColumnData(dataBuilder, String.valueOf(maxBalance));
        appendColumnData(dataBuilder, String.valueOf(endingBalance));


        return dataBuilder.toString();
    }

    /**
     *
     * @param dataBuilder
     * @param fieldValue
     *
     * below method is a helper method used in to-string method to create comma deparated feild values for csv
     */
    private void appendColumnData(StringBuilder dataBuilder, String fieldValue) {
        if(fieldValue != null) {
            dataBuilder.append(fieldValue).append(",");
        } else {
            dataBuilder.append("").append(",");
        }
    }


}

/**
 *  Below class is the main logic where-
 *
 *  1.  transaction calculation for each customer is done - calculateCustTranscations() method
 *  2.  final output is generated - calculateCustTranscations() method
 *  3.  input csv reading is done - readCSV() method
 *  4.  output csv is generated - printResultCSV() method
 */
public class JustWorkAssignment {

    //used for reading input file enteries
    Map<String, Map<String, Integer>> csvEnteries;

    //used for storing final output after implementing business logic
    LinkedList<TransactionsRecord> custToAccountTransaction;

    // below are the getter-setter for class "JustWorkAssignment"
    public Map<String, Map<String, Integer>> getCsvEnteries() {
        return csvEnteries;
    }

    public void setCsvEnteries(Map<String, Map<String, Integer>> csvEnteries) {
        this.csvEnteries = csvEnteries;
    }

    public LinkedList<TransactionsRecord> getCustToAccountTransaction() {
        return custToAccountTransaction;
    }

    public void setCustToAccountTransaction(LinkedList<TransactionsRecord> custToAccountTransaction) {
        this.custToAccountTransaction = custToAccountTransaction;
    }

    /**
     *
     * @throws FileNotFoundException
     *
     * geneating output.csv
     *please change the output file path: /Users/satyammittal/Desktop/output.csv
     *
     */
    public void printResultCSV() throws Exception {
        try {
            PrintWriter writer = new PrintWriter("/Users/satyammittal/Desktop/output.csv");
            for (TransactionsRecord sample : this.getCustToAccountTransaction()) {
                writer.println(sample.toString());
            }
            writer.close();
        }catch (FileNotFoundException e){
            System.out.println("Exception in generating the output.csv file");
            e.printStackTrace();
        }
    }

    /**
     * reading csv from user local system
     *
     * please change current csv path: /Users/satyammittal/Desktop/Intern_AccountTransaction-data.csv
     *
     * Here I am generating a map: Map<String, Map<String, Integer>> where
     *  String :  custid of the user
     *  Map<String, Integer> :  storing : date to amount for the cust id
     *
     *  for example:
     *         Map<String, Map<String, Integer>> csvEnteriesTest = new LinkedHashMap<>();
     *              Map<String, Integer> inputDateAmt = new LinkedHashMap<>();
     *              inputDateAmt.put("11/21/22", 1000);
     *              inputDateAmt.put("11/22/22", -1000);
     *              inputDateAmt.put("11/23/22", 2000);
     *         csvEnteriesTest.put("Cust1", inputDateAmt);
     */
    public void readCSV(){
        String line = "";
        String splitBy = ",";
        try {
            Map<String, Map<String, Integer>> readCsv = new LinkedHashMap<>();
            Map<String, Integer> dateToAmount = new LinkedHashMap<>();
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("/Users/satyammittal/Desktop/Intern_AccountTransaction-data.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] csvEnteries = line.split(splitBy);    // use comma as separator
                String custId = csvEnteries[0];
                dateToAmount = readCsv.getOrDefault(custId, new LinkedHashMap<>());
                dateToAmount.put(csvEnteries[1], Integer.valueOf(csvEnteries[2]));
                readCsv.put(csvEnteries[0], dateToAmount);
            }
            this.setCsvEnteries(readCsv);
        } catch (Exception e) {
            System.out.println("Error in reading input csv");
            e.printStackTrace();
        }
    }

    /**
     * this is the main logic method where transaction for each customer is calculated and updated in output list
     * Then this output list will be used to generate the output csv file
     *
     * LinkedList<TransactionsRecord> resCustToAccountTransaction - output linkedlist, i am using linkedlist so as to maintaint the order of enteries
     *
     * class: TransactionsRecord.class ---
     *              Represents the each user final transaction entery
     */
    public void calculateCustTranscations() throws Exception{
        //final result storing linkedlist
        LinkedList<TransactionsRecord> resCustToAccountTransaction = new LinkedList<>();

        /**
         * looping on the input file csv enteries
         */
        for (Map.Entry<String, Map<String, Integer>> entry : this.getCsvEnteries().entrySet()) {
            StringBuilder prevDateSb = null;
            String custId = entry.getKey();

            int minBal = Integer.MAX_VALUE, maxBal = Integer.MIN_VALUE, endingBal = 0;

            for (Map.Entry<String, Integer> dateToAmt : entry.getValue().entrySet()) {
                StringBuilder dateSb = new StringBuilder();
                String[] date = dateToAmt.getKey().split("/");

                //clacluating month and year
                dateSb.append(date[0] + "/" + date[2]);

                /**
                 * below logic is used when:
                 * same customer is having transaction for 2 or more months then append the previous month transactions to output
                 * and start for new month
                 *
                 * matching the new entery month/year to last entery month/year
                 *      if match different then store the previous entry data and reset everything for a particular custid
                 */
                if (prevDateSb != null && !prevDateSb.toString().equalsIgnoreCase(dateSb.toString())) {
                    //update the credit debit min and set everthing to default
                    TransactionsRecord custObj = new TransactionsRecord(custId, prevDateSb.toString(),
                            minBal, maxBal, endingBal);
                    resCustToAccountTransaction.add(custObj);
                     minBal = Integer.MAX_VALUE;
                     maxBal = Integer.MIN_VALUE;
                     endingBal = 0;

                }
                endingBal += dateToAmt.getValue();
                if (endingBal < minBal)
                    minBal = endingBal;
                if (endingBal > maxBal)
                    maxBal = endingBal;
                prevDateSb = dateSb;
            }
            //add the cust id and details to result
            TransactionsRecord custObj = new TransactionsRecord(entry.getKey().toString(), prevDateSb.toString(),
                    minBal, maxBal, endingBal);
            resCustToAccountTransaction.add(custObj);
            prevDateSb=null;
        }

        this.setCustToAccountTransaction(resCustToAccountTransaction);
    }

    /**
     *
     * @param a
     *
     * Strting point of the application - main method
     */
    public static void main(String[] a) {
        try {
            //creating JustWorkAssignment class object
            JustWorkAssignment classObj = new JustWorkAssignment();

            //read csv method calling
            classObj.readCSV();

            //main business logic method calling

            classObj.calculateCustTranscations();

            //generate output csv method calling
            classObj.printResultCSV();

        }catch(Exception e){
            System.out.println("Error in executing the application, please check the stack trace");
            e.printStackTrace();
        }

    }
}
