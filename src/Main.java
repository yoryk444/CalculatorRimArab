import java.util.*;

public class Main {
    private static String number1;
    private static String number2;
    private static ArithmeticOperations operation;
    private HashMap<String, String> romanLetters = new HashMap();

    {
        romanLetters.put("I", "1");
        romanLetters.put("V", "5");
        romanLetters.put("X", "10");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try {
            System.out.println(calc(str));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String calc(String str) throws Exception {
        parseStr(str);
        return calculation(number1, number2, operation);
    }

    private static void parseStr(String str) throws Exception {
        String[] arrStr = str.split("[+\\-\\*\\/]");
        if (arrStr.length != 2) {
            throw new Exception(); //TODO
        }

        number1 = arrStr[0].replaceAll(" ", "");
        characterCheck(number1);
        number2 = arrStr[1].replaceAll(" ", "");
        characterCheck(number2);

        for (ArithmeticOperations ao : ArithmeticOperations.values()) {
            if (str.contains(ao.getMeaning())) {
                operation = ao;
                break;
            }
        }
    }

    private static void characterCheck(String str) throws Exception {
        Set<Character> suitableCharacters = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'I', 'V', 'X'));
        for (Character c : str.toCharArray()) {
            if (!suitableCharacters.contains(c)) {
                throw new Exception();//TODO
            }
        }
    }

    private static String calculation(String number1, String number2, ArithmeticOperations operation) throws Exception {
        int res;
        switch (operation) {
            case ADD:
                res = Integer.parseInt(number1) + Integer.parseInt(number2);
                return Integer.toString(res);
            case MINUS:
                res = Integer.parseInt(number1) - Integer.parseInt(number2);
                return Integer.toString(res);
            case MULTIPLY:
                res = Integer.parseInt(number1) * Integer.parseInt(number2);
                return Integer.toString(res);
            case DIVIDE:
                if (number2.equals("0")) {
                    throw new Exception(); //TODO
                }
                res = Integer.parseInt(number1) / Integer.parseInt(number2);
                return Integer.toString(res);
        }
        return null;
    }
}