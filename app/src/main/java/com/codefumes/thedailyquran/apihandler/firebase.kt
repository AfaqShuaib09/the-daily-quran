package com.codefumes.thedailyquran.apihandler

import com.google.android.gms.auth.api.signin.GoogleSignInOptions

fun signInUser() {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestEmail()
        .build()
}