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
package org.spongepowered.api.item.inventory.aspects;

import org.spongepowered.api.item.inventory.InventoryAspect;
import org.spongepowered.api.util.Coerce;

/**
 * A generic String aspect for an inventory.
 */
public class StringAspect extends AbstractInventoryAspect<String, String> {

    /**
     * Create a new String aspect for matching the specified value.
     * 
     * @param value the value to match
     */
    public StringAspect(String value) {
        super(value);
    }

    /**
     * Create a new String aspect for matching the specified value with the
     * specified operator.
     * 
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public StringAspect(String value, Operator operator) {
        super(value, operator);
    }

    /**
     * Create a new String aspect for matching the specified value with the
     * specified operator.
     * 
     * @param value the value to match
     * @param operator the operator to use when comparing with other properties
     */
    public StringAspect(Object value, Operator operator) {
        super(Coerce.toString(value), operator);
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(InventoryAspect<?, ?> other) {
        if (other == null) {
            return 1;
        }

        return this.getValue().compareTo(Coerce.toString(other.getValue()));
    }

    /**
     * Create a Stringaspect aspect which matches Stringaspect properties
     * with equal value.
     * 
     * @param value the value to match
     * @return new aspect
     */
    public static StringAspect of(Object value) {
        return new StringAspect(value, Operator.EQUAL);
    }

    /**
     * Create a Stringaspect aspect which matches Stringaspect properties
     * with unequal value.
     * 
     * @param value the value to match
     * @return new aspect
     */
    public static StringAspect not(Object value) {
        return new StringAspect(value, Operator.NOTEQUAL);
    }

    /**
     * Create a Stringaspect aspect which matches Stringaspect properties
     * with value greater than this value.
     * 
     * @param value the value to match
     * @return new aspect
     */
    public static StringAspect greaterThan(Object value) {
        return new StringAspect(value, Operator.GREATER);
    }

    /**
     * Create a Stringaspect aspect which matches Stringaspect properties
     * with value greater than or equal to this value.
     * 
     * @param value the value to match
     * @return new aspect
     */
    public static StringAspect greaterThanOrEqual(Object value) {
        return new StringAspect(value, Operator.GEQUAL);
    }

    /**
     * Create a Stringaspect aspect which matches Stringaspect properties
     * with value less than this value.
     * 
     * @param value the value to match
     * @return new aspect
     */
    public static StringAspect lessThan(Object value) {
        return new StringAspect(value, Operator.LESS);
    }

    /**
     * Create a Stringaspect aspect which matches Stringaspect properties
     * with value less than or equal to this value.
     * 
     * @param value the value to match
     * @return new aspect
     */
    public static StringAspect lessThanOrEqual(Object value) {
        return new StringAspect(value, Operator.LEQUAL);
    }

}
