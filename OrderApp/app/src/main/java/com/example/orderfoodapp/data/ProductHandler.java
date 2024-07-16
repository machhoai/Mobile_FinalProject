package com.example.orderfoodapp.data;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "product_manager.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "product_manager";
    private static final String ID = "id";
    private static final String IMAGE = "imageProduct";
    private static final String PRODUCT = "product";
    private static final String PRICE = "price";
    private static final String SALE = "sale";
    private static final String TRENDING = "trending";
    private static final String INGREDIENT = "ingredient";
    private static final String CLASSIFY = "classify";

    public ProductHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + IMAGE + " TEXT,"
                + PRODUCT + " TEXT,"
                + PRICE + " INTEGER,"
                + SALE + " REAL,"
                + TRENDING + " INTEGER," // Use INTEGER for boolean representation (0 or 1)
                + INGREDIENT + " TEXT,"
                + CLASSIFY + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void initData() {
        SQLiteDatabase db = this.getWritableDatabase(); // Get writable database
        String sql = "INSERT OR IGNORE INTO " + TABLE_NAME + " ("
                + IMAGE + ", " + PRODUCT + ", " + PRICE + ", " + SALE + ", "
                + TRENDING + ", " + INGREDIENT + ", " + CLASSIFY + ") VALUES ("
                + "('burgerbo', 'Burger bò', 75000, 0.1, 0, 'bo, banhmi, rau, sot', 'MonChinh'), "
                + "('burgerga', 'Burger gà', 70000, 0.1, 0, 'ga, banhmi, rau, sot', 'MonChinh'), "
                + "('burgerchay', 'Burger chay', 60000, 0.1, 0, 'rau, banhmi, sot', 'MonChinh'), "
                + "('my', 'Mỳ Ý Spaghetti', 80000, 0.1, 0, 'my, thit bo, sot', 'MonChinh'), "
                + "('pizza', 'Pizza', 120000, 0.1, 0, 'bot mi, pho mai, sot ca chua, cac loai nhan', 'MonChinh'), "
                + "('tacos', 'Tacos', 70000, 0.1, 0, 'vo banh mi, thit bo, rau, sot', 'MonChinh'), "
                + "('nachos', 'Nachos', 65000, 0.1, 0, 'banh nacho, pho mai, sot', 'MonChinh'), "
                + "('hotdog', 'Hot Dog', 50000, 0.1, 0, 'banh mi dai, xuc xich, sot', 'MonChinh'), "
                + "('friedchicken', 'Gà rán', 75000, 0.1, 0, 'ga, bot mi, dau an, gia vi', 'MonChinh'), "
                + "('club_sandwich', 'Club Sandwich', 65000, 0.1, 0, 'banh mi, thit ga, bacon, rau, sot', 'MonChinh'), "
                + "('macandcheese', 'Mac and Cheese', 70000, 0.1, 0, 'nui, pho mai, sua, bot mi', 'MonChinh'), "
                + "('lasagna', 'Lasagna', 95000, 0.1, 0, 'bot mi, thit bo, pho mai, sot ca chua', 'MonChinh'), "
                + "('kem_vani', 'Kem vani', 25000, 0.1, 0, 'sua, duong, vanilla', 'TrangMieng'), "
                + "('kem_socola', 'Kem socola', 27000, 0.1, 0, 'sua, duong, socola', 'TrangMieng'), "
                + "('kem_dau', 'Kem dâu', 26000, 0.1, 0, 'sua, duong, dau', 'TrangMieng'), "
                + "('che_dau_xanh', 'Chè đậu xanh', 20000, 0.1, 0, 'dau xanh, duong, nuoc cot dua', 'TrangMieng'), "
                + "('che_thap_cam', 'Chè thập cẩm', 22000, 0.1, 0, 'dau, tra, sua', 'TrangMieng'), "
                + "('che_dau_do', 'Chè đậu đỏ', 20000, 0.1, 0, 'dau do, duong, nuoc cot dua', 'TrangMieng'), "
                + "('banh_flan', 'Bánh flan', 30000, 0.1, 0, 'trung, sua, duong, caramel', 'TrangMieng'), "
                + "('banh_pudding', 'Bánh pudding', 32000, 0.1, 0, 'sua, duong, gelatin', 'TrangMieng'), "
                + "('trai_cay_tuoi', 'Trái cây tươi', 20000, 0.1, 0, 'trai cay', 'TrangMieng'), "
                + "('trai_cay_dam', 'Trái cây dầm', 22000, 0.1, 0, 'trai cay, sua dac', 'TrangMieng'),"
                + "'americano', 'Americano', 39000, 0.1, 0, 'coffee, đường, nước', 'Món uống'), "
                + "('cappuchino', 'Cappochino', 49000, 0.1, 0, 'coffee, đường, nước', 'Món uống'), "
                + "('matchalattenong', 'Matcha Latte Nóng', 60000, 0.1, 0, 'coffee, đường, nước, matcha', 'Món uống'), "
                + "('socolanong', 'Socola nóng', 60000, 0.1, 0, 'socola, đường, nước', 'Món uống'), "
                + "('lattenong', 'Latte Nóng', 60000, 0.1, 0, 'coffee, đường, nước', 'Món uống'), "
                + "('cafemocha', 'Cà phê Mocha', 59000, 0.1, 0, 'coffee,mocha , đường, nước', 'Món uống'), "
                + "('cafedennong', 'Cafe đen nóng', 35000, 0.1, 0, 'coffee, đường, nước', 'Món uống'), "
                + "('cafenaunong', 'Cafe nâu nóng', 60000, 0.1, 0, 'coffee, đường, nước', 'Món uống'), "
                + "('caphesuada', 'Cà phê sữa đá', 35000, 0.1, 0, 'coffee,sữa , đường, nước', 'Món uống'), "
                + "('capheamericanoda', 'Cà phê Americano đá', 45000, 0.1, 0, 'coffee, đường, nước', 'Món uống'), "
                + "('caphelatteda', 'Cà phê Latte đá', 55000, 0.1, 0, 'coffee, đường, nước', 'Món uống'), "
                + "('caphedenda', 'Cà phê đen đá', 35000, 0.1, 0, 'coffee, đường, nước', 'Món uống'), "
                + "('trakemsua', 'Trà kem sữa', 49000, 0.1, 0, 'kem ,sữa , đường, nước', 'Món uống'), "
                + "('tradao', 'Trà đào', 49000, 0.1, 0, 'trà ,đào , đường, nước', 'Món uống'), "
                + "('travai', 'Trà vải', 60000, 0.1, 0, 'trà ,vải , đường, nước', 'Món uống'), "
                + "('tacmuoimo', 'Tắc muối mơ ngâm hạt chia', 39000, 0.1, 0, 'tắc,mơ , đường, nước', 'Món uống'), "
                + "('matchalatteda', 'Matcha Latte Đá', 69000, 0.1, 0, 'matcha,chanh , đường, nước', 'Món uống'), "
                + "('suachuadau', 'Sữa chua dâu', 59000, 0.1, 0, 'coffee, đường, nước', 'Món uống'), "
                + "('suachuakiwi', 'Sữa chưa Kiwi', 59000, 0.1, 0, 'sữa chua, đường, nước', 'Món uống'), "
                + "('matchalattenong', 'Matcha Latte Nóng', 60000, 0.1, 0, 'matcha, đường, nước', 'Món uống'), "
                + "('traxanhdaxay', 'Trà xanh đá xay', 79000, 0.1, 0, 'trà xanh, đường, nước', 'Món uống'), "
                + "('caramendaxay', 'Caramen đá xay', 69000, 0.1, 0, 'caramen, đường, nước', 'Món uống'), "
                + "('mochadaxay', 'Mocha đá xay', 69000, 0.1, 0, 'matcha, đường, nước', 'Món uống'), "
                + "('lattedaxay', 'Latte đá xay', 69000, 0.1, 0, 'đường, nước', 'Món uống'), "
                + "('tiramisu', 'Bánh Tiramisu', 55000, 0.1, 0, 'bột, đường, mật ong', 'Món phụ'), "
                + "('banhkhoaitay', 'Bánh khoai tây', 22000, 0.1, 0, 'bột, đường, khoai tây', 'Món phụ'), "
                + "('banhphomainuong', 'Bánh Phô mai nướng', 35000, 0.1, 0, 'bột, đường, phô mai', 'Món phụ'), "
                + "('banhnuongvichuoi', 'Bánh nướng vị chuối', 30000, 0.1, 0, 'bột, đường, chuối', 'Món phụ'), "
                + "('banhbrowniesocola', 'Bánh Brownie Sô-cô-la', 30000, 0.1, 0, 'bột,socola , đường, nước', 'Món phụ'), "
                + "('banhmaracondua', 'Bánh Maracon dừa', 15000, 0.1, 0, 'bột,dừa, đường', 'Món phụ'), "
                + "('banhquysocola', 'Bánh Quy Socola', 25000, 0.1, 0, 'bột,socola, đường', 'Món phụ'), "
                + "('banhsungtrau', 'Bánh Sừng Trâu', 30000, 0.1, 0, 'bột, đường', 'Món phụ')";
        try {
            db.execSQL(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ tại đây nếu cần thiết
        } finally {
            db.close();
        }
    }

}
