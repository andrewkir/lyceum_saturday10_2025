package com.example.lyceum_saturday10_2025.common

import android.content.Context
import com.example.lyceum_saturday10_2025.common.api.TokensApi
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class JWTAuthenticator(
    context: Context,
    private val tokensApi: TokensApi
) : Authenticator {

    private val prefsManager = UserPrefsManager(context)

    override fun authenticate(route: Route?, response: Response): Request? {
        return runBlocking {
            val refreshToken = prefsManager.refreshToken
            try {
                val tokensResponse = tokensApi.refreshAccessToken(refreshToken!!)
                prefsManager.accessToken = tokensResponse.access_token
                prefsManager.refreshToken = tokensResponse.refresh_token

                response.request.newBuilder()
                    .header("Authorization", "Bearer ${tokensResponse.access_token}")
                    .build()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}