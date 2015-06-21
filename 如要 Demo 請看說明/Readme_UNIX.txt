本程式希望設計上更加方便與彈性，所以該資料庫在程式首次打開後，並不會創造所有的資料表，所以當程式讀不到資料庫 (JuiceDB) ，便會出現強致退出的情形。

所以我們提供兩個方案，如果助教或老師需要 Demo 者，造成不便敬請見諒。
兩個方案前提需求：該 Android 裝置必須 Rooted

(1)
用能夠提升權限為 Root 的檔案管理員 (Ex. Root Explorer)
將資料庫檔案 (JuiceDB) 放入 /data/data/com.fju.student.fruit.juice/databases/ 目錄下

(2)
使用壓縮檔所附的鈦備份資料檔，能夠完整還原資料庫系統正常運作，含資料表到任一裝置。
請先下載 Titanium Backup (https://play.google.com/store/apps/details?id=com.keramidas.TitaniumBackup&hl=zh_TW)

執行後將所附的還原檔案 (Restore Files) ，放入內置空間 (Internal) 下的 TitaniumBackup 目錄下中，該目錄通常鈦備份首次執行便會自動建立
com.fju.student.fruit.juice-20140117-145626.properties
com.fju.student.fruit.juice-20140117-145626.tar.gz
com.fju.student.fruit.juice-b24cdd46d401f25c4180e0b55bcc8ae4.apk.gz
接著請按照圖示說明進行




新年快樂，祝事事順心