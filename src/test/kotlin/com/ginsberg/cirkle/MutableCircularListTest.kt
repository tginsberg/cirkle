/*
 * MIT License
 *
 * Copyright (c) 2017 Todd Ginsberg
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.ginsberg.cirkle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MutableCircularListTest {

    //Note does inserting to list(1,2,3) at 4 get converted to an add? Does that make sense?

    private val testList = mutableListOf(1, 2, 3).circular()

    @Test
    fun `positive index wraps around`() {
        assertThat(testList[3]).isEqualTo(1)
    }

    @Test
    fun `negative index accesses relative to end of list`() {
        assertThat(testList[-1]).isEqualTo(3)
        assertThat(testList[-2]).isEqualTo(2)
    }

    @Test
    fun `negative indexes wrap around`() {
        assertThat(testList[-6]).isEqualTo(1)
    }

    @Test
    fun `set works with negative indexes`() {
        testList[-1] = 4
        assertThat(testList).containsExactly(1, 2, 4)
    }

    @Test
    fun `set works with negative indexes that wrap around`() {
        testList[-4] = 4
        assertThat(testList).containsExactly(1, 2, 4)
    }

    @Test
    fun `removeAt works with negative indexes`() {
        testList.removeAt(-1)
        assertThat(testList).containsExactly(1, 2)
    }

    @Test
    fun `removeAt works with negative indexes that wrap around`() {
        testList.removeAt(-4)
        assertThat(testList).containsExactly(1, 2)
    }

    @Test
    fun `add works with negative indexes`() {
        testList.add(-1, 4)
        assertThat(testList).containsExactly(1, 2, 4, 3)
    }

    @Test
    fun `add works with negative indexes that wrap around`() {
        testList.add(-4, 4)
        assertThat(testList).containsExactly(1, 2, 4, 3)
    }

    @Test
    fun `addAll works with negative indexes`() {
        testList.addAll(-1, listOf(4, 5, 6))
        assertThat(testList).containsExactly(1, 2, 4, 5, 6, 3)
    }

    @Test
    fun `addAll works with negative indexes that wrap around`() {
        testList.addAll(-4, listOf(4, 5, 6))
        assertThat(testList).containsExactly(1, 2, 4, 5, 6, 3)
    }

    @Test
    fun `listIterator with positive index wraps around`() {
        assertThat(testList.listIterator(4)).containsOnly(2, 3)
    }

    @Test
    fun `listIterator works with negative index`() {
        assertThat(testList.listIterator(-2)).containsOnly(2, 3)
    }

    @Test
    fun `listIterator works with negative index that wraps around`() {
        assertThat(testList.listIterator(-5)).containsOnly(2, 3)
    }

    @Test
    fun `subList with positive index wraps around`() {
        assertThat(testList.subList(3, -1)).containsExactly(1,3,2,1)
    }

    @Test
    fun `subList can lead to longer list than original`() {
        assertThat(testList.subList(0, 4)).containsExactly(1, 2, 3, 1)
    }

    @Test
    fun `subList works with negative index`() {
        assertThat(testList.subList(-3, -1)).containsExactly(1, 2)
    }

    @Test
    fun `subList works with negative index that wraps around`() {
        assertThat(testList.subList(-6, -4)).containsExactly(1, 2)
    }

    @Test
    fun `subList works with a combination of positive and negative indexes`() {
        assertThat(testList.subList(0, -1)).containsExactly(1)
    }

    @Test
    fun `subList works when needing to go around back`() {
        assertThat(testList.subList(2, 4)).containsExactly(3, 1)
    }

    @Test
    fun `toString delegates to list implementation`() {
        assertThat(testList.toString()).isEqualTo("[1, 2, 3]")
    }
}