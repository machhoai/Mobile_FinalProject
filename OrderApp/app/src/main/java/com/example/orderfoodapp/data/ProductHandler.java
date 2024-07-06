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
                + "'americano', 'Americano', 39000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('cappuchino', 'Cappochino', 49000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('matchalattenong', 'Matcha Latte Nóng', 60000, 0.1, 0, 'caphe, duong, nuoc, matcha', 'Nuoc'), "
                + "('socolanong', 'Socola nóng', 60000, 0.1, 0, 'socola, duong, nuoc', 'Nuoc'), "
                + "('lattenong', 'Latte Nóng', 60000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('cafemocha', 'Cà phê Mocha', 59000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('cafedennong', 'Cafe đen nóng', 35000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('cafenaunong', 'Cafe nâu nóng', 60000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('caphesuada', 'Cà phê sữa đá', 35000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('capheamericanoda', 'Cà phê Americano đá', 45000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('caphelatteda', 'Cà phê Latte đá', 55000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('caphedenda', 'Cà phê đen đá', 35000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('trakemsua', 'Trà kem sữa', 49000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('tradao', 'Trà đào', 49000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('travai', 'Trà vải', 60000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('tacmuoimo', 'Tắc muối mơ ngâm hạt chia', 39000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('matchalatteda', 'Matcha Latte Đá', 69000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('suachuadau', 'Sữa chua dâu', 59000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('suachuakiwi', 'Sữa chưa Kiwi', 59000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('matchalattenong', 'Matcha Latte Nóng', 60000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('traxanhdaxay', 'Trà xanh đá xay', 79000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('caramendaxay', 'Caramen đá xay', 69000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('mochadaxay', 'Mocha đá xay', 69000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('lattedaxay', 'Latte đá xay', 69000, 0.1, 0, 'caphe, duong, nuoc', 'Nuoc'), "
                + "('tiramisu', 'Bánh Tiramisu', 55000, 0.1, 0, 'caphe, duong, nuoc', 'Annhe'), "
                + "('banhkhoaitay', 'Bánh khoai tây', 22000, 0.1, 0, 'caphe, duong, nuoc', 'Annhe'), "
                + "('banhphomainuong', 'Bánh Phô mai nướng', 35000, 0.1, 0, 'caphe, duong, nuoc', 'Annhe'), "
                + "('banhnuongvichuoi', 'Bánh nướng vị chuối', 30000, 0.1, 0, 'caphe, duong, nuoc', 'Annhe'), "
                + "('banhbrowniesocola', 'Bánh Brownie Sô-cô-la', 30000, 0.1, 0, 'caphe, duong, nuoc', 'Annhe'), "
                + "('banhmaracondua', 'Bánh Maracon dừa', 15000, 0.1, 0, 'caphe, duong, nuoc', 'Annhe'), "
                + "('banhquysocola', 'Bánh Quy Socola', 25000, 0.1, 0, 'caphe, duong, nuoc', 'Annhe'), "
                + "('banhsungtrau', 'Bánh Sừng Trâu', 30000, 0.1, 0, 'caphe, duong, nuoc', 'Annhe')";
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
