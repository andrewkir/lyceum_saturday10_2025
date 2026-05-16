package com.example.lyceum_saturday10_2025.common

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


class UserPrefsManager(
    context: Context
) {
    private val applicationContext = context.applicationContext
    private val prefs: SharedPreferences = applicationContext.getSharedPreferences(
        "hse_lyceum",
        Context.MODE_PRIVATE
    )

    companion object {
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val USERNAME = "username"
    }

    fun clearUser() {
        prefs.edit {
            clear()
        }
    }

    var refreshToken: String?
        get() = prefs.getString(REFRESH_TOKEN, null)
        set(value) {
            prefs.edit {
                putString(REFRESH_TOKEN, value)
            }
        }

    var accessToken: String?
        get() = prefs.getString(ACCESS_TOKEN, null)
        set(value) {
            prefs.edit {
                putString(ACCESS_TOKEN, value)
            }
        }

    var username: String?
        get() = prefs.getString(USERNAME, null)
        set(value) {
            prefs.edit {
                putString(USERNAME, value)
            }
        }
}