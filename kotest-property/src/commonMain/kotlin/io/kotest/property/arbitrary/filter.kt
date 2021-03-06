package io.kotest.property.arbitrary

import io.kotest.property.RandomSource
import io.kotest.property.Sample

/**
 * Create a new [Arb] by keeping only instances of B generated by this gen.
 * This is useful if you have a type hierarchy and only want to retain
 * a particular subtype.
 */
@Suppress("UNCHECKED_CAST")
inline fun <A, reified B : A> Arb<A>.filterIsInstance(): Arb<B> = object : Arb<B> {
   override fun edgecases(): List<B> = this@filterIsInstance.edgecases().filterIsInstance<B>()
   override fun samples(rs: RandomSource): Sequence<Sample<B>> =
      this@filterIsInstance.samples(rs).filterIsInstance<Sample<B>>()
}
