/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.item.aspects;

import org.spongepowered.api.util.Coerce;

/**
 * Represents an item aspect that has an integer value. Examples may include
 * {@link FoodRestorationAspect}, {@link SaturationAspect} etc.
 */
public class DoubleAspect extends AbstractItemAspect<String, Double> {


    /**
     * Create a new integer aspect with the specified value.
     *
     * @param value value to match
     */
    public DoubleAspect(double value) {
        super(Coerce.toDouble(value));
    }

    /**
     * Create a new integer aspect with the specified value and logical
     * operator.
     *
     * @param value value to match
     * @param operator logical operator to use when comparing to other
     *      properties
     */
    public DoubleAspect(double value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new integer aspect with the specified value and logical
     * operator.
     *
     * @param value value to match
     * @param operator logical operator to use when comparing to other
     *      properties
     */
    public DoubleAspect(Object value, Operator operator) {
        super(Coerce.toDouble(value), operator);
    }

    @Override
    public int compareTo(ItemAspect<?, ?> other) {
        return this.getValue().compareTo(other == null ? 1 : Coerce.toDouble(other.getValue()));
    }

    /**
     * Create an DoubleAspect aspect which matches DoubleAspect properties with
     * equal value.
     *
     * @param value value to match
     * @return new aspect
     */
    public static DoubleAspect of(Object value) {
        return new DoubleAspect(value, Operator.EQUAL);
    }

    /**
     * Create an DoubleAspect aspect which matches DoubleAspect properties with
     * unequal value.
     *
     * @param value value to match
     * @return new aspect
     */
    public static DoubleAspect not(Object value) {
        return new DoubleAspect(value, Operator.NOTEQUAL);
    }

    /**
     * Create an DoubleAspect aspect which matches DoubleAspect properties with
     * value greater than this value.
     *
     * @param value value to match
     * @return new aspect
     */
    public static DoubleAspect greaterThan(Object value) {
        return new DoubleAspect(value, Operator.GREATER);
    }

    /**
     * Create an DoubleAspect aspect which matches DoubleAspect properties with
     * value greater than or equal to this value.
     *
     * @param value value to match
     * @return new aspect
     */
    public static DoubleAspect greaterThanOrEqual(Object value) {
        return new DoubleAspect(value, Operator.GEQUAL);
    }

    /**
     * Create an DoubleAspect aspect which matches DoubleAspect properties with
     * value less than this value.
     *
     * @param value value to match
     * @return new aspect
     */
    public static DoubleAspect lessThan(Object value) {
        return new DoubleAspect(value, Operator.LESS);
    }

    /**
     * Create an DoubleAspect aspect which matches DoubleAspect properties with
     * value less than or equal to this value.
     *
     * @param value value to match
     * @return new aspect
     */
    public static DoubleAspect lessThanOrEqual(Object value) {
        return new DoubleAspect(value, Operator.LEQUAL);
    }


}
