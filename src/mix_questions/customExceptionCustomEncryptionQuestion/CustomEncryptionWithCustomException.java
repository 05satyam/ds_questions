package mix_questions.customExceptionCustomEncryptionQuestion;

import java.util.Scanner;

class Validator {
    public static boolean validate(String message) {
        return message.matches("[A-Za-z0-9 ]+");
    }
}
class InvalidMessageException extends Exception {
    String errMsg;
    InvalidMessageException(){ }
    InvalidMessageException(String msg){
        this.errMsg=msg;
    }

    @Override
    public String toString() {
        return "InvalidMessageException: Try again with valid message";
    }
}
class Encryptor {
    public static String encryptMessage(String message) throws InvalidMessageException {
        Validator _v = new Validator();

        if(_v.validate(message)){
            message = message.toLowerCase();
            StringBuilder copyMsg = new StringBuilder(message);
           return copyMsg.reverse().toString();
        }
        throw new InvalidMessageException();

    }
}

public class CustomEncryptionWithCustomException {
    private static final Scanner INPUT_READER = new Scanner(System.in);

    public static void main(String[] args) {
        String message = INPUT_READER.nextLine();

        try {
            String encrypted_message = Encryptor.encryptMessage(message);
            if(! encrypted_message.startsWith("InvalidMessageException"))
                System.out.println(encrypted_message);
        } catch (InvalidMessageException e) {
            System.out.println(e);
        }
    }
}

