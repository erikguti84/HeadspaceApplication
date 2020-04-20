package com.example.headspaceapplication.model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import java.util.*

class PicsumResponseTest {
    @Test
    fun `given params, when constructor called, then return Definition`() {
        val obj = PicsumResponse(
            author = "author",
            width = 524,
            downloadUrl = "link",
            id = "1",
            url = "link",
            height = 253
        )

        // Then
        assertEquals("author", obj.author)
        assertEquals(524, obj.width)
        assertEquals("link", obj.downloadUrl)
        assertEquals("1", obj.id)
        assertEquals("link", obj.url)
        assertEquals(253, obj.height)
    }
}