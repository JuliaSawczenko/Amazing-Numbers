package numbers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main extends Calculations {
    public static void print_instructions(){
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }
    public static void start_program() throws InvocationTargetException, IllegalAccessException {
        System.out.println("Welcome to Amazing Numbers!\n");
        print_instructions();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> num = new ArrayList<>();
        num.add(-1L);
        String[] input;
        while (num.get(0) != 0) {
            System.out.println("\nEnter a request:");
            input = scanner.nextLine().split(" ");
            if (input.length == 0) {
                print_instructions();
                continue;
            }
            num.clear();
            try {
                if (input.length == 1) {
                    num.add(Long.parseLong(input[0]));
                } else {
                    num.add(Long.parseLong(input[0]));
                    num.add(Long.parseLong(input[1]));
                }

                if ((num.get(0) < 1) && (num.get(0) != 0)) {
                    System.out.println("The first parameter should be a natural number or zero.");
                } else if ((num.size() == 2) && (num.get(1)) < 1) {
                    System.out.println("The second parameter should be a natural number.\n");
                } else if ((num.size() == 1) && (num.get(0) != 0)) {
                    System.out.println("Properties of " + num.get(0) + "\n even: " + even(num.get(0)) + "\n odd: " + odd(num.get(0)) + "\n buzz: " + buzz(num.get(0)) + "\n duck: " + duck(num.get(0)) + "\n palindromic: " + palindromic(num.get(0)) + "\n gapful: " + gapful(num.get(0)) + "\n spy: " + spy(num.get(0)) + "\n square: " + square(num.get(0)) + "\n sunny: " + sunny(num.get(0)) + "\n jumping: " + jumping(num.get(0)) + "\n happy: " + happy(num.get(0)) + "\n sad: " + sad(num.get(0)));
                } else if ((num.size() == 2) && (input.length == 2) && (num.get(0) != 0)) {
                    for (long i = 0; i < num.get(1); i++) {
                        System.out.print("\n" + (num.get(0) + i) + " is ");
                        if (even(num.get(0) + i)) {
                            System.out.print("even ");
                        }
                        if (odd(num.get(0) + i)) {
                            System.out.print("odd ");
                        }
                        if (buzz(num.get(0) + i)) {
                            System.out.print("buzz ");
                        }
                        if (duck(num.get(0) + i)) {
                            System.out.print("duck ");
                        }
                        if (palindromic(num.get(0) + i)) {
                            System.out.print("palindromic ");
                        }
                        if (gapful(num.get(0) + i)) {
                            System.out.print("gapful ");
                        }
                        if (spy(num.get(0) + i)) {
                            System.out.print("spy ");
                        }
                        if (square(num.get(0) + i)) {
                        System.out.print("square ");
                        }
                        if (sunny(num.get(0) + i)) {
                        System.out.print("sunny ");
                        }
                        if (jumping(num.get(0) + i)) {
                            System.out.print("jumping ");
                        }
                        if (happy(num.get(0) + i)) {
                            System.out.print("happy ");
                        }
                        if (sad(num.get(0) + i)) {
                            System.out.print("sad");
                        }
                    }
                } else if (((num.size() == 2) && (input.length >= 3))) {
                    find(input, num);
                }
            } catch (NumberFormatException e) {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        }
        System.out.println("Goodbye!");
    }

    public static void find(String[] input, ArrayList<Long> num) throws InvocationTargetException, IllegalAccessException {
        ArrayList<String> properties = new ArrayList<>(Arrays.asList("even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "square", "sunny", "jumping", "happy", "sad"));
        ArrayList<String> excludedProperties = new ArrayList<>(Arrays.asList("-even", "-odd", "-buzz", "-duck", "-palindromic", "-gapful", "-spy", "-square", "-sunny", "-jumping", "-happy", "-sad"));
        ArrayList<String> wrongInput = new ArrayList<>();
        ArrayList<String> inputList = new ArrayList<>();
        Calculations calculations = new Calculations();
        Method[] methods = Calculations.class.getDeclaredMethods();
        ArrayList<String> checked = new ArrayList<>();
        Long how_many = 0L;
        int count = 0;
        for (int i = 2; i < input.length; i++) {
            if (((!properties.contains(input[i].toLowerCase()))) && (!excludedProperties.contains(input[i].toLowerCase()))){
                wrongInput.add(input[i]);
            }
            inputList.add(input[i].toLowerCase());
        }

        boolean PropertiesMatch = false;
        for (int i = 0; i < properties.size(); i++) {
            if ((inputList.contains(properties.get(i)) && inputList.contains(excludedProperties.get(i)))) {
                PropertiesMatch = true;
                break;
            }
        }
        if (wrongInput.size() == 1){
                System.out.println("The property " + wrongInput.get(0) + " is wrong.\n" +
                        "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n");
        } else if (wrongInput.size() > 1){
            System.out.println("The properties " + wrongInput + " are wrong.\n" +
                    "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n");
        } else if (((inputList.contains("even")) && (inputList.contains("odd"))) || ((inputList.contains("spy")) && (inputList.contains("duck"))) || ((inputList.contains("sunny")) && (inputList.contains("square"))) || ((inputList.contains("happy")) && (inputList.contains("sad"))) || ((inputList.contains("-even")) && (inputList.contains("-odd"))) || ((inputList.contains("-spy")) && (inputList.contains("-duck"))) || ((inputList.contains("-sunny")) && (inputList.contains("-square"))) || ((inputList.contains("-happy")) && (inputList.contains("-sad"))) || (PropertiesMatch)){
                    System.out.println("The request contains mutually exclusive properties: " + inputList + "\n" +
                    "There are no numbers with these properties.");
        } else if ((num.size() == 2) && (input.length == 3)) {
            for (Method method : methods) {
                if (input[2].toLowerCase().equals(method.getName())) {
                    for (long j = num.get(0); ; j++) {
                        Object result = method.invoke(calculations, num.get(0) + count);
                        boolean booleanResult = ((Boolean) result).booleanValue();
                        if (booleanResult) {
                            System.out.print("\n" + (num.get(0) + count) + " is " + method.getName());
                            how_many++;
                            for (Method method2 : methods) {
                                if (method2.getName().equals(method.getName())) {
                                    continue;
                                } else {
                                    Object result2 = method2.invoke(calculations, num.get(0) + count);
                                    boolean booleanResult2 = ((Boolean) result2).booleanValue();
                                    if (booleanResult2) {
                                        System.out.print(", " + method2.getName());
                                    }
                                }
                            }
                        }
                        count++;
                        if (how_many == num.get(1)) {
                            break;
                        }
                    }
                } else if (input[2].toLowerCase().equals("-".concat(method.getName()))){
                    for (long j = num.get(0); ; j++) {
                        Object result = method.invoke(calculations, num.get(0) + count);
                        boolean booleanResult = ((Boolean) result).booleanValue();
                        if (!booleanResult) {
                            System.out.print("\n" + (num.get(0) + count) + " is ");
                            how_many++;
                            for (Method method2 : methods) {
                                if (method2.getName().equals(method.getName())) {
                                    continue;
                                } else {
                                    Object result2 = method2.invoke(calculations, num.get(0) + count);
                                    boolean booleanResult2 = ((Boolean) result2).booleanValue();
                                    if (booleanResult2) {
                                        System.out.print(" " + method2.getName());
                                    }
                                }
                            }
                        }
                        count++;
                        if (how_many == num.get(1)) {
                            break;
                        }
                    }
                    }
                }
            } else if (Collections.disjoint(inputList,properties)){
            for (long k = num.get(0); ; k++) {
                innerloop:
                for (int j = 0; j < methods.length; j++) {
                    for (int i = 2; i < input.length; i++) {
                        if (input[i].toLowerCase().equals("-".concat(methods[j].getName()))) {
                            Object result = methods[j].invoke(calculations, num.get(0) + count);
                            boolean booleanResult = ((Boolean) result).booleanValue();
                            if (!booleanResult) {
                                if (!checked.contains(methods[j].getName())) {
                                    checked.add(" is ");
                                }
                            } else if (booleanResult) {
                                checked.clear();
                                break innerloop;
                            }
                        }
                    }
                }
                if (checked.size() != 0) {
                    System.out.print("\n" + (num.get(0) + count));
                    System.out.print(checked.get(0));
                    for (Method method : methods) {
                            Object result2 = method.invoke(calculations, num.get(0) + count);
                            boolean booleanResult2 = ((Boolean) result2).booleanValue();
                            if (booleanResult2) {
                                System.out.print(" " + method.getName());
                            }
                        }
                    how_many++;
                }
                count++;
                if (how_many == num.get(1)) {
                    break;
                }
            }
         } else {
            outerloop:
                for (long k = num.get(0); ; k++) {
                    innerloop:
                    for (int j = 0; j < methods.length; j++) {
                        for (int i = 2; i < input.length; i++) {
                            if (input[i].toLowerCase().equals(methods[j].getName())) {
                                Object result = methods[j].invoke(calculations, num.get(0) + count);
                                boolean booleanResult = ((Boolean) result).booleanValue();
                                if (booleanResult) {
                                    if (!checked.contains(methods[j].getName())) {
                                        checked.add(methods[j].getName());
                                    }
                                } else if (!booleanResult) {
                                    checked.clear();
                                    break innerloop;
                                }
                            } else if (input[i].toLowerCase().equals("-".concat(methods[j].getName()))){
                                Object result = methods[j].invoke(calculations, num.get(0) + count);
                                boolean booleanResult = ((Boolean) result).booleanValue();
                                if (booleanResult) {
                                    checked.clear();
                                    break innerloop;
                                }
                            }
                        }
                    }
                    if (checked.size() != 0) {
                        System.out.print("\n" + (num.get(0) + count) + " is ");
                        for (int i = 0; i < checked.size(); i++) {
                            System.out.print(checked.get(i) + " ");
                        }
                        for (Method method : methods) {
                            if (checked.contains(method.getName())) {
                                continue;
                            } else {
                                Object result2 = method.invoke(calculations, num.get(0) + count);
                                boolean booleanResult2 = ((Boolean) result2).booleanValue();
                                if (booleanResult2) {
                                    System.out.print(" " + method.getName());
                                }
                            }
                        }
                        how_many++;
                    }
                    count++;
                    if (how_many == num.get(1)) {
                        break;
                    }
                }
        }
    }

        public static void main (String[]args) throws InvocationTargetException, IllegalAccessException {
            start_program();

        }
    }

