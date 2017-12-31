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

package samples

import com.ginsberg.cirkle.circular

class Cirkle {
    class Extensions {

        @Suppress("UNUSED_VARIABLE")
        fun circularListExtension() {
            // Make a List circular
            val cirkle = listOf("a", "b", "c").circular()
        }

        @Suppress("UNUSED_VARIABLE")
        fun mutableCircularListExtension() {
            // Make a MutableList circular
            val cirkle = mutableListOf("a", "b", "c").circular()
        }
    }

    class CircularList {

        @Sample
        fun get() {
            val cirkle = listOf("a", "b", "c").circular()

            // Negative indexing
            println(cirkle[-1]) // "c"

            // Wrap-around positive indexing
            println(cirkle[4]) // "b"

            // Wrap-around negative indexing
            println(cirkle[-4]) // "c"
        }

        @Sample
        fun listIterator() {
            val cirkle = listOf("a", "b", "c").circular()

            println(cirkle.listIterator(-2)) // ["b", "c"]
            println(cirkle.listIterator(4)) // ["b", "c"]
        }

        @Sample
        fun subList() {
            val cirkle = listOf("a", "b", "c").circular()

            println(cirkle.subList(0, -1)) // ["a", "b"]
            println(cirkle.subList(3, -1)) // ["a", "b"]
        }
    }

    class MutableCircularList {

        @Sample
        fun add() {
            val cirkle = mutableListOf("a", "b", "c").circular()

            cirkle.add(-1, "d")
            println(cirkle) // ["a", "b", "d", "c"]
        }

        @Sample
        fun addAll() {
            val cirkle = mutableListOf("a", "b", "c").circular()

            cirkle.addAll(-1, listOf("d", "e"))
            println(cirkle) // ["a", "b", "d", "e", "c"]
        }

        @Sample
        fun get() {
            val cirkle = mutableListOf("a", "b", "c").circular()

            // Negative indexing
            println(cirkle[-1]) // "c"

            // Wrap-around positive indexing
            println(cirkle[4]) // "b"

            // Wrap-around negative indexing
            println(cirkle[-4]) // "c"
        }

        @Sample
        fun listIterator() {
            val cirkle = mutableListOf("a", "b", "c").circular()

            println(cirkle.listIterator(-2)) // ["b", "c"]
            println(cirkle.listIterator(4)) // ["b", "c"]
        }

        @Sample
        fun removeAt() {
            val cirkle = mutableListOf("a", "b", "c").circular()

            cirkle.removeAt(-1)
            println(cirkle) // ["a", "b"]
        }

        @Sample
        fun set() {
            val cirkle = mutableListOf("a", "b", "c").circular()

            cirkle[-1] = "d"
            println(cirkle) // ["a", "b", "d"]
        }

        @Sample
        fun subList() {
            val cirkle = mutableListOf("a", "b", "c").circular()

            println(cirkle.subList(0, -1)) // ["a", "b"]
            println(cirkle.subList(3, -1)) // ["a", "b"]
        }
    }
}