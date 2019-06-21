package com.ericho.srm.common.misc

/**
 * If the receiver equals [whenIs], then return [shouldReturn]. Else return the value of
 * the receiver.
 */
fun Int.otherwise(
    whenIs: Int = 0,
    shouldReturn: Int
) = if (this == whenIs) {
    shouldReturn
} else {
    this
}
