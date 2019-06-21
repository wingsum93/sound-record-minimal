package com.ericho.srm.common.misc

/**
 * Applies a block to the receiver if [condition] is true.
 */
fun <T> T.applyIf(
    condition: Boolean,
    block: T.() -> Unit
): T {
    if (condition) {
        return apply(block)
    }
    return this
}
