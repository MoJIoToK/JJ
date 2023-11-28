package org.example.task2.food;

import org.example.task2.thing.Thing;

/**
 * Еда
 */
public interface Food extends Thing {

    /**
     * Получить наличие протеинов в еде
     * @return Наличие протеинов
     */
    boolean  getProteins();

    /**
     * Получить наличие жиров в еде
     * @return Наличие жиров
     */
    boolean getFats();

    /**
     * Получить наличие углеводов в еде
     * @return Наличие углеводов
     */
    boolean getCarbohydrates();

}
