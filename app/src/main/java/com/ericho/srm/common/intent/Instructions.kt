package com.ericho.srm.common.intent

import android.content.Intent

typealias Execution = (Intent) -> Unit


sealed class Instructions {

    /** Return true if an Intent matches the instruction. */
    abstract fun matches(intent: Intent): Boolean

    /** The block to execute of [matches] returns true. */
    abstract fun execution(): Execution

    /** An instruction which matches intent actions. */
    data class OnAction(
        val action: String,
        val execution: Execution
    ) : Instructions() {

        override fun matches(intent: Intent): Boolean {
            return intent.action == action
        }

        override fun execution() = execution
    }

    /** An instruction which matches intent data schemes. */
    data class OnDataScheme(
        val scheme: String,
        val execution: Execution
    ) : Instructions() {
        override fun matches(intent: Intent): Boolean {
            return intent.data?.scheme == scheme
        }

        override fun execution() = execution
    }

    /** An instruction which matches intent categories. */
    data class OnCategory(
        val category: String,
        val execution: Execution
    ) : Instructions() {
        override fun matches(intent: Intent): Boolean {
            return intent.hasCategory(category)
        }

        override fun execution() = execution
    }
}
