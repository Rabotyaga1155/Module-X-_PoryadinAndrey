package com.example.worldcinema_poryadin

import android.content.Intent
import android.text.Editable
import android.view.View
import android.widget.EditText
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(MockitoJUnitRunner::class)
class SignInScreenTest {


    @Mock
    lateinit var mockApiService: ApiService

    @Mock
    lateinit var mockCall: Call<UserResponse>

    @Mock
    lateinit var mockResponse: Response<UserResponse>

    private lateinit var signInScreen: SignInScreen

    var apiService: ApiService
        get() = createDefaultApiService()
        set(value) {}

    private fun createDefaultApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://virtserver.swaggerhub.com/focus.lvlup2021/LEVEL_UP_MOBILE/1.0.0/") // IP Comp
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Before
    fun setUp() {
        signInScreen = SignInScreen()

    }

    @Test
    fun testSuccessfulLogin() {
        val userEmail = "test@example.com"

        `when`(mockApiService.getLogins()).thenReturn(mockCall)
        `when`(mockCall.enqueue(any())).thenAnswer {
            val callback = it.arguments[0] as Callback<UserResponse>
            callback.onResponse(mockCall, mockResponse)
        }

        `when`(mockResponse.isSuccessful).thenReturn(true)
        `when`(mockResponse.body()?.user?.username).thenReturn(userEmail)

        signInScreen.logbut_click(mockView)

        verify(mockView.context).startActivity(any(Intent::class.java))
    }

    companion object {
        // You can use any mock view for testing purposes
        val mockView = mock(View::class.java)
    }
}

