package kioli.clean

import org.mockito.Mockito

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)

inline fun <reified T> stub() = Mockito.mock(T::class.java, Mockito.withSettings().stubOnly())