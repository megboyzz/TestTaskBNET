package ru.megboyzz.bnet

import com.google.gson.GsonBuilder
import org.junit.Assert.*
import org.junit.Test
import ru.megboyzz.bnet.entities.Field
import ru.megboyzz.bnet.entities.FieldType


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val f =  Field(
            type = FieldType.TextBlock,
            name = "",
            value = "",
            image = "",
            flags = null,
            show = 1,
            group = 0
        )

        val builder = GsonBuilder()
        val gson = builder.create()
        print(gson.toJson(f))
        assert(true)

    }
}