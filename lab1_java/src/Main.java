import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    static Scanner sc;

    public static void main(String[] args) {
        if (args.length != 0) {
            sc = new Scanner(System.in, StandardCharsets.UTF_8);
            String taskNum = args[0];
            switch (taskNum) {
                case "1":
                    task1();
                    break;
                case "2":
                    task2();
                    break;
                case "3":
                    //in windows terminal execute "chcp 65001"
                    task3();
                    break;
                case "4":
                    task4();
                    break;
                case "5":
                    task5();
                    break;
                default:
                    break;
            }
            sc.close();
        } else {
            System.out.println("Wrong number of arguments");
        }
    }

    public static void task1() {
        System.out.println("Enter the n");
        int n = sc.nextInt();
        int cnt = 0;
        while (n != 1) {
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            ++cnt;
        }
        System.out.println(cnt);
    }

    public static void task2() {
        System.out.println("Enter the n");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the number");
            int number = sc.nextInt();
            sum += (int) (Math.pow(-1, i) * number);
        }
        System.out.println(sum);
    }

    public static void task3() {
        System.out.println("Enter the treasure coords");
        int x = sc.nextInt();
        int y = sc.nextInt();
        String direction = sc.next();
        int selfX = 0;
        int selfY = 0;
        int cnt = 0;
        while (!direction.equals("стоп")) {
            int steps = sc.nextInt();
            if (!(selfX == x && selfY == y)) {
                cnt++;
                switch (direction) {
                    case "север":
                        selfY += steps;
                        break;
                    case "юг":
                        selfY -= steps;
                        break;
                    case "запад":
                        selfX -= steps;
                        break;
                    case "восток":
                        selfX += steps;
                        break;
                }
            }
            direction = sc.next();
        }
        System.out.println(cnt);
    }

    public static void task4() {
        System.out.println("Enter the number of roads");
        int n = sc.nextInt();
        int maxHeight = 0;
        int road = 1;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            double minHeight = 0;
            if (k > 0) {
                minHeight = Double.POSITIVE_INFINITY;
                for (int j = 0; j < k; j++) {
                    int curHeight = sc.nextInt();
                    if (curHeight < minHeight) {
                        minHeight = curHeight;
                    }
                }
            }
            if (maxHeight < minHeight) {
                maxHeight = (int) minHeight;
                road = i + 1;
            }
        }
        System.out.printf("%d %d", road, maxHeight);
    }

    public static void task5() {
        System.out.println("Enter the n");
        int n = sc.nextInt();
        int sum = 0;
        int mult = 1;
        while (n > 0) {
            int x = n % 10;
            sum += x;
            mult *= x;
            n = n / 10;
        }
        System.out.println((sum % 2 == 0 && mult % 2 == 0) ? "Yes" : "No");
    }
}