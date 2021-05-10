package com.ammar.nutritionanalysis.utils


import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun CoroutineScope.launchCatching(
    onError: (Throwable) -> Unit = { Log.e("launchCatching", "${it.message}") },
    context: CoroutineContext = coroutineContext,
    block: suspend () -> Unit,
): Job {
    return launch(context) { runSuspended(onError, block) }
}

suspend fun runSuspended(
    onError: (Throwable) -> Unit = { Log.e("runSuspended", "${it.message}") },
    block: suspend () -> Unit,
) {
    runCatching { block() }.onFailure(onError)
}
