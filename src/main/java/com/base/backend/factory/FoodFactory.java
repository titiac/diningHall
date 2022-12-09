package com.base.backend.factory;

import com.base.backend.pojo.Dish;
import com.base.backend.pojo.vo.AddDishVo;
import com.base.backend.pojo.vo.dish.*;

/**
 * @program: diningHall
 * @description: 事物工厂类
 * @author: zhw
 * @created: 2022/12/09 16:29
 */
public class FoodFactory {
    public static Dish addDish(AddDishVo addDishVo){
        Integer type = addDishVo.getType();
        String ingredient = addDishVo.getIngredient();
        String name = addDishVo.getName();
        Double price = addDishVo.getPrice();
        
        Dish dish = null;
        
        if(type == 1) {
            String photo = "https://cdn.acwing.com/media/article/image/2022/12/09/87795_80b8d18077-%E9%9D%92%E6%A4%92%E8%82%89%E4%B8%9D.jpg";
            dish = new Pork(null, 1, ingredient, name, photo, price);    
        } else if (type == 2) {
            String photo = "https://cdn.acwing.com/media/article/image/2022/12/09/87795_7601e11877-%E9%BB%91%E6%A4%92%E7%89%9B%E8%82%89%E7%B2%92.jpg";
            dish = new Beef(null, 2, ingredient, name, photo, price);
        } else if (type == 3) {
            String photo = "https://cdn.acwing.com/media/article/image/2022/12/09/87795_863b1e5a77-%E5%AD%9C%E7%84%B6%E7%BE%8A%E8%82%89.jpg";
            dish = new Mutton(null, 3, ingredient, name, photo, price);
        } else if (type == 4) {
            String photo = "https://cdn.acwing.com/media/article/image/2022/12/09/87795_ae1e462f77-%E9%B1%BC%E7%B1%BB%E5%9B%BE%E7%89%87.jpg";
            dish = new AquaticProduct(null, 4, ingredient, name, photo, price);
        } else if (type == 5) {
            String photo = "https://cdn.acwing.com/media/article/image/2022/12/09/87795_7ab404b377-%E9%BA%BB%E5%A9%86%E8%B1%86%E8%85%90.jpg ";
            dish = new Bean(null, 5, ingredient, name, photo, price);
        } else if (type == 6) {
            String photo = "https://cdn.acwing.com/media/article/image/2022/12/09/87795_805ddc3477-%E6%B8%85%E7%82%92%E4%B8%8A%E6%B5%B7%E9%9D%92.jpg";
            dish = new Vegetables(null, 6, ingredient, name, photo, price);
        } else if(type == 7) {
            String photo = "https://cdn.acwing.com/media/article/image/2022/12/09/87795_94574e4177-%E8%A5%BF%E7%BA%A2%E6%9F%BF%E7%82%92%E9%B8%A1%E8%9B%8B.jpg";
            dish = new Egg(null, 7, ingredient, name, photo, price);
        } else if(type == 8){
            String photo = "https://cdn.acwing.com/media/article/image/2022/12/09/87795_7f2f6df477-%E7%B1%B3%E9%A5%AD.jpg";
            dish = new Staple(null, 8, ingredient, name, photo, price);
        }
        
        return dish;
    }
}

