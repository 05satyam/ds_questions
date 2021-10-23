//given address string...validate it with some condition
// for sms: can start with +, should not start with 0 if + present than 1st character shuld not be 0 and if + absent than 0th charzcter cant not be 0 , len shuld be less than 15 excluding +
/* for other carrier patter of input => <provider>:<address>
*  other carrier whatsaapp, messenger, wechat
*
* for whatsapp and messender sms condition shuld be followed for address
*
* for wechat there can be any character present but address len shuld be less than 248
*
* there will be these carrier only
*
* return provider in capital like SMS, WECHAT, WHATSAPP, MESSENGER
* */

package mix_questions;

import java.util.HashSet;
import java.util.Set;

public class TwillioMachineTestValidatePhoneNumberFormatQues2 {

    public static boolean validateLen(String address){
        return address.length()<=16;
    }
    public static boolean startsWithZero(char c){
        System.out.println("c "+ c + "   "+   (c=='0'));
        return (c=='0');
    }





    public static boolean isProvider(String provider){
        Set<String> providerSet = new HashSet<String>();
        providerSet.add("whatsapp");
        providerSet.add("wechat");
        providerSet.add("messenger");

        provider = provider.toLowerCase();

        return providerSet.contains(provider);

    }
    public static String validatePhoneNumberFormat(String address) {
        //System.out.print(address);


        char c0 = address.charAt(0);
        if(c0=='+'){
           return isE14(address)? "SMS": "INVALID_ADDRESS";
        }else{
            String[] addressArr = address.split(":");
            String[] addSpace = address.split(" ");
            if(addSpace.length>1)
                return "INVALID_ADDRESS";

            if(addressArr.length==1){
                return isE14(address)? "SMS": "INVALID_ADDRESS";
            }else if(addressArr.length>2)
                return "INVALID_ADDRESS";

            if(!isProvider(addressArr[0].toLowerCase()))
                return "INVALID_ADDRESS";
            else if(addressArr[0].toLowerCase().equalsIgnoreCase("whatsapp") || addressArr[0].toLowerCase().equalsIgnoreCase("messenger")){
                return isE14(addressArr[1])? addressArr[0].toUpperCase(): "INVALID_ADDRESS";
            }else if(addressArr[0].toLowerCase().equalsIgnoreCase("wechat")){
                return addressArr[1].length()<=248?"WECHAT":"INVALID_ADDRESS";
            }
        }
        return "INVALID_ADDRESS";
    }

    public static boolean isE14(String address){
        char c0 = address.charAt(0);
        if(c0=='+'){
           return isE14Helper(address);
        }else{

        }
        String[] addressArr = address.split(":");

        //System.out.print("addressArr len "+ addressArr.length + "   "+ address);
        if(addressArr.length==1){
            address = "+" +address;
            return isE14Helper(address);
        }else{
            return isE14Helper(address);
        }
    }

    public static boolean isE14Helper(String address){
        boolean isStartingWithZero = startsWithZero(address.charAt(1));
        System.out.print(isStartingWithZero);
        if(isStartingWithZero || !validateLen(address)) {
            //System.out.print("isE14Helper");
            return false;
        }
        else{
            Set<Integer> numbers = new HashSet<>();
            numbers.add(1);
            numbers.add(2);numbers.add(3);numbers.add(4);numbers.add(5);numbers.add(6);numbers.add(7);numbers.add(8);numbers.add(9);numbers.add(0);

            for(int i=1;i<address.length();i++){
                if(!Character.isDigit(address.charAt(i)))
                    return false;
            }

        }
            return true;
    }
    public static void main(String[] a){
        System.out.println(validatePhoneNumberFormat("wechat:gh a1f37dacefe3"));
    }
}
