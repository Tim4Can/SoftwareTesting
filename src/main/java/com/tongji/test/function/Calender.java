package com.tongji.test.function;


public class Calender {
    public int year;
    public int month;
    public int day;

    public static String result;

    public static String TheNextDay(int year,int month,int day) {
        boolean flag = false;
        if (year < 1900 || year > 2050) {
            return ("年的值不在指定范围之内");
        } else if (month > 12 || month < 1) {
            return ("月的值不在指定范围之内");
        } else if (day > 31 || day < 1) {
            return ("日的值不在指定范围之内");
        }

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (day == 31) {
                    day = 1;
                    month = month + 1;
                } else {
                    day = day + 1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 30) {
                    day = 1;
                    month = month + 1;
                } else if (day == 31) {
                    flag = true;
                } else {
                    day = day + 1;
                }
                break;
            case 12:
                if (day == 31) {
                    day = 1;
                    month = 1;
                    year = year + 1;
                } else {
                    day = day + 1;
                }
                break;
            case 2:
                if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                    if (day == 29) {
                        day = 1;
                        month = 3;
                    } else if (day < 29) {
                        day = day + 1;
                    } else {
                        flag = true;
                    }
                }
                break;
            default:
        }
        if (year > 2050) {
            return ("年的值不在指定范围之内");
        } else if (flag) {
            return ("日的值不在指定范围之内");
        }else {
            return (year + "." + month + "." + day);
        }
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("CalenderBoundary.csv"));
//
//            reader.readLine();
//
//            String line = null;
//            while((line = reader.readLine())!=null) {
//                String item[] = line.split(",");
//                String year = item[1];
//                String month = item[2];
//                String day = item[3];
//                Calender test = new Calender();
//                test.year = Integer.parseInt(year);
//                test.month = Integer.parseInt(month);
//                test.day = Integer.parseInt(day);
//                String result = test.TheNextDay();
//                System.out.println("预期输出日期：" + item[4] + "\t\t实际输出日期：" + result);
//            }
//
//        }
//        catch (Exception e) {
//
//        }
//    }
}
