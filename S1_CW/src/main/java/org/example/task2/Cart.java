package org.example.task2;

import org.example.task2.food.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food>{

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs(){
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */
    public void cardBalancing() {

        AtomicInteger check = new AtomicInteger(0);

        boolean proteins = getFPC(Food::getProteins, check);
        boolean fats = getFPC(food -> food.getFats(), check);
        boolean carbohydrates = getFPC(Food::getCarbohydrates, check);

        String balance = " ";
        if (check.get() == 3){
            balance = " уже ";
        }
        if (proteins && fats && carbohydrates){
            System.out.printf("Корзина%sсбалансирована по БЖУ.\n", balance);
        } else
            System.out.println("Корзина не сбалансирована по БЖУ.");
    }


    private boolean getFPC(Predicate<Food> predicate, AtomicInteger check) {
        if (foodstuffs.stream().noneMatch(predicate)){
            return foodstuffs.add((T) market.getThings(Food.class).stream()
                    .filter(predicate)
                    .findAny()
                    .get());
        }
        else {
            check.incrementAndGet();
            return true;
        }
    }


//        AtomicBoolean proteins = new AtomicBoolean(false);
//        AtomicBoolean fats = new AtomicBoolean(false);
//        AtomicBoolean carbohydrates = new AtomicBoolean(false);
//
//        foodstuffs.stream()
//                .forEach(prod ->{
//                    if (prod.getProteins() && !proteins.get()) proteins.set(true);
//                    else if (prod.getFats() && !fats.get()) fats.set(true);
//                    else if (prod.getCarbohydrates() && !carbohydrates.get()) carbohydrates.set(true);
//                    if (proteins.get() && fats.get() && carbohydrates.get()) return;
//                });
//
////        for (var food : foodstuffs)
////        {
////            if (!proteins.get() && food.getProteins())
////                proteins.set(true);
////            else
////            if (!fats.get() && food.getFats())
////                fats.set(true);
////            else
////            if (!carbohydrates.get() && food.getCarbohydrates())
////                carbohydrates.set(true);
////            if (proteins.get() && fats.get() && carbohydrates.get())
////                break;
////        }
////
//        if (proteins.get() && fats.get() && carbohydrates.get())
//        {
//            System.out.println("Корзина уже сбалансирована по БЖУ.");
//            return;
//        }
//
//        for (var thing : market.getThings(Food.class))
//        {
//            if (!proteins.get() && thing.getProteins())
//            {
//                proteins.set(true);
//                foodstuffs.add((T)thing);
//            }
//            else if (!fats.get() && thing.getFats())
//            {
//                fats.set(true);
//                foodstuffs.add((T)thing);
//            }
//            else if (!carbohydrates.get() && thing.getCarbohydrates())
//            {
//                carbohydrates.set(true);
//                foodstuffs.add((T)thing);
//            }
//            if (proteins.get() && fats.get() && carbohydrates.get())
//                break;
//        }
//
//        if (proteins.get() && fats.get() && carbohydrates.get())
//            System.out.println("Корзина сбалансирована по БЖУ.");
//        else
//            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
//
//    }

}
