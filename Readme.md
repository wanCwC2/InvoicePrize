# 程式設計(二) 期末專題
## 鍾葦蒨 408570344

## 專題用途
統一發票兌獎機

## 使用方式
1. 執行 `User class`<br>
   >該檔案位置在 com.chien
2. 輸入要查詢年月的發票兌換號碼
   >有以下幾點必須注意：<br>
   >1. 當月份的發票會在下個奇數月的25號才開獎，務必確認好是否已到開獎日期。 e.g. 1/1的發票會在3/25才開獎，因此在3/24仍然找不到1月的發票兌獎號碼。<br>
   >2. 查詢方式只要輸入民國年和奇數月即可。 e.g. 若想查詢民國110年3月至4月的兌獎號碼，則輸入11003即可，無需補上04。<br>
   >3. 要注意年月有沒有打錯。 e.g. 月份不會超過12、年份不會超過今年的年份。<br>
   >4. 根據財政部提供的資料，可追溯到101年5月的兌換號碼。（110.6.28註）只不過發票的兌換期限只有半年，查心酸的。<br><br>
   >以上若沒有遵守都會被判定輸入格式錯誤
3. 輸入發票的末三碼，輸入完畢後目前僅能自己按enter。<br>
4. 如果與兌換號碼有同樣的末三碼，則會要你輸入發票全部的8個號碼。<br>
5. 若有中獎則會跳通知，若沒有則會要你繼續輸入末三碼。<br>
6. 若已經把手上的發票都輸入完畢，則輸入0即可離開。<br>
7. 最後會顯示你的發票中獎號碼、個別獎項和金額，以及可以兌換的總金額。
## 重點功能
- [x] 抓取網路上的不同年月份發票中獎兌換號碼：`CatchData class`
- [x] 獎項有用到繼承：`Prize class` 以及 `All class in prize package`
- [x] 整理code(?
- [ ] 努力製作使用者打了末三碼之後，就能直接enter的程式
## 主要物件介紹
* `User class`：執行發票兌獎機。
* `Website class`：當使用者輸入要查詢的年月份發票兌獎資料時，會透過這個物件判斷使用者輸入有沒有錯誤。
* `Prize class`：這物件會儲存該年月份的發票兌獎資料，以及使用者中獎的發票資料，包含使用者發票、獎項、獎金等等，此外當使用者結束時，會列印他的中獎資料。
* `CatchData class`：抓取使用者所要查詢的年月份發票兌換資料。
* `Enter class`：在比對發票的時候，確認使用者輸入的格式有沒有錯誤。
* `CompareData class`：比對使用者的發票以及該年月份的發票兌獎資料是否一致，一致的話表示有中獎。