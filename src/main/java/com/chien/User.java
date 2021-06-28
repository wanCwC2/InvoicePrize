package com.chien;

public class User {
    public static void main(String[] args) {
        System.out.println("-------歡迎來到統一發票兌獎機------- \n" +
                "這裡要先輸入你想查詢的年月份發票兌獎號碼，但有以下幾點必須注意： \n" +
                "(1) 當月份的發票會在下個奇數月的25號才開獎，務必確認好是否已到開獎日期。 \n" +
                "   e.g. 1/1的發票會在3/25才開獎，因此在3/24仍然找不到1月的發票兌獎號碼。 \n" +
                "(2) 查詢方式只要輸入民國年和奇數月即可。 \n" +
                "   e.g. 若想查詢民國110年3月至4月的兌獎號碼，則輸入11003即可，無需補上04。 \n" +
                "(3) 要注意年月有沒有打錯。 \n" +
                "   e.g. 月份不會超過12、年份不會超過今年的年份。 \n" +
                "(4) 根據財政部提供的資料，可追溯到101年5月的兌換號碼。（110.6.28註） \n" +
                "   只不過發票的兌換期限只有半年，查心酸的。 \n" +
                "以上若沒有遵守都會被判定輸入格式錯誤");
        System.out.println();
        Website web = new Website();
        while (!web.verified()){
            System.out.print("Error:格式錯誤!!! ");
        }
        System.out.println();
        System.out.println("-------以下是民國"+web.year+"年"
                +Integer.parseInt(web.month)
                +"月至"+(Integer.parseInt(web.month)+1)
                +"月的中獎號碼-------");
        Prize prize = new Prize();
        prize.content(web.year, web.month);
        Enter enter = new Enter();
        do {
            System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
            while (!enter.vertified(3)){
                System.out.println("輸入格式錯誤");
                System.out.print("輸入你的發票末三碼，若要停止則輸入0：");
            }
            int index = 0;
            while (index < prize.data.size()){
                if (enter.integer == Integer.parseInt(prize.data.get(index))%1000){
                    prize.compare(index);
                    break;
                }
                index++;
            }
            if ((index == prize.data.size()) && (enter.integer != 0)){
                System.out.println("沒中獎");
            }
        }while (enter.integer != 0);
        System.out.println();
        prize.print();
    }
}
