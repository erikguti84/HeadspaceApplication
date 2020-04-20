package com.example.headspaceapplication.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.headspaceapplication.BaseTest
import com.example.headspaceapplication.model.PicsumResponse
import com.example.headspaceapplication.repository.remote.PicsumService
import com.example.headspaceapplication.testuitils.TestCoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MyViewModelTest : BaseTest() {
    @get:Rule
    var instantTestExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    var testCoroutineRule =
        TestCoroutineRule()
    private lateinit var viewmodel: MyViewModel

    private val picsumService = mockk<PicsumService> {
        coEvery {
            getPictures()
        } returns listOf(PicsumResponse())
    }

    override fun setUp() {
        super.setUp()
        viewmodel = MyViewModel(picsumService)
    }

    @Test
    fun `given VALID query, when fetchPictures called, then update picsumResponse`() {
        // Given
        val mockObserver = createObserver<List<PicsumResponse>>()
        viewmodel.picsumResponse.observeForever(mockObserver)


        // When
        viewmodel.fetchPictures()

        // Then
        val captureList = mutableListOf<List<PicsumResponse>>()
        verify { mockObserver.onChanged(capture(captureList)) }
    }
}