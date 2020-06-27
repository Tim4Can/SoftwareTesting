package com.tongji.test.function;


public class Calender {
    public int year;
    public int month;
    public int day;

    public String result;

    public boolean InputIllegal()
    {
        // 日期范围
        if(day > 31 || day < 1) {
            return true;
        }
        // 小月最大值
        else if (day == 31) {
            switch (month) {
                case 2:
                case 4:
                case 6:
                case 9:
                case 11:
                    return true;
            }
        }
        else if (day == 30) {
            switch (month) {
                case 2:
                    return true;
            }
        }
        // 闰年判断
        else if (month == 2 && day == 29)
        {
            int four = year % 4;
            int hundred = year % 100;
            int both = year % 400;
            if (four == 0 && hundred != 0) {
                return false;
            }
            else if (both == 0) {
                return false;
            }
            return true;
        }
        // 月份范围
        else if (month > 12 || month < 1) {
            return true;
        }

        return false;
    }

    public String TheNextDay()
    {
        int result_year = year;
        int result_month = month;
        int result_day = day + 1;
        boolean illegal = InputIllegal();
        // 判断输入是否合法
        if (illegal) {
            result = "输入不合法";
            return result;
        }
        // 根据日来判断日和月
        if (day == 31 && month == 12) {
            result_day = 1;
            result_month = 1;
            result_year =  year + 1;
        }
        else if (day == 30) {
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    result_month = month + 1;
                    result_day = 1;
            }
        }
        else if (month == 2) {
            boolean leapYear = false;
            int four = year % 4;
            int hundred = year % 100;
            int both = year % 400;
            if (four == 0 && hundred != 0) {
                leapYear = true;
            }
            else if (both == 0) {
                leapYear = true;
            }
            if (leapYear && day == 29) {
                result_month = month + 1;
                result_day = 1;
            }
            else if (!leapYear && day == 28) {
                result_month = month + 1;
                result_day = 1;
            }
        }
        // 根据月来判断月和年
        else if (day == 31) {
            result_month += 1;
            result_day = 1;
        }
        result = result_year + "." + result_month + "." + result_day;
        return result;
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
